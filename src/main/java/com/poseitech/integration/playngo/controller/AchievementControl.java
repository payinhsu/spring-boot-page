package com.poseitech.integration.playngo.controller;

import com.poseitech.exceptions.ErrorCodeResovler;
import com.poseitech.integration.message.ResponsePayload;
import com.poseitech.integration.playngo.model.AchievementArguments;
import com.poseitech.integration.playngo.service.PlaynGoException;
import com.poseitech.integration.playngo.service.PlaynGoService;
import com.poseitech.lang.Assert;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ${file_name} created ${date}
 * <p>
 * \$LastChangedBy\$ \$Date\$ \$Revision\$
 */
@Controller
public class AchievementControl {

   private static Logger log = LoggerFactory.getLogger(AchievementControl.class);

   @Autowired
   private PlaynGoService playnGoService;
   @Value("${poseitech.integration.playngo.activity.fromDate}")
   private String fromDate;
   @Value("${poseitech.integration.playngo.activity.toDate}")
   private String toDate;
   @Value("${poseitech.integration.playngo.achievement.name}")
   private String achievementName;
   @Value("${poseitech.integration.playngo.achievement.take}")
   private Integer take;

   @RequestMapping(value = "/getAchievementTable", produces = { "application/json" }, consumes = {
         "application/json" }, method = { RequestMethod.POST })
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsePayload<List<Object>> getAchievementTable(
         @RequestBody AchievementArguments achievementArguments) {
      log.info("getAchievementTable start...");

      ResponsePayload<List<Object>> payload = new ResponsePayload<>();

      try {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date fromDateToDate = dateFormat.parse(fromDate);
         Date toDateToDate = dateFormat.parse(toDate);

         achievementArguments.setFromDate(fromDateToDate.getTime());
         achievementArguments.setToDate(toDateToDate.getTime());
         achievementArguments.setAchievementName(achievementName);
         achievementArguments.setTake(take);
         List<Object> aAchievementsList = playnGoService.getAchievementSummary(achievementArguments);

         payload.setData(aAchievementsList);
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

   @RequestMapping(value = "/getUserName", produces = { "application/json" }, consumes = {
         "application/json" }, method = { RequestMethod.POST })
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsePayload<String> getUserName(@RequestBody AchievementArguments achievementArguments) {
      log.info("getUserName start...");

      ResponsePayload<String> payload = new ResponsePayload<>();

      try {
         // 必填欄位驗證
         Assert.isTrue(StringUtils.isNoneBlank(achievementArguments.getExternalId()),
               "input data[account] must not be empty");

         String name = playnGoService.getUserName(achievementArguments.getExternalId());

         payload.setData(name);
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

   @RequestMapping(value = "/getFormatDate", produces = { "application/json" }, consumes = {
         "application/json" }, method = { RequestMethod.GET })
   @ResponseStatus(HttpStatus.OK)
   public @ResponseBody ResponsePayload<String[]> getFormatDate() {
      log.info("getFormatDate start...");

      ResponsePayload<String[]> payload = new ResponsePayload<>();

      try {
         SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         SimpleDateFormat newDateFormat = new SimpleDateFormat(" yyyy年 MM月dd日 HH:mm:ss");
         String[] dateArray = new String[2];
         dateArray[0] = newDateFormat.format(oldDateFormat.parse(fromDate));
         dateArray[1] = newDateFormat.format(oldDateFormat.parse(toDate));
         payload.setData(dateArray);
         payload.setErrorCode(ErrorCodeResovler.OK);

      } catch (Exception e) {
         log.error(e.getMessage(), e);
         payload.setErrorCode(ErrorCodeResovler.ERROR_UNEXCEPTED_EXCEPTION);
         payload.setErrorDesc(e.getMessage());
      }

      return payload;
   }
}
