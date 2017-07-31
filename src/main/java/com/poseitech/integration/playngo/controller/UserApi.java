package com.poseitech.integration.playngo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.poseitech.integration.playngo.model.*;
import com.poseitech.integration.playngo.ws.client.model.user.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.poseitech.exceptions.ErrorCodeResovler;
import com.poseitech.integration.message.ResponsePayload;
import com.poseitech.integration.playngo.service.PlaynGoException;
import com.poseitech.integration.playngo.service.PlaynGoService;
import com.poseitech.lang.Assert;

@Controller
@RequestMapping("/${poseitech.api.version}/${poseitech.api.resource-name}")
public class UserApi {

   private static Logger log = LoggerFactory.getLogger(UserApi.class);

   @Autowired
   private PlaynGoService playnGoService;

   /**
    * 註冊會員 <br>
    * link: http://localhost:18080/chaofan2png/v1/playngo/users?method=c
    * 
    * @param pPlaynGoUser
    *           必填欄位：id、playerAccount、gamePlatformId、gameAccount、genderCode(m:
    *           Male/f:Female)、btd(yyyyMMdd)、
    *           regDate(yyyyMMdd)、ip、nickName、userName、brandId
    * @return
    */
   // @RequestMapping(value="/users", produces={"application/json"}, consumes =
   // {"application/json"}, params={"method=c"}, method={RequestMethod.POST})
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsePayload<PlaynGoUser> register(@RequestBody PlaynGoUser pPlaynGoUser) {
      log.info("register start...");
      ResponsePayload<PlaynGoUser> payload = new ResponsePayload<PlaynGoUser>();
      try {
         // 必填欄位驗證
         String btd = pPlaynGoUser.getBtd();
         String regDate = pPlaynGoUser.getRegDate();
         String genderCode = pPlaynGoUser.getGenderCode();
         Assert.isTrue(StringUtils.isNotBlank(btd), "input data[btd] must not be empty");
         Assert.isTrue(StringUtils.isNotBlank(regDate), "input data[regDate] must not be empty");
         Assert.isTrue(StringUtils.isNotBlank(genderCode), "input data[genderCode] must not be empty");
         Assert.isTrue(StringUtils.isNotBlank(pPlaynGoUser.getIp()), "input data[ip] must not be empty");
         Assert.isTrue(StringUtils.isNotBlank(pPlaynGoUser.getNickName()), "input data[nickName] must not be empty");
         Assert.isTrue(StringUtils.isNotBlank(pPlaynGoUser.getUserName()), "input data[userName] must not be empty");
         Assert.isTrue(StringUtils.isNotBlank(pPlaynGoUser.getBrandId()), "input data[brandId] must not be empty");

         // init data
         pPlaynGoUser.setBirthday(parseDate(btd));
         pPlaynGoUser.setRegistrationDate(parseDate(regDate));
         if (EnumPlaynGoUserGender.Male.getShortName().equals(genderCode)) {
            pPlaynGoUser.setGender(EnumPlaynGoUserGender.Male);
         } else {
            pPlaynGoUser.setGender(EnumPlaynGoUserGender.Female);
         }
         pPlaynGoUser.setCurrencyCode("CNY");
         pPlaynGoUser.setCountryCode("CN");
         pPlaynGoUser.setLanguageCode("zh_CN");

         playnGoService.register(pPlaynGoUser);
         payload.setErrorCode(ErrorCodeResovler.OK);

      } catch (PlaynGoException pe) {
         payload.setErrorCode(pe.getErrorCode());
         payload.setErrorDesc(pe.getMessage());

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         payload.setErrorCode(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION);
         payload.setErrorDesc(e.getMessage());
      }
      return payload;
   }

   /**
    * 
    * link: http://localhost:18080/chaofan2png/v1/playngo/credit
    * 
    * @param pPlaynGoUser
    *           必填欄位：id、playerAccount、gamePlatformId、gameAccount、playnGoBalance:
    *           {"sn":"2016111300023901234","transferAmount": 0}
    * @return
    */
   // @RequestMapping(value="/credit", produces={"application/json"}, consumes =
   // {"application/json"}, method={RequestMethod.POST})
   public @ResponseBody ResponsePayload<PlaynGoBalance> credit(@RequestBody PlaynGoUser pPlaynGoUser) {
      log.info("credit start...");
      ResponsePayload<PlaynGoBalance> payload = new ResponsePayload<PlaynGoBalance>();
      try {

         // 必填欄位驗證
         PlaynGoBalance inputBalance = pPlaynGoUser.getPlaynGoBalance();
         Assert.notNull(inputBalance, "input data[playnGoBalance] must not be empty");
         Assert.isTrue(inputBalance.getTransferAmount() > 0, "input data[transferAmount] must be greater than zero");
         Assert.hasText(inputBalance.getSn(), "input data[sn] must must not be empty");

         PlaynGoBalance playnGoBalance = playnGoService.credit(pPlaynGoUser, inputBalance);

         payload.setData(playnGoBalance);
         payload.setErrorCode(ErrorCodeResovler.OK);

      } catch (PlaynGoException pe) {
         payload.setErrorCode(pe.getErrorCode());
         payload.setErrorDesc(pe.getMessage());

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         payload.setErrorCode(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION);
         payload.setErrorDesc(e.getMessage());
      }

      return payload;
   }

