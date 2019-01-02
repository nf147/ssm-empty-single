package configuration.misc;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
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
        bean.setUnauthorizedUrl("/500");

        // 规则设定
        // 基于 url 的规则
        HashMap<String, String> rules = new HashMap<>();
        rules.put("/admin/**", "authc");
        rules.put("/policy/**", "authc");
        rules.put("/policy/view", "anon");
        rules.put("/logout", "logout");
        bean.setFilterChainDefinitionMap(rules);

        return bean;
    }
}