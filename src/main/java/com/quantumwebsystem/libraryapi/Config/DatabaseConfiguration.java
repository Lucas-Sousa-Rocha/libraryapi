package com.quantumwebsystem.libraryapi.Config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

// Indica que esta classe contém configurações do Spring (bean definitions)
@Configuration
public class DatabaseConfiguration {

    // Injeta no atributo o valor definido no application.properties ou application.yml
    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.driver-class-name}")
    String driverClassName;

    // Cria um DataSource básico usando DriverManager (sem pool de conexões)
    // Esse método pode ser usado como fallback ou em cenários simples
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    // Cria e registra no Spring um DataSource do tipo HikariCP (pool de conexões)
    // O @Bean indica que esse objeto estará disponível no contexto da aplicação
    @Bean
    public DataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();

        // Configurações de conexão (pega do application.properties)
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driverClassName);

        // Configurações do pool de conexões
        config.setMaximumPoolSize(10);                  // Máximo de conexões abertas
        config.setMinimumIdle(1);                       // Conexões mínimas em espera
        config.setPoolName("library-pool");             // Nome do pool (aparece nos logs)
        config.setMaxLifetime(600000);                  // Tempo máximo de vida de uma conexão (10 min)
        config.setConnectionTimeout(100000);            // Tempo máximo de espera para obter uma conexão (100s)
        config.setConnectionTestQuery("SELECT 1");      // Query usada para testar se a conexão está ativa

        // Retorna o DataSource com pool configurado
        return new HikariDataSource(config);
    }

}
