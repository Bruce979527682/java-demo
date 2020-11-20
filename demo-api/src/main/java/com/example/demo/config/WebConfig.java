package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bruce
 * @date 2020/11/19 16:36
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public AuthInterceptor getAuthInterceptor(){
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> commonExclude = new ArrayList<>();
        // swagger拦截白名单
        commonExclude.add("/swagger-ui.html");
        commonExclude.add("/swagger-resources/**");
        commonExclude.add("/error");
        commonExclude.add("/webjars/**");
        // 系统白名单
        commonExclude.add("/health");
        commonExclude.add("/login");
        // 权限拦截
        registry.addInterceptor(getAuthInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(commonExclude);
    }
}
