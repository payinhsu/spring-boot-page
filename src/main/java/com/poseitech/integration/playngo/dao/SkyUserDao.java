package com.poseitech.integration.playngo.dao;

import com.poseitech.dao.hibernate.GenericDao;
import com.poseitech.integration.playngo.entity.SkyUser;

import java.util.List;

/**
 *
 * @author mango
 */
public interface SkyUserDao extends GenericDao<SkyUser, Long> {

   /**
    * 依帳號查詢使用者
    * 
    * @param pName
    * @return SkyUser
    */
   public List<SkyUser> getUsersByName(String[] pName);
}
