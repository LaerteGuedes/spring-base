package com.springapp.mvc.conf;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by laerteguedes on 14/06/16.
 */
@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:persistence.properties"})
@ComponentScan({"com.springapp.mvc.conf"})
public class JPAConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws IOException{
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.springapp.mvc.domain" });
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() throws IOException{
        Resource resource = new ClassPathResource("/persistence.properties");
        Properties props = PropertiesLoaderUtils.loadProperties(resource);

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(props.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(props.getProperty("url"));
        dataSource.setUsername(props.getProperty("user"));
        dataSource.setPassword(props.getProperty("pass"));

        System.out.println(dataSource.getUsername());

        return dataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                setProperty("hibernate.globally_quoted_identifiers", "true");
            }
        };
    }

}
