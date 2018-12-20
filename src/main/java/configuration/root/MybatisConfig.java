package configuration.root;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan
@EnableTransactionManagement
public class MybatisConfig {

    @Bean
    DataSource dataSource(Environment env) {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    // SqlSessionFactory

    // MapperScanConf...

    // TransactionalManger

}
