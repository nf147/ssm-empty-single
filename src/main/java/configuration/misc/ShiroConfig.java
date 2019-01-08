package configuration.misc;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.config.ShiroAnnotationProcessorConfiguration;
import org.apache.shiro.spring.config.ShiroBeanConfiguration;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Configuration
@Import({
        ShiroAnnotationProcessorConfiguration.class,
        ShiroBeanConfiguration.class
})
public class ShiroConfig {

    @Bean
    DefaultWebSecurityManager securityManager () {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(new JdbcRealm());
        return manager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilter () {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());

        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/home");
        bean.setUnauthorizedUrl("/unauth");

        bean.setFilters(new LinkedHashMap<String, Filter>() {{
            put("jwt", new MyJWTFilter());
        }});

        // 规则设定
        // 基于 url 的规则
        HashMap<String, String> rules = new HashMap<>();
        rules.put("/logout", "logout");
        rules.put("/login", "anon");
        rules.put("/aaa", "anon");
        rules.put("/bbb", "anon");
        rules.put("/**", "jwt");
        bean.setFilterChainDefinitionMap(rules);

        return bean;
    }
}