   /**
    * link: http://localhost:18080/chaofan2png/v1/playngo/debit
    * 
    * @param pPlaynGoUser
    *           必填欄位：id、playerAccount、gamePlatformId、gameAccount、playnGoBalance:
    *           {"sn":"2016111300023901234","transferAmount": 0}
    * @return
    */
   // @RequestMapping(value="/debit", produces={"application/json"}, consumes =
   // {"application/json"}, method={RequestMethod.POST})
   public @ResponseBody ResponsePayload<PlaynGoBalance> debit(@RequestBody PlaynGoUser pPlaynGoUser) {
      log.info("debit start...");
      ResponsePayload<PlaynGoBalance> payload = new ResponsePayload<PlaynGoBalance>();
      try {
         // 必填欄位驗證
         PlaynGoBalance inputBalance = pPlaynGoUser.getPlaynGoBalance();
         Assert.notNull(inputBalance, "input data[playnGoBalance] must not be empty");
         Assert.isTrue(inputBalance.getTransferAmount() > 0, "input data[transferAmount] must be greater than zero");
         Assert.hasText(inputBalance.getSn(), "input data[sn] must must not be empty");

         PlaynGoBalance playnGoBalance = playnGoService.debit(pPlaynGoUser, inputBalance);
         payload.setData(playnGoBalance);
         payload.setErrorCode(ErrorCodeResovler.OK);

      } catch (PlaynGoException pe) {
         payload.setErrorCode(pe.getErrorCode());
         payload.setErrorDesc(pe.getMessage());

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         payload.setErrorCode(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION);
         payload.setErrorDesc(e.getMessage());
      }

      return payload;
   }

   @RequestMapping(value = "/{gameAccount}/balance", produces = { "application/json" }, method = { RequestMethod.GET,
         RequestMethod.POST })
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsePayload<PlaynGoBalance> getBalance(@PathVariable("gameAccount") String pGameAccount) {
      log.info("getBalance start...");
      ResponsePayload<PlaynGoBalance> payload = new ResponsePayload<PlaynGoBalance>();
      try {
         // 必填欄位驗證
         Assert.isTrue(StringUtils.isNotBlank(pGameAccount), "input data[gameAccount] must not be empty");

         PlaynGoBalance playnGoBalance = playnGoService.getBalance(pGameAccount);
         payload.setData(playnGoBalance);
         payload.setErrorCode(ErrorCodeResovler.OK);

      } catch (PlaynGoException pe) {
         payload.setErrorCode(pe.getErrorCode());
         payload.setErrorDesc(pe.getMessage());

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         payload.setErrorCode(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION);
         payload.setErrorDesc(e.getMessage());

      }
      return payload;
   }

   // @RequestMapping(value="/{gameAccount}/ticket",
   // produces={"application/json"},
   // method={RequestMethod.GET,RequestMethod.POST})
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsePayload<String> getTicket(@PathVariable("gameAccount") String pGameAccount) {
      log.info("getTicket start...");
      ResponsePayload<String> payload = new ResponsePayload<String>();
      try {

         // 必填欄位驗證
         Assert.isTrue(StringUtils.isNotBlank(pGameAccount), "input data[gameAccount] must not be empty");

         String ticket = playnGoService.getTicket(pGameAccount);
         payload.setData(ticket);
         payload.setErrorCode(ErrorCodeResovler.OK);
      } catch (PlaynGoException pe) {
         payload.setErrorCode(pe.getErrorCode());
         payload.setErrorDesc(pe.getMessage());
      } catch (Exception e) {
         log.error(e.getMessage(), e);
         payload.setErrorCode(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION);
         payload.setErrorDesc(e.getMessage());

      }
      return payload;
   }

   // @RequestMapping(value="/{gameAccount}/unfinishedGames",
   // produces={"application/json"},
   // method={RequestMethod.GET,RequestMethod.POST})
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsePayload<PlaynGoUnfinishedGames> getUnfinishedGames(
         @PathVariable("gameAccount") String pGameAccount) {
      log.info("getTicket start...");
      ResponsePayload<PlaynGoUnfinishedGames> payload = new ResponsePayload<PlaynGoUnfinishedGames>();
      try {

         // 必填欄位驗證
         Assert.isTrue(StringUtils.isNotBlank(pGameAccount), "input data[gameAccount] must not be empty");

         PlaynGoUnfinishedGames games = new PlaynGoUnfinishedGames();
         games.setGames(playnGoService.getUnfinishedGames(pGameAccount));
         payload.setData(games);
         payload.setErrorCode(ErrorCodeResovler.OK);

      } catch (PlaynGoException pe) {
         payload.setErrorCode(pe.getErrorCode());
         payload.setErrorDesc(pe.getMessage());

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         payload.setErrorCode(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION);
         payload.setErrorDesc(e.getMessage());

      }
      return payload;
   }

