package com.poseitech.integration.playngo.dao;

import java.util.List;
import java.util.Set;

import com.poseitech.integration.playngo.config.MicroserviceApplication;
import com.poseitech.integration.playngo.entity.SkyUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.poseitech.legacy.t9betnew.entity.SkyGamePlatformDto;
import com.poseitech.legacy.t9betnew.entity.SkyUserDto;
import com.poseitech.legacy.t9betnew.entity.SkyUserGameDto;


@Commit
@Rollback(true)
@Transactional(transactionManager = "transactionManager")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroserviceApplication.class, initializers = ConfigFileApplicationContextInitializer.class)
public class SampleDaoTest {

   private static final Logger log = LoggerFactory.getLogger(SampleDaoTest.class);
   
   @Autowired
   private SkyUserDao skyUserDao;
   
   @Test
   public void testMethod() {
      try {

//         SkyUserDto skyUserDto = skyUserDao.get(17809L);
         String[] nameList = {"fauser1fafa"};
         List<SkyUser> user = skyUserDao.getUsersByName(nameList);

         Assert.isTrue(user.get(0).getId() == 76812, "user fauser1fafa is not exist");

         String accountName = user.get(0).getName();
         if("fauser1fafa".substring(2).equals(accountName))
            log.info("lastName is "+user.get(0).getLastName());
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
