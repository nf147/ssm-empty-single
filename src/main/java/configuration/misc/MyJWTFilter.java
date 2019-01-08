package configuration.misc;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyJWTFilter extends FormAuthenticationFilter {
    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        // 插入 jwt 校验逻辑即可

        return super.onPreHandle(request, response, mappedValue);
    }
}
