package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class PalTrackerApplication {

    @Bean
    TimeEntryRepository timeEntryRepository(DataSource dataSource){
        return new JdbcTimeEntryRepository(dataSource);
    }

    public static void main (String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }
}

