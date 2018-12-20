package com.nf147.configuration;

import com.nf147.configuration.root.MybatisConfig;
import com.nf147.configuration.root.ShiroConfig;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.nf147.ssms")
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
@Import({MybatisConfig.class, ShiroConfig.class
})
public class RootConfig {
    // 全局方面的配置
    @Bean
    public static PropertySourcesPlaceholderConfigurer sourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
