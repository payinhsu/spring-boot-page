package com.poseitech.integration.playngo.service.imp;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.Map;

import com.poseitech.exceptions.ErrorCodeResovler;
import com.poseitech.integration.playngo.dao.SkyUserDao;
import com.poseitech.integration.playngo.entity.SkyUser;
import com.poseitech.integration.playngo.model.*;
import com.poseitech.integration.playngo.util.ObjectUtils;
import com.poseitech.integration.playngo.ws.client.model.user.*;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axis2.AxisFault;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.poseitech.integration.playngo.service.PlaynGoException;
import com.poseitech.integration.playngo.service.PlaynGoService;
import com.poseitech.integration.playngo.ws.client.model.OpenGameId;
import com.poseitech.integration.playngo.ws.client.model.appendix.Money;
import com.poseitech.integration.playngo.ws.client.util.WSBeanUtils;
import com.poseitech.integration.playngo.ws.client.v1.CasinoGameServiceStub;

/**
 * @author B.J Lin
 *
 */
@Service
public class PlaynGoServiceImp implements PlaynGoService {
   private static Logger log = LoggerFactory.getLogger(PlaynGoServiceImp.class);

   @Value("${poseitech.integration.playngo.service-endpoint}")
   private String playnGoServiceEndPoint;
   @Value("${poseitech.integration.playngo.archievement-folder}")
   private String directoryPath;

   @Autowired
   private CasinoGameServiceStub casinoGameServiceStub;

   @Autowired
   private SkyUserDao skyUserDao;

