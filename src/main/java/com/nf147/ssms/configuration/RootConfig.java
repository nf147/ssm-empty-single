package com.nf147.ssms.configuration;

import com.nf147.ssms.configuration.misc.MybatisConfig;
import com.nf147.ssms.configuration.misc.ScheduleConfig;
import com.nf147.ssms.configuration.misc.ShiroConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
@Import({ MybatisConfig.class, ShiroConfig.class, ScheduleConfig.class })
public class RootConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer sourcesPlaceholderConfigurer () {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
