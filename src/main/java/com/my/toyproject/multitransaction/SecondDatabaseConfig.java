package com.my.toyproject.multitransaction;

import com.zaxxer.hikari.HikariDataSource;
import java.util.Map;
import java.util.Objects;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Profile("transaction")
@Configuration
@EnableJpaRepositories(
    basePackages = "com.my.toyproject.multitransaction.second.repository",
    entityManagerFactoryRef = "secondEntityManagerFactory",
    transactionManagerRef = "secondTransactionManager"
)
@RequiredArgsConstructor
public class SecondDatabaseConfig {

    private final String DOMAIN_PACKAGE_PATH = "com.my.toyproject.multitransaction.second.domain";

    @Value("${spring.jpa.hibernate.second.ddl-auto}")
    private String ddlAuto;

    private final JpaProperties jpaProperties;
    private final HibernateProperties hibernateProperties;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.second-database")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create()
                                .type(HikariDataSource.class)
                                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        hibernateProperties.setDdlAuto(ddlAuto);
        Map<String, Object> hibernatePropertiesMap = hibernateProperties
            .determineHibernateProperties(jpaProperties.getProperties(),
                                          new HibernateSettings());
        return builder.dataSource(secondDataSource())
                      .properties(hibernatePropertiesMap)
                      .packages(DOMAIN_PACKAGE_PATH)
                      .persistenceUnit("master")
                      .build();
    }

    @Bean
    PlatformTransactionManager secondTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(secondEntityManagerFactory(builder).getObject()));
    }
}