   @RequestMapping(value = "/getAchievements", produces = { "application/json" }, method = { RequestMethod.POST })
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsePayload<List<AchievementConfiguration>> getAchievements(
         @RequestBody AchievementArguments achievementArguments) {
      log.info("getAchievements start...");
      ResponsePayload<List<AchievementConfiguration>> payload = new ResponsePayload<>();
      try {
         List<AchievementConfiguration> achievementConfigurations = playnGoService
               .getAchievements(achievementArguments);
         payload.setData(achievementConfigurations);
         payload.setErrorCode(ErrorCodeResovler.OK);

      } catch (PlaynGoException pe) {
         payload.setErrorCode(pe.getErrorCode());
         payload.setErrorDesc(pe.getMessage());

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         payload.setErrorCode(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION);
         payload.setErrorDesc(e.getMessage());

      }
      return payload;
   }

   @RequestMapping(value = "/getAchievementSummary", produces = { "application/json" }, method = { RequestMethod.POST })
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsePayload<List<Object>> getAchievementSummary(
         @RequestBody AchievementArguments achievementArguments) {
      log.info("getAchievementSummary start...");
      ResponsePayload<List<Object>> payload = new ResponsePayload<>();
      try {
         // 必填欄位驗證
         Assert.isTrue(achievementArguments.getFromDate() != null, "input data[getFromDate] must not be empty");
         Assert.isTrue(achievementArguments.getToDate() != null, "input data[getToDate] must not be empty");
         Assert.isTrue(StringUtils.isNotBlank(achievementArguments.getAchievementName()),
               "input data[getAchievementName] must not be empty");

         List<Object> achievementsSummarys = playnGoService.getAchievementSummary(achievementArguments);

         payload.setData(achievementsSummarys);
         payload.setErrorCode(ErrorCodeResovler.OK);

      } catch (PlaynGoException pe) {
         payload.setErrorCode(pe.getErrorCode());
         payload.setErrorDesc(pe.getMessage());

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         payload.setErrorCode(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION);
         payload.setErrorDesc(e.getMessage());

      }
      return payload;
   }

   @RequestMapping(value = "/getTriggeredAchievements", produces = { "application/json" }, method = {
         RequestMethod.POST })
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsePayload<List<Object>> getTriggeredAchievements(
         @RequestBody AchievementArguments achievementArguments) {
      log.info("getTriggeredAchievements start...");
      ResponsePayload<List<Object>> payload = new ResponsePayload<>();

      try {
         // 必填欄位驗證
         Assert.isTrue(achievementArguments.getFromDate() != null, "input data[getFromDate] must not be empty");
         Assert.isTrue(achievementArguments.getToDate() != null, "input data[getToDate] must not be empty");

         List<Object> achievementsTriggers = playnGoService.getTriggeredAchievements(achievementArguments);
         payload.setData(achievementsTriggers);
         payload.setErrorCode(ErrorCodeResovler.OK);

      } catch (PlaynGoException pe) {
         payload.setErrorCode(pe.getErrorCode());
         payload.setErrorDesc(pe.getMessage());

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         payload.setErrorCode(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION);
         payload.setErrorDesc(e.getMessage());

      }
      return payload;
   }

   @RequestMapping(value = "/getTriggeredAchievementsByPlayer", produces = { "application/json" }, method = {
         RequestMethod.POST })
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsePayload<List<Object>> getTriggeredAchievementsByPlayer(
         @RequestBody AchievementArguments achievementArguments) {
      log.info("getTriggeredAchievementsByPlayer start...");
      ResponsePayload<List<Object>> payload = new ResponsePayload<>();
      try {
         // 必填欄位驗證
         Assert.isTrue(StringUtils.isNotBlank(achievementArguments.getExternalId()),
               "input data[getExternalId] must not be empty");
         Assert.isTrue(achievementArguments.getFromDate() != null, "input data[getFromDate] must not be empty");
         Assert.isTrue(achievementArguments.getToDate() != null, "input data[getToDate] must not be empty");

         List<Object> playerAchievementsTriggers = playnGoService
               .getTriggeredAchievementsByPlayer(achievementArguments);
         payload.setData(playerAchievementsTriggers);
         payload.setErrorCode(ErrorCodeResovler.OK);

      } catch (PlaynGoException pe) {
         payload.setErrorCode(pe.getErrorCode());
         payload.setErrorDesc(pe.getMessage());

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         payload.setErrorCode(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION);
         payload.setErrorDesc(e.getMessage());

      }
      return payload;
   }

   private Date parseDate(String pDateStr) throws Exception {
      Date date = null;
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
      date = sdf.parse(pDateStr);
      return date;
   }
}
