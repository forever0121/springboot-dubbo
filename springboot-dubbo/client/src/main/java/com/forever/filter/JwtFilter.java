package com.forever.filter;

import com.forever.exception.LoginException;
import com.forever.util.Audience;
import com.forever.util.Constants;
import com.forever.util.JwtHelper;
import com.forever.util.ResultEnum;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asus on 2018/10/2.
 */
public class JwtFilter extends GenericFilterBean {

    @Autowired
    private Audience audience;

    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"/login","register"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        //等到请求头信息authorization信息
        final String authHeader = request.getHeader("authorization");
        //是否需要过滤
        String uri = request.getRequestURI();
        boolean needFilter = isNeedFilter(uri);
        if (!needFilter) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (authHeader == null || !authHeader.startsWith("bearer;")) {
                throw new LoginException(ResultEnum.LOGIN_ERROR);
            }
            final String token = authHeader.substring(7);

            try {
                if(audience == null){
                    BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                    audience = (Audience) factory.getBean("audience");
                }
                final Claims claims = JwtHelper.parseJWT(token,audience.getBase64Secret());
                if(claims == null){
                    throw new LoginException(ResultEnum.LOGIN_ERROR);
                }
                request.setAttribute(Constants.CLAIMS, claims);
            } catch (final Exception e) {
                throw new LoginException(ResultEnum.LOGIN_ERROR);
            }

            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if(includeUrl.equals(uri)) {
                return false;
            }
        }
        return true;
    }
}
