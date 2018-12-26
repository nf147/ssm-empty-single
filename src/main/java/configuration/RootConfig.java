package configuration;

import configuration.misc.DataSourceConfig;
import configuration.misc.MybatisConfig;
import configuration.misc.ShiroConfig;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(
        value = "com.nf147.ssms",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*.controller..*")
        })
@Import({
        DataSourceConfig.class,
        MybatisConfig.class,
        ShiroConfig.class
})
@PropertySource("classpath:application.properties")
public class RootConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer sourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
