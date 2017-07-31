package com.poseitech.integration.playngo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * ${file_name} created ${date}
 * <p>
 * \$LastChangedBy\$
 * \$Date\$
 * \$Revision\$
 */
public class AchievementsResponse implements Serializable {

   private static final long serialVersionUID = -8612284502171697544L;
   /*姓名*/
   private String userName;

   private String externalId;

   private String brandId;

   private Calendar time;

   private String parentName;
   /*帳號*/
   private String name;

   private String description;

   private Integer gameId;

   private Long roundId;

   private Integer spin;

   private Integer resultId;

   private Integer points;

   private Integer count;

   private Integer freegameTriggerId;

   private String nickname;

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getExternalId() {
      return externalId;
   }

   public void setExternalId(String externalId) {
      this.externalId = externalId;
   }

   public String getBrandId() {
      return brandId;
   }

   public void setBrandId(String brandId) {
      this.brandId = brandId;
   }

   public Calendar getTime() {
      return time;
   }

   public void setTime(Calendar time) {
      this.time = time;
   }

   public String getParentName() {
      return parentName;
   }

   public void setParentName(String parentName) {
      this.parentName = parentName;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Integer getGameId() {
      return gameId;
   }

   public void setGameId(Integer gameId) {
      this.gameId = gameId;
   }

   public Long getRoundId() {
      return roundId;
   }

   public void setRoundId(Long roundId) {
      this.roundId = roundId;
   }

   public Integer getSpin() {
      return spin;
   }

   public void setSpin(Integer spin) {
      this.spin = spin;
   }

   public Integer getResultId() {
      return resultId;
   }

   public void setResultId(Integer resultId) {
      this.resultId = resultId;
   }

   public Integer getPoints() {
      return points;
   }

   public void setPoints(Integer points) {
      this.points = points;
   }

   public Integer getCount() {
      return count;
   }

   public void setCount(Integer count) {
      this.count = count;
   }

   public Integer getFreegameTriggerId() {
      return freegameTriggerId;
   }

   public void setFreegameTriggerId(Integer freegameTriggerId) {
      this.freegameTriggerId = freegameTriggerId;
   }

   public String getNickname() {
      return nickname;
   }

   public void setNickname(String nickname) {
      this.nickname = nickname;
   }
}
