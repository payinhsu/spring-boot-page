package com.poseitech.integration.playngo.dao;

import com.poseitech.dao.hibernate.AbstractModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * ${file_name} created ${date}
 * <p>
 * \$LastChangedBy\$
 * \$Date\$
 * \$Revision\$
 */
@Repository
public abstract class GenericHibernateDao<T extends AbstractModel<ID>, ID extends Serializable> extends
      com.poseitech.dao.hibernate.GenericHibernateDao<T, ID> {

   @Autowired
   @Qualifier("sessionFactory")
   private org.hibernate.SessionFactory SessionFactory;

   @PostConstruct
   public void init() {
      super.setSessionFactory(SessionFactory);
   }
}
