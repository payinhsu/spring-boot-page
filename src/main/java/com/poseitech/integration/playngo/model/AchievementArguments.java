package com.poseitech.integration.playngo.model;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ${file_name} created ${date}
 * <p>
 * \$LastChangedBy\$
 * \$Date\$
 * \$Revision\$
 */
public class AchievementArguments implements Serializable {

   private static final long serialVersionUID = 7608653178449372075L;
   /*
   The current status of the achievement. Status can be:
   Active
   Future
   Historical
   None
   None alternative will return all achievements.
   */
   private String status;
   /*The free game identifier if used as Achievement prize*/
   private Integer triggerId;
   /*The number of results to skip */
   private Integer skip;
   /*The maximum number of results to return. Default value is 100 */
   private Integer take;
   /*Date (and time) in UTC to start counting points*/
   private Long fromDate;
   /*Date (and time) in UTC to end counting points*/
   private Long toDate;

   private String achievementName;

   private String brandId;
   /*
   Game id of the triggered achievement.
   Please find list of IDs in Game Appendix document
   */
   private Integer gameId;
   /*External id of the player*/
   private String externalId;

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public Integer getTriggerId() {
      return triggerId;
   }

   public void setTriggerId(Integer triggerId) {
      this.triggerId = triggerId;
   }

   public Integer getSkip() {
      return skip;
   }

   public void setSkip(Integer skip) {
      this.skip = skip;
   }

   public Integer getTake() {
      return take;
   }

   public void setTake(Integer take) {
      this.take = take;
   }

   public Long getFromDate() {
      return fromDate;
   }

   public void setFromDate(Long fromDate) {
      this.fromDate = fromDate;
   }

   public Long getToDate() {
      return toDate;
   }

   public void setToDate(Long toDate) {
      this.toDate = toDate;
   }

   public String getAchievementName() {
      return achievementName;
   }

   public void setAchievementName(String achievementName) {
      this.achievementName = achievementName;
   }

   public String getBrandId() {
      return brandId;
   }

   public void setBrandId(String brandId) {
      this.brandId = brandId;
   }

   public Integer getGameId() {
      return gameId;
   }

   public void setGameId(Integer gameId) {
      this.gameId = gameId;
   }

   public String getExternalId() {
      return externalId;
   }

   public void setExternalId(String externalId) {
      this.externalId = externalId;
   }
}