   @Override
   public boolean register(PlaynGoUser pUser) throws PlaynGoException {
      try {
         // call PlaynGo register api
         RegisterUser registerUser = WSBeanUtils.parseToRegisterUser(pUser);
         log.info("register start --> input:{}", registerUser.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         RegisterUserResponse registerUserResponse = casinoGameServiceStub.registerUser(registerUser);
         log.info("register end --> input:{}",
               registerUserResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         return true;
      } catch (AxisFault axisFault) {
         log.error("web service error:{}", axisFault.getMessage());
         throw new PlaynGoException("60ERR99999", axisFault.getMessage(), RegisterUser.MY_QNAME.getNamespaceURI());
      } catch (Exception e) {
         log.error(e.getMessage(), e);
         throw new PlaynGoException(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION, e.getMessage(),
               RegisterUser.MY_QNAME.getNamespaceURI());
      }

   }

   @Override
   public PlaynGoBalance credit(PlaynGoUser pUser, PlaynGoBalance pBalance) throws PlaynGoException {
      Long userId = pUser.getId();
      Double transferAmount = pBalance.getTransferAmount();

      // 3. call PlanGo credit api
      PlaynGoBalance rtnPlaynGoBalance = pBalance;
      try {
         log.info("user id:{}, game account:{}", userId, pUser.getGameAccount());
         Credit credit = new Credit();
         credit.setExternalUserId(pUser.getGameAccount());
         credit.setAmount(new BigDecimal(transferAmount));
         credit.setCurrency("CNY");
         credit.setExternalTransactionId(pBalance.getSn());
         log.info("credit start --> input:{}", credit.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         CreditResponse creditResponse = casinoGameServiceStub.credit(credit);
         log.info("credit end --> input:{}", creditResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         long transactionId = creditResponse.getTransactionId();
         log.info("web service credit success...transactionId is {}", transactionId);
         rtnPlaynGoBalance.setExTransId(transactionId);

      } catch (AxisFault axisFault) {
         log.error("web service error:{}", axisFault.getMessage());
         throw new PlaynGoException("60ERR99999", axisFault.getMessage(), playnGoServiceEndPoint);
      } catch (Exception e) {
         log.error("web service error:{}", e);
         throw new PlaynGoException(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION, e.getMessage(),
               playnGoServiceEndPoint);
      }

      return rtnPlaynGoBalance;
   }

   @Override
   public PlaynGoBalance debit(PlaynGoUser pUser, PlaynGoBalance pBalance) throws PlaynGoException {
      try {

         Debit debit = new Debit();
         debit.setExternalUserId(pUser.getGameAccount());
         debit.setAmount(BigDecimal.valueOf(pBalance.getTransferAmount()));
         debit.setCurrency("CNY");
         debit.setExternalTransactionId(pBalance.getSn());

         log.info("debit start --> input:{}", debit.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         DebitResponse debitResponse = casinoGameServiceStub.debit(debit);
         log.info("debit end --> input:{}", debitResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         long transactionId = debitResponse.getTransactionId();
         log.info("web service Debit success...transactionId is {}", transactionId);
         pBalance.setExTransId(transactionId);

      } catch (AxisFault axisFault) {
         log.error("web service error:{}", axisFault.getMessage());
         throw new PlaynGoException("60ERR99999", axisFault.getMessage(), playnGoServiceEndPoint);
      } catch (Exception e) {
         log.error(e.getMessage(), e);
         throw new PlaynGoException(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION, e.getMessage(),
               playnGoServiceEndPoint);
      }

      return pBalance;
   }

   @Override
   public PlaynGoBalance getBalance(PlaynGoUser pUser) throws PlaynGoException {
      return getBalance(pUser.getGameAccount());
   }

   @Override
   public PlaynGoBalance getBalance(String pExternalUserId) throws PlaynGoException {
      try {
         Balance balance = new Balance();
         balance.setExternalUserId(pExternalUserId);

         log.info("getBalance start --> input:{}", balance.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         BalanceResponse wsResponse = casinoGameServiceStub.balance(balance);
         log.info("getBalance end --> input:{}", wsResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         PlaynGoBalance playnGoBalance = new PlaynGoBalance();
         playnGoBalance.setTotal(wsResponse.getUserBalance().getReal().doubleValue());
         return playnGoBalance;

      } catch (AxisFault axisFault) {
         log.error("web service error:{}", axisFault.getMessage());
         throw new PlaynGoException("60ERR99999", axisFault.getMessage(), playnGoServiceEndPoint);
      } catch (Exception e) {
         log.error(e.getMessage(), e);
         throw new PlaynGoException(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION, e.getMessage(),
               playnGoServiceEndPoint);
      }
   }

   @Override
   public String getTicket(String pExternalUserId) throws PlaynGoException {
      try {

         GetTicket ticketRequest = new GetTicket();
         ticketRequest.setExternalUserId(pExternalUserId);

         log.info("getTicket start --> input:{}",
               ticketRequest.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         GetTicketResponse ticketResponse = casinoGameServiceStub.getTicket(ticketRequest);
         log.info("getTicket end --> input:{}",
               ticketResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         return ticketResponse.getTicket();

      } catch (AxisFault axisFault) {
         log.error("web service[getTicket] error:{}", axisFault.getMessage());
         throw new PlaynGoException("60ERR99999", axisFault.getMessage(), playnGoServiceEndPoint);

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         throw new PlaynGoException(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION, e.getMessage(),
               playnGoServiceEndPoint);
      }
   }

   @Override
   public List<PlaynGoOpenGame> getUnfinishedGames(String pExternalUserId) throws PlaynGoException {
      try {

         GetUnfinishedGames unfinishedGames = new GetUnfinishedGames();
         unfinishedGames.setExternalId(pExternalUserId);

         log.info("getUnfinishedGames start --> input:{}",
               unfinishedGames.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         GetUnfinishedGamesResponse unfinishedGamesResponse = casinoGameServiceStub.getUnfinishedGames(unfinishedGames);
         log.info("getUnfinishedGames end --> input:{}",
               unfinishedGamesResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         OpenGameId[] openGameIds = unfinishedGamesResponse.getOpenGameIds().getOpenGameId();
         List<PlaynGoOpenGame> ls = new ArrayList<PlaynGoOpenGame>();
         if (openGameIds != null) {
            for (OpenGameId openGame : openGameIds) {
               PlaynGoOpenGame playnGoOpenGame = new PlaynGoOpenGame();
               playnGoOpenGame.setGameId(openGame.getGameId());
               playnGoOpenGame.setGameName(openGame.getGameName());
               playnGoOpenGame.setGameType(openGame.getGameType());
               playnGoOpenGame.setGid(openGame.getGid());
               playnGoOpenGame.setMobileGame(openGame.getMobileGame());
               playnGoOpenGame.setSerialized(openGame.getSerialized());
               Money money = openGame.getBet();
               playnGoOpenGame.setCurrency(money.getCurrency().getValue());
               playnGoOpenGame.setBet(new Double(money.getValue()));
               ls.add(playnGoOpenGame);
            }
         }

         return ls;

      } catch (AxisFault axisFault) {
         log.error("web service[getTicket] error:{}", axisFault.getMessage());
         throw new PlaynGoException("60ERR99999", axisFault.getMessage(), playnGoServiceEndPoint);

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         throw new PlaynGoException(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION, e.getMessage(),
               playnGoServiceEndPoint);
      }
   }

   @Override
   public List<AchievementConfiguration> getAchievements(AchievementArguments achievementArguments)
         throws PlaynGoException {
      try {
         GetAchievements getAchievements = new GetAchievements();

         if (AchievementFilterType.Active.equals(achievementArguments.getStatus())) {
            getAchievements.setStatus(AchievementFilterType.Active);
         } else if (AchievementFilterType.Future.equals(achievementArguments.getStatus())) {
            getAchievements.setStatus(AchievementFilterType.Future);
         } else if (AchievementFilterType.Historical.equals(achievementArguments.getStatus())) {
            getAchievements.setStatus(AchievementFilterType.Historical);
         } else if (AchievementFilterType.None.equals(achievementArguments.getStatus())) {
            getAchievements.setStatus(AchievementFilterType.None);
         }

         if (achievementArguments.getSkip() != null) {
            getAchievements.setSkip(achievementArguments.getSkip());
         }
         if (achievementArguments.getTriggerId() != null) {
            getAchievements.setTriggerId(achievementArguments.getTriggerId());
         }
         if (achievementArguments.getTake() != null) {
            getAchievements.setTake(achievementArguments.getTake());
         }

         log.info("getAchievements start --> input:{}",
               getAchievements.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         GetAchievementsResponse getAchievementsResponse = casinoGameServiceStub.getAchievements(getAchievements);
         log.info("getAchievements end --> input:{}",
               getAchievementsResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         AchievementConfiguration[] achievementConfigurations = getAchievementsResponse.getAchievements()
               .getAchievementConfiguration();
         List<AchievementConfiguration> ls = new ArrayList<>();

         if (achievementConfigurations != null) {
            for (AchievementConfiguration achievementConfiguration : achievementConfigurations) {
               ls.add(achievementConfiguration);
            }
         }
         return ls;

      } catch (AxisFault axisFault) {
         log.error("web service[getAchievements] error:{}", axisFault.getMessage());
         throw new PlaynGoException("60ERR99999", axisFault.getMessage(), playnGoServiceEndPoint);

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         throw new PlaynGoException(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION, e.getMessage(),
               playnGoServiceEndPoint);
      }
   }

   @Override
   public List<Object> getAchievementSummary(AchievementArguments achievementArguments) throws PlaynGoException {
      try {
         GetAchievementSummary getAchievementSummary = new GetAchievementSummary();
         Calendar fromCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
         fromCalendar.setTimeInMillis(achievementArguments.getFromDate().longValue());
         getAchievementSummary.setFromDate(fromCalendar);

         Calendar toCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
         toCalendar.setTimeInMillis(achievementArguments.getToDate().longValue());
         getAchievementSummary.setToDate(toCalendar);
         getAchievementSummary.setAchievementName(achievementArguments.getAchievementName());

         if (achievementArguments.getBrandId() != null) {
            getAchievementSummary.setBrandId(achievementArguments.getBrandId());
         }
         if (achievementArguments.getTake() != null) {
            getAchievementSummary.setTake(achievementArguments.getTake());
         }

         log.info("getAchievementSummary start --> input:{}",
               getAchievementSummary.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         GetAchievementSummaryResponse getAchievementSummaryResponse = casinoGameServiceStub
               .getAchievementSummary(getAchievementSummary);
         log.info("getAchievementSummary end --> input:{}",
               getAchievementSummaryResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         AchievementsSummary[] achievementsSummarys = getAchievementSummaryResponse.getAchievementSummary()
               .getAchievementsSummary();
         List<Object> ls = new ArrayList<>();

         if (achievementsSummarys != null) {
            for (AchievementsSummary achievementsSummary : achievementsSummarys) {
               if (achievementsSummary.getExternalId().indexOf("fa") == 0) {
                  AchievementsResponse achievementsResponse = new AchievementsResponse();
                  achievementsResponse.setBrandId(achievementsSummary.getBrandId());
                  achievementsResponse.setExternalId(achievementsSummary.getExternalId().substring(2));
                  achievementsResponse.setName(achievementsSummary.getName());
                  achievementsResponse.setPoints(achievementsSummary.getPoints());
                  achievementsResponse.setNickname(achievementsSummary.getNickname());
                  ls.add(achievementsResponse);
               }
            }
         } else {
            return ls;
         }
         // wirte file
         wirteObjectToFile(ls, ObjectUtils.getClassName(ls.get(0)) + ".ser");
         // read file
         List<Object> readObjectToFile = readObjectToFile(ObjectUtils.getClassName(ls.get(0)) + ".ser");
         return getObjectUserName(readObjectToFile);

      } catch (AxisFault axisFault) {
         log.error("web service[AchievementsSummary] error:{}", axisFault.getMessage());
         throw new PlaynGoException("60ERR99999", axisFault.getMessage(), playnGoServiceEndPoint);

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         throw new PlaynGoException(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION, e.getMessage(),
               playnGoServiceEndPoint);
      }
   }

   @Override
   public List<Object> getTriggeredAchievements(AchievementArguments achievementArguments) throws PlaynGoException {
      try {
         GetTriggeredAchievements getTriggeredAchievements = new GetTriggeredAchievements();

         Calendar fromCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
         fromCalendar.setTimeInMillis(achievementArguments.getFromDate().longValue());
         getTriggeredAchievements.setFromDate(fromCalendar);

         Calendar toCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
         toCalendar.setTimeInMillis(achievementArguments.getToDate().longValue());
         getTriggeredAchievements.setToDate(toCalendar);

         if (achievementArguments.getBrandId() != null) {
            getTriggeredAchievements.setBrandId(achievementArguments.getBrandId());
         }
         if (achievementArguments.getGameId() != null) {
            getTriggeredAchievements.setGameId(achievementArguments.getGameId());
         }
         if (achievementArguments.getAchievementName() != null) {
            getTriggeredAchievements.setAchievementName(achievementArguments.getAchievementName());
         }
         if (achievementArguments.getTriggerId() != null) {
            getTriggeredAchievements.setTriggerId(achievementArguments.getTriggerId());
         }
         if (achievementArguments.getTake() != null) {
            getTriggeredAchievements.setTake(achievementArguments.getTake());
         }

         log.info("getTriggeredAchievements start --> input:{}",
               getTriggeredAchievements.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         GetTriggeredAchievementsResponse getTriggeredAchievementsResponse = casinoGameServiceStub
               .getTriggeredAchievements(getTriggeredAchievements);
         log.info("getTriggeredAchievements end --> input:{}",
               getTriggeredAchievementsResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         AchievementsTrigger[] achievementsTriggers = getTriggeredAchievementsResponse.getTriggeredAchievements()
               .getAchievementsTrigger();
         List<Object> ls = new ArrayList<>();

         if (achievementsTriggers != null) {
            for (AchievementsTrigger achievementsTrigger : achievementsTriggers) {
               if (achievementsTrigger.getExternalId().indexOf("fa") == 0) {
                  AchievementsResponse achievementsResponse = new AchievementsResponse();
                  achievementsResponse.setBrandId(achievementsTrigger.getBrandId());
                  achievementsResponse.setExternalId(achievementsTrigger.getExternalId().substring(2));
                  achievementsResponse.setCount(achievementsTrigger.getCount());
                  achievementsResponse.setDescription(achievementsTrigger.getDescription());
                  achievementsResponse.setFreegameTriggerId(achievementsTrigger.getFreegameTriggerId());
                  achievementsResponse.setGameId(achievementsTrigger.getGameId());
                  achievementsResponse.setName(achievementsTrigger.getName());
                  achievementsResponse.setParentName(achievementsTrigger.getParentName());
                  achievementsResponse.setPoints(achievementsTrigger.getPoints());
                  achievementsResponse.setTime(achievementsTrigger.getTime());
                  achievementsResponse.setResultId(achievementsTrigger.getResultId());
                  achievementsResponse.setRoundId(achievementsTrigger.getRoundId());
                  achievementsResponse.setSpin(achievementsTrigger.getSpin());

                  ls.add(achievementsResponse);
               }
            }
         } else {
            return ls;
         }
         // wirte file
         wirteObjectToFile(ls, ObjectUtils.getClassName(ls.get(0)) + ".ser");
         // read file
         List<Object> readObjectToFile = readObjectToFile(ObjectUtils.getClassName(ls.get(0)) + ".ser");
         return getObjectUserName(readObjectToFile);

      } catch (AxisFault axisFault) {
         log.error("web service[getTriggeredAchievements] error:{}", axisFault.getMessage());
         throw new PlaynGoException("60ERR99999", axisFault.getMessage(), playnGoServiceEndPoint);

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         throw new PlaynGoException(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION, e.getMessage(),
               playnGoServiceEndPoint);
      }
   }

   @Override
   public List<Object> getTriggeredAchievementsByPlayer(AchievementArguments achievementArguments)
         throws PlaynGoException {
      try {
         GetTriggeredAchievementsByPlayer getTriggeredAchievementsByPlayer = new GetTriggeredAchievementsByPlayer();

         getTriggeredAchievementsByPlayer.setExternalId(achievementArguments.getExternalId());

         Calendar fromCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
         fromCalendar.setTimeInMillis(achievementArguments.getFromDate().longValue());
         getTriggeredAchievementsByPlayer.setFromDate(fromCalendar);

         Calendar toCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
         toCalendar.setTimeInMillis(achievementArguments.getToDate().longValue());
         getTriggeredAchievementsByPlayer.setToDate(toCalendar);

         if (achievementArguments.getGameId() != null) {
            getTriggeredAchievementsByPlayer.setGameId(achievementArguments.getGameId());
         }
         if (achievementArguments.getAchievementName() != null) {
            getTriggeredAchievementsByPlayer.setAchievementName(achievementArguments.getAchievementName());
         }
         if (achievementArguments.getTriggerId() != null) {
            getTriggeredAchievementsByPlayer.setTriggerId(achievementArguments.getTriggerId());
         }

         log.info("getTriggeredAchievementsByPlayer start --> input:{}",
               getTriggeredAchievementsByPlayer.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         GetTriggeredAchievementsByPlayerResponse getTriggeredAchievementsByPlayerResponse = casinoGameServiceStub
               .getTriggeredAchievementsByPlayer(getTriggeredAchievementsByPlayer);
         log.info("getTriggeredAchievementsByPlayer end --> input:{}",
               getTriggeredAchievementsByPlayerResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         PlayerAchievementsTrigger[] playerAchievementsTriggers = getTriggeredAchievementsByPlayerResponse
               .getTriggeredAchievements().getPlayerAchievementsTrigger();
         List<Object> ls = new ArrayList<>();

         if (playerAchievementsTriggers != null) {
            for (PlayerAchievementsTrigger playerAchievementsTrigger : playerAchievementsTriggers) {
               if (achievementArguments.getExternalId().indexOf("fa") == 0) {
                  AchievementsResponse achievementsResponse = new AchievementsResponse();
                  achievementsResponse.setExternalId(achievementArguments.getExternalId().substring(2));
                  achievementsResponse.setTime(playerAchievementsTrigger.getTime());
                  achievementsResponse.setParentName(playerAchievementsTrigger.getParentName());
                  achievementsResponse.setGameId(playerAchievementsTrigger.getGameId());
                  achievementsResponse.setRoundId(playerAchievementsTrigger.getRoundId());
                  achievementsResponse.setName(playerAchievementsTrigger.getName());
                  achievementsResponse.setSpin(playerAchievementsTrigger.getSpin());
                  achievementsResponse.setResultId(playerAchievementsTrigger.getResultId());
                  achievementsResponse.setPoints(playerAchievementsTrigger.getPoints());
                  achievementsResponse.setCount(playerAchievementsTrigger.getCount());
                  achievementsResponse.setFreegameTriggerId(playerAchievementsTrigger.getFreegameTriggerId());
                  ls.add(achievementsResponse);
               }
            }
         } else {
            return ls;
         }
         // wirte file
         wirteObjectToFile(ls, ObjectUtils.getClassName(ls.get(0)) + ".ser");
         // read file
         List<Object> readObjectToFile = readObjectToFile(ObjectUtils.getClassName(ls.get(0)) + ".ser");
         return getObjectUserName(readObjectToFile);

      } catch (AxisFault axisFault) {
         log.error("web service[getTriggeredAchievementsByPlayer] error:{}", axisFault.getMessage());
         throw new PlaynGoException("60ERR99999", axisFault.getMessage(), playnGoServiceEndPoint);

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         throw new PlaynGoException(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION, e.getMessage(),
               playnGoServiceEndPoint);
      }
   }

   @Override
   public String getUserName(String account) throws PlaynGoException {
      StringBuffer name = new StringBuffer();
      try {
         String[] nameList = { account };
         List<SkyUser> userList = skyUserDao.getUsersByName(nameList);
         if (userList != null && userList.size() > 0) {
            name.append(userList.get(0).getLastName()).append(userList.get(0).getGender());
         }

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         throw new PlaynGoException(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION, e.getMessage(),
               playnGoServiceEndPoint);
      }
      return name.toString();
   }

   private List<Object> getObjectUserName(final List<Object> readFileList) {
      List<Object> newResponses = new ArrayList<>();
      List<String> nameList = new ArrayList<>();

      readFileList.stream().forEach(response -> {
         Map<String, Object> objectMap = null;
         try {
            objectMap = ObjectUtils.getFieldNamesAndValues(response, false);
         } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
         }
         nameList.add((String) objectMap.get("externalId"));
      });

      List<SkyUser> userList = skyUserDao.getUsersByName(nameList.toArray(new String[0]));

      readFileList.stream().forEach(response -> {
         userList.forEach(user -> {
            try {
               Map<String, Object> objectMap = ObjectUtils.getFieldNamesAndValues(response, false);
               if (user.getName().equals(objectMap.get("externalId"))) {
                  if (StringUtils.isNoneBlank(user.getLastName()) && StringUtils.isNoneBlank(user.getGender())) {
                     newResponses
                           .add(ObjectUtils.setFieldValue(response, "userName", user.getLastName() + user.getGender()));
                  } else {
                     newResponses.add(ObjectUtils.setFieldValue(response, "userName", user.getName()));
                  }
               }
            } catch (IllegalAccessException e) {
               log.error(e.getMessage(), e);
            } catch (NoSuchFieldException e1) {
               log.error(e1.getMessage(), e1);
            } catch (InstantiationException e2) {
               log.error(e2.getMessage(), e2);
            }
         });
      });

      return newResponses;
   }

   private void wirteObjectToFile(final List<Object> objectList, String fileName) {
      File file = new File(directoryPath);
      if (!file.exists()) {
         file.mkdir();
      }
      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(directoryPath + fileName))) {
         oos.writeObject(objectList);
      } catch (Exception ex) {
         log.error(ex.getMessage(), ex);
      }
   }

   private List<Object> readObjectToFile(String fileName) {
      List<Object> objectList = new ArrayList<>();
      FileInputStream fis = null;
      ObjectInputStream ins = null;
      try {
         fis = new FileInputStream(directoryPath + fileName);
         ins = new ObjectInputStream(fis);
         objectList.addAll((List<Object>) ins.readObject());
      } catch (Exception ex) {
         log.error(ex.getMessage(), ex);
      } finally {
         try {
            if (fis != null) {
               fis.close();
            }
            if (ins != null) {
               ins.close();
            }
         } catch (IOException e) {
            log.error(e.getMessage(), e);
         }
      }
      return objectList;
   }

}
