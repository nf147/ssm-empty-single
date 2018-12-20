package the_ioc.components;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

public class Goal implements
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        BeanPostProcessor, // 后置处理器
        InitializingBean,
        DisposableBean {
    private String name;
    private int countOfLegs;

    private List<String> aliases;

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfLegs() {
        return countOfLegs;
    }

    public void setCountOfLegs(int countOfLegs) {
        this.countOfLegs = countOfLegs;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("zhexingzhgeg.");
    }

    public void xxx() {
        System.out.println("xxx");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public void destroy() throws Exception {

    }

    public void ddd() {

    }
}

// Goal g = new Goal();
// g.setCountOfLegs(3);
// g.setName("多利");

