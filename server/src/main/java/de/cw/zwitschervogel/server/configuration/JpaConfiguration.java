package de.cw.zwitschervogel.server.configuration;

import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "zwitschervogelEntityManagerFactory",
    transactionManagerRef = "zwitschervogelTransactionManager",
    basePackages = {"de.cw.zwitschervogel.server.repository"})
@EnableTransactionManagement
@EnableAutoConfiguration
public class JpaConfiguration {

  @Primary
  @Bean(name = "zwitschervogelEntityManagerFactory")
  public EntityManagerFactory entityManagerFactory(
      @Qualifier("zwitschervogelDataSource") DataSource dataSource) {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(false);
    vendorAdapter.setShowSql(false);
    vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setJpaVendorAdapter(vendorAdapter);
    factoryBean.setPackagesToScan("de.cw.zwitschervogel.server.domain");
    factoryBean.setDataSource(dataSource);
    Properties jpaProperties = new Properties();
    //jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");
    factoryBean.setJpaProperties(jpaProperties);
    factoryBean.afterPropertiesSet();
    return factoryBean.getObject();
  }

  @Bean(name = "zwitschervogelEntityManager")
  public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
    return entityManagerFactory.createEntityManager();
  }

  @Bean(name = "zwitschervogelTransactionManager")
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
    jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
    return jpaTransactionManager;
  }

  @Bean(name = "zwitschervogelDataSource")
  @ConfigurationProperties("zwitschervogel.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().type(BasicDataSource.class).build();
  }

}
