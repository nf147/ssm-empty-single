package configuration;

import configuration.root.MybatisConfig;
import configuration.root.ShiroConfig;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.nf147.ssms")
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
@Import({MybatisConfig.class, ShiroConfig.class})
public class RootConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer sourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
