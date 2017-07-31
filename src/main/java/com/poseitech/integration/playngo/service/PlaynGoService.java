/**
 * PlaynGoService.java created 2016年11月5日
 *
 */
package com.poseitech.integration.playngo.service;

import java.util.List;

import com.poseitech.integration.playngo.model.*;
import com.poseitech.integration.playngo.ws.client.model.user.AchievementConfiguration;
import com.poseitech.integration.playngo.ws.client.model.user.AchievementsSummary;
import com.poseitech.integration.playngo.ws.client.model.user.AchievementsTrigger;
import com.poseitech.integration.playngo.ws.client.model.user.PlayerAchievementsTrigger;

/**
 * @author B.J Lin
 */
public interface PlaynGoService {
    
   public boolean register(PlaynGoUser pUser) throws PlaynGoException;
   
   public PlaynGoBalance credit(PlaynGoUser pUser, PlaynGoBalance pBalance) throws PlaynGoException;
   
   public PlaynGoBalance debit(PlaynGoUser pUser, PlaynGoBalance pBalance) throws PlaynGoException;
   
   public PlaynGoBalance getBalance(PlaynGoUser pUser) throws PlaynGoException;
   
   public PlaynGoBalance getBalance(String pExternalUserId) throws PlaynGoException;
   
   public String getTicket(String pExternalUserId) throws PlaynGoException;
   
   public List<PlaynGoOpenGame> getUnfinishedGames(String pExternalUserId) throws PlaynGoException;

   public List<AchievementConfiguration> getAchievements(AchievementArguments achievementArguments) throws PlaynGoException;

   public List<Object> getAchievementSummary(AchievementArguments achievementArguments) throws PlaynGoException;

   public List<Object> getTriggeredAchievements(AchievementArguments achievementArguments) throws PlaynGoException;

   public List<Object> getTriggeredAchievementsByPlayer(AchievementArguments achievementArguments) throws PlaynGoException;

   public String getUserName(String account) throws PlaynGoException;
}
