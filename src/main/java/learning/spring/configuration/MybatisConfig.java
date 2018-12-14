package learning.spring.configuration;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:application.properties")
public class MybatisConfig {

    @Autowired
    Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer ppp () {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource () throws PropertyVetoException {
        //SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        //PooledDataSource dataSource1 = new PooledDataSource();

        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setJdbcUrl("${jdbc.url}");
        source.setDriverClass("${jdbc.driver}");
        source.setUser(env.getProperty("jdbc.user"));
        source.setPassword(env.getProperty("jdbc.password"));

        source.setMaxPoolSize(30);
        return source;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory (DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        bean.setMapperLocations(new Resource[] { new ClassPathResource("classpath:mapper/*.xml") });
        bean.setTypeAliasesPackage("xxx.yy.zzz");
        bean.setDataSource(dataSource);
        return bean;
    }

    @Bean
    public MapperScannerConfigurer sss () {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        return configurer;
    }
}
