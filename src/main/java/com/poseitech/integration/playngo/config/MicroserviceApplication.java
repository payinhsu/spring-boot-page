/** */
package com.poseitech.integration.playngo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@EnableAutoConfiguration
@Import({MicroserviceConfig.class})
@RefreshScope
/**
 *
 * @author ${user}
 *
 * ${tags}
 */
public class MicroserviceApplication {

    static final Logger log = LoggerFactory.getLogger(MicroserviceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);
    }

}
