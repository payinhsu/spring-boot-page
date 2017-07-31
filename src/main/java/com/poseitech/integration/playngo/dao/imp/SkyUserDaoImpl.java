package com.poseitech.integration.playngo.dao.imp;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.poseitech.integration.playngo.dao.GenericHibernateDao;
import com.poseitech.integration.playngo.dao.SkyUserDao;
import com.poseitech.integration.playngo.entity.SkyUser;

/**
 *
 * @author mango
 */
@Repository
public class SkyUserDaoImpl extends GenericHibernateDao<SkyUser, Long> implements SkyUserDao {
   private static final Logger log = LoggerFactory.getLogger(SkyUserDaoImpl.class);

   /**
    * 依帳號查詢使用者
    * 
    * @param pName
    * @return SkyUser
    */
   @SuppressWarnings("unchecked")
   public List<SkyUser> getUsersByName(String[] pName) {
      Criteria criteria = this.getSession().createCriteria(SkyUser.class);
      criteria.add(Restrictions.eq("status", 1));
      if (pName.length > 0) {
         Disjunction or = Restrictions.disjunction();
         Criterion[] restrictions = new Criterion[pName.length];
         for (int i = 0; i < pName.length; i++) {
            restrictions[i] = Restrictions.eq("name", pName[i]);
            or.add(Restrictions.or(restrictions[i]));
         }
         criteria.add(or);
      }
      return criteria.list();
   }
}
