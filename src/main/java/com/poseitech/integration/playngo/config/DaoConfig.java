package com.poseitech.integration.playngo.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * ${file_name} created ${date}
 * <p>
 * \$LastChangedBy\$
 * \$Date\$
 * \$Revision\$
 */
@Configuration
@ComponentScan({ "com.poseitech.integration.playngo.dao" })
public class DaoConfig {


   private static final Logger log = LoggerFactory.getLogger(DaoConfig.class);

   @Autowired
   private Environment env;

   @PostConstruct
   public void init() {
      log.debug("== Application: " + env.getProperty("spring.application.name") + ", Profiles: "
            + StringUtils.join(env.getActiveProfiles(), ", ") + " ==");
      log.debug("== DB URL: " + env.getProperty("spring.datasource.url"));
   }

   @Bean(name = "dataSource")
   @ConfigurationProperties(prefix = "spring.datasource")
   public DataSource dataSource() {
      return DataSourceBuilder.create().build();
   }

   @Bean(name = "sessionFactory")
   public LocalSessionFactoryBean businessSessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(dataSource());
      sessionFactory.setPackagesToScan(new String[] { "com.poseitech.integration.playngo.entity" });
      sessionFactory.setMappingLocations(new ClassPathResource("hbm/sql-query.hbm.xml"));
      return sessionFactory;
   }

   @Bean(name = "transactionManager")
   public HibernateTransactionManager transactionManager() {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
      txManager.setSessionFactory(businessSessionFactory().getObject());
      return txManager;
   }

   @Bean
   @Qualifier("jdbcTemplate")
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
   }
}