package com.pluralsight.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/***
 * Java configuration class for customizing and creating changes or configuration in our persistance tier
 * @Configuration annotation for spring to see it as is
 * Any methods that we define here can return beans that will be stored in Spring context.
 */
@Configuration
public class PersistanceConfiguration {

    /***
     * Customer DataSource bean that overrides the data source configuration from application.properties
     */
//    @Bean
//    public DataSource dataSource() {
//        DataSourceBuilder builder = new DataSourceBuilder.create();
//        builder.url("jdbc:postgresql://localhost:5432/conference_app");
//        return builder.build();
//    }
}
