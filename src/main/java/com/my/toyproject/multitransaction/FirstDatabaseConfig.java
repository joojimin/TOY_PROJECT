package com.my.toyproject.multitransaction;

import com.zaxxer.hikari.HikariDataSource;
import java.util.Map;
import java.util.Objects;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Profile("transaction")
@Configuration
@EnableJpaRepositories(
    basePackages = "com.my.toyproject.multitransaction.first.repository"
)
@RequiredArgsConstructor
public class FirstDatabaseConfig {

    private final String DOMAIN_PACKAGE_PATH = "com.my.toyproject.multitransaction.first.domain";

    private final JpaProperties jpaProperties;
    private final HibernateProperties hibernateProperties;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.first-database")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create()
                                .type(HikariDataSource.class)
                                .build();
    }


    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        Map<String, Object> hibernatePropertiesMap = hibernateProperties
            .determineHibernateProperties(jpaProperties.getProperties(),
                                          new HibernateSettings());
        return builder.dataSource(firstDataSource())
                      .properties(hibernatePropertiesMap)
                      .packages(DOMAIN_PACKAGE_PATH)
                      .persistenceUnit("master")
                      .build();
    }

    @Bean
    @Primary
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory(builder).getObject()));
    }
}
