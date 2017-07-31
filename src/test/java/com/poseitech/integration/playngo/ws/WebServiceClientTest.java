package com.poseitech.integration.playngo.ws;

import java.net.InetAddress;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import com.poseitech.integration.playngo.ws.client.model.user.*;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poseitech.integration.playngo.config.MicroserviceApplication;
import com.poseitech.integration.playngo.model.EnumPlaynGoUserGender;
import com.poseitech.integration.playngo.model.PlaynGoUser;
import com.poseitech.integration.playngo.ws.client.util.WSBeanUtils;
import com.poseitech.integration.playngo.ws.client.v1.CasinoGameServiceStub;
import com.poseitech.utils.DateUtil;

/**
 * Sample junit test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroserviceApplication.class, initializers = ConfigFileApplicationContextInitializer.class)
public class WebServiceClientTest {

   private static final Logger log = LoggerFactory.getLogger(WebServiceClientTest.class);
   private final static String SERVICE_ENDPOINT = "http://bsistage.playngonetwork.com:22789/CasinoGameService?wsdl";

   @Test
   public void testBalance() {
      try {

         CasinoGameServiceStub servicesStub = new CasinoGameServiceStub(SERVICE_ENDPOINT);

         HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
         auth.setPreemptiveAuthentication(true);
         auth.setUsername("pexapi");
         auth.setPassword("02e3e46218");

         Options options = servicesStub._getServiceClient().getOptions();
         options.setProperty(HTTPConstants.AUTHENTICATE, auth);
         options.setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);

         String pExternalUserId = "PoseTest";
         Balance balance = new Balance();
         balance.setExternalUserId(pExternalUserId);
         BalanceResponse wsResponse = servicesStub.balance(balance);
         if (wsResponse != null && wsResponse.getUserBalance() != null) {
            log.info("getCurrency[" + wsResponse.getUserBalance().getCurrency() + "]");
            log.info("getReal[" + wsResponse.getUserBalance().getReal() + "]");
         } else {
            log.error("wsResponse is empty...");
         }

      } catch (AxisFault axisFault) {
         log.error("web service error[" + axisFault.getMessage() + "]");

      } catch (Exception e) {
         log.error("error...", e);
      }
   }

   @Test
   @Ignore
   public void testRegisterUser() {
      try {

         CasinoGameServiceStub servicesStub = new CasinoGameServiceStub(SERVICE_ENDPOINT);

         HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
         auth.setPreemptiveAuthentication(true);
         auth.setUsername("pexapi");
         auth.setPassword("02e3e46218");

         Options options = servicesStub._getServiceClient().getOptions();
         options.setProperty(HTTPConstants.AUTHENTICATE, auth);
         options.setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);

         PlaynGoUser pUser = new PlaynGoUser();
         pUser.setPlayerAccount("PoseTest3");
         pUser.setGameAccount("PoseTest3");
         pUser.setUserName("KariTest3");
         pUser.setNickName("KariTest3");
         pUser.setCurrencyCode("CNY");
         pUser.setCountryCode("CN");
         pUser.setLanguageCode("zh_CN");
         pUser.setBirthday(DateUtil.parseTwDate("20000201"));
         pUser.setRegistrationDate(DateUtil.getNow());
         pUser.setBrandId("TestBrand");
         pUser.setIpAddress(InetAddress.getLocalHost());
         pUser.setGender(EnumPlaynGoUserGender.Female);

         RegisterUser registerUser = WSBeanUtils.parseToRegisterUser(pUser);
         RegisterUserResponse wsResponse = servicesStub.registerUser(registerUser);

      } catch (AxisFault axisFault) {
         log.error("web service error[" + axisFault.getMessage() + "]");

      } catch (Exception e) {
         log.error("error...", e);
      }
   }

   @Test
   // @Ignore
   public void testSync() {
      try {

         CasinoGameServiceStub servicesStub = new CasinoGameServiceStub(SERVICE_ENDPOINT);

         HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
         auth.setPreemptiveAuthentication(true);
         auth.setUsername("pexapi");
         auth.setPassword("02e3e46218");

         Options options = servicesStub._getServiceClient().getOptions();
         options.setProperty(HTTPConstants.AUTHENTICATE, auth);
         options.setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);

         GetTicket ticketRequest = new GetTicket();
         ticketRequest.setExternalUserId("faposeitech168");

         GetTicketResponse ticketResponse = servicesStub.getTicket(ticketRequest);

         String result = ticketResponse.getTicket();

      } catch (Exception e) {
         log.error("error...", e);
      }
   }

   @Test
   // @Ignore
   public void testAsync() {
      try {

         CasinoGameServiceStub servicesStub = new CasinoGameServiceStub(SERVICE_ENDPOINT);

         HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
         auth.setPreemptiveAuthentication(true);
         auth.setUsername("pexapi");
         auth.setPassword("02e3e46218"); // 5J5RS7ZFdmGe
         // auth.setHost("172.16.12.25");
         // auth.setDomain("MY-PC");
         // List<String> authSchemes = new ArrayList<String>();
         // authSchemes.add(HttpTransportProperties.Authenticator.NTLM);
         // auth.setAuthSchemes(authSchemes);

         Options options = servicesStub._getServiceClient().getOptions();
         options.setProperty(HTTPConstants.AUTHENTICATE, auth);
         options.setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);

         GetTicket accountDetailsRequest = new GetTicket();
         accountDetailsRequest.setExternalUserId("faposeitech168");

         servicesStub.getTicket(accountDetailsRequest);

      } catch (Exception e) {
         log.error("error...", e);
      }
   }

   @Test
   public void testGetAchievements() {
      try {

         CasinoGameServiceStub servicesStub = new CasinoGameServiceStub(SERVICE_ENDPOINT);

         HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
         auth.setPreemptiveAuthentication(true);
         auth.setUsername("pexapi");
         auth.setPassword("02e3e46218");

         Options options = servicesStub._getServiceClient().getOptions();
         options.setProperty(HTTPConstants.AUTHENTICATE, auth);
         options.setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);

         GetAchievements getAchievements = new GetAchievements();

         getAchievements.setStatus(AchievementFilterType.None);

         log.info("testGetAchievements start --> input:{}",
               getAchievements.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         GetAchievementsResponse getAchievementsResponse = servicesStub.getAchievements(getAchievements);
         log.info("testGetAchievements end --> input:{}",
               getAchievementsResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         if (getAchievementsResponse != null
               && getAchievementsResponse.getAchievements().getAchievementConfiguration() != null) {
            log.info("AchievementsLength["
                  + getAchievementsResponse.getAchievements().getAchievementConfiguration().length + "]");
         } else {
            log.error("getAchievementsResponse is empty...");
         }

      } catch (AxisFault axisFault) {
         log.error("web service error[" + axisFault.getMessage() + "]");

      } catch (Exception e) {
         log.error("error...", e);
      }
   }

   @Test
   public void testGetAchievementSummary() {
      try {

         CasinoGameServiceStub servicesStub = new CasinoGameServiceStub(SERVICE_ENDPOINT);

         HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
         auth.setPreemptiveAuthentication(true);
         auth.setUsername("pexapi");
         auth.setPassword("02e3e46218");

         Options options = servicesStub._getServiceClient().getOptions();
         options.setProperty(HTTPConstants.AUTHENTICATE, auth);
         options.setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);

         GetAchievementSummary getAchievementSummary = new GetAchievementSummary();

         getAchievementSummary.setAchievementName("FireJoker");
         getAchievementSummary.setFromDate(DateUtils.toCalendar(new Date(Timestamp
               .valueOf(LocalDateTime.from(new Date().toInstant().atZone(ZoneId.of("UTC"))).minusDays(5)).getTime())));
         getAchievementSummary.setToDate(DateUtils.toCalendar(new Date(Timestamp
               .valueOf(LocalDateTime.from(new Date().toInstant().atZone(ZoneId.of("UTC"))).plusDays(10)).getTime())));

         log.info("testGetAchievementSummary start --> input:{}",
               getAchievementSummary.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         GetAchievementSummaryResponse getAchievementSummaryResponse = servicesStub
               .getAchievementSummary(getAchievementSummary);
         log.info("testGetAchievementSummary end --> input:{}",
               getAchievementSummaryResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         if (getAchievementSummaryResponse != null
               && getAchievementSummaryResponse.getAchievementSummary().getAchievementsSummary() != null) {
            log.info("AchievementSummariesLength["
                  + getAchievementSummaryResponse.getAchievementSummary().getAchievementsSummary().length + "]");
         } else {
            log.error("getAchievementSummaryResponse is empty...");
         }

      } catch (AxisFault axisFault) {
         log.error("web service error[" + axisFault.getMessage() + "]");

      } catch (Exception e) {
         log.error("error...", e);
      }
   }

   @Test
   public void testGetTriggeredAchievements() {
      try {

         CasinoGameServiceStub servicesStub = new CasinoGameServiceStub(SERVICE_ENDPOINT);

         HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
         auth.setPreemptiveAuthentication(true);
         auth.setUsername("pexapi");
         auth.setPassword("02e3e46218");

         Options options = servicesStub._getServiceClient().getOptions();
         options.setProperty(HTTPConstants.AUTHENTICATE, auth);
         options.setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);

         GetTriggeredAchievements getTriggeredAchievements = new GetTriggeredAchievements();

         getTriggeredAchievements.setFromDate(DateUtils.toCalendar(new Date(Timestamp
               .valueOf(LocalDateTime.from(new Date().toInstant().atZone(ZoneId.of("UTC"))).minusDays(5)).getTime())));
         getTriggeredAchievements.setToDate(DateUtils.toCalendar(new Date(Timestamp
               .valueOf(LocalDateTime.from(new Date().toInstant().atZone(ZoneId.of("UTC"))).plusDays(10)).getTime())));

         log.info("testGetTriggeredAchievements start --> input:{}",
               getTriggeredAchievements.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         GetTriggeredAchievementsResponse getTriggeredAchievementsResponse = servicesStub
               .getTriggeredAchievements(getTriggeredAchievements);
         log.info("testGetAchievementSummary end --> input:{}",
               getTriggeredAchievementsResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         if (getTriggeredAchievementsResponse != null
               && getTriggeredAchievementsResponse.getTriggeredAchievements().getAchievementsTrigger() != null) {
            log.info("TriggeredAchievementsLength["
                  + getTriggeredAchievementsResponse.getTriggeredAchievements().getAchievementsTrigger().length + "]");
         } else {
            log.error("getTriggeredAchievementsResponse is empty...");
         }

      } catch (AxisFault axisFault) {
         log.error("web service error[" + axisFault.getMessage() + "]");

      } catch (Exception e) {
         log.error("error...", e);
      }
   }

   @Test
   public void testGetTriggeredAchievementsByPlayer() {
      try {

         CasinoGameServiceStub servicesStub = new CasinoGameServiceStub(SERVICE_ENDPOINT);

         HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
         auth.setPreemptiveAuthentication(true);
         auth.setUsername("pexapi");
         auth.setPassword("02e3e46218");

         Options options = servicesStub._getServiceClient().getOptions();
         options.setProperty(HTTPConstants.AUTHENTICATE, auth);
         options.setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);

         GetTriggeredAchievementsByPlayer getTriggeredAchievementsByPlayer = new GetTriggeredAchievementsByPlayer();
         getTriggeredAchievementsByPlayer.setExternalId("fauser1fafa");
         getTriggeredAchievementsByPlayer.setFromDate(DateUtils.toCalendar(new Date(Timestamp
               .valueOf(LocalDateTime.from(new Date().toInstant().atZone(ZoneId.of("UTC"))).minusDays(5)).getTime())));
         getTriggeredAchievementsByPlayer.setToDate(DateUtils.toCalendar(new Date(Timestamp
               .valueOf(LocalDateTime.from(new Date().toInstant().atZone(ZoneId.of("UTC"))).plusDays(10)).getTime())));

         log.info("testGetTriggeredAchievementsByPlayer start --> input:{}",
               getTriggeredAchievementsByPlayer.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));
         GetTriggeredAchievementsByPlayerResponse getTriggeredAchievementsByPlayerResponse = servicesStub
               .getTriggeredAchievementsByPlayer(getTriggeredAchievementsByPlayer);
         log.info("testGetTriggeredAchievementsByPlayer end --> input:{}",
               getTriggeredAchievementsByPlayerResponse.getOMElement(null, OMAbstractFactory.getSOAP12Factory()));

         if (getTriggeredAchievementsByPlayerResponse != null && getTriggeredAchievementsByPlayerResponse
               .getTriggeredAchievements().getPlayerAchievementsTrigger() != null) {
            log.info("TriggeredAchievementsByPlayerLength[" + getTriggeredAchievementsByPlayerResponse
                  .getTriggeredAchievements().getPlayerAchievementsTrigger().length + "]");
         } else {
            log.error("getTriggeredAchievementsByPlayerResponse is empty...");
         }

      } catch (AxisFault axisFault) {
         log.error("web service error[" + axisFault.getMessage() + "]");

      } catch (Exception e) {
         log.error("error...", e);
      }
   }

}
