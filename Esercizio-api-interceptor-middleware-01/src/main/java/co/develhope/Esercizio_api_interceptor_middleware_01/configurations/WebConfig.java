package co.develhope.Esercizio_api_interceptor_middleware_01.configurations;

import co.develhope.Esercizio_api_interceptor_middleware_01.interceptors.APILoggingInterceptor;
import co.develhope.Esercizio_api_interceptor_middleware_01.interceptors.LegacyInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;

    @Autowired
    private LegacyInterceptors legacyInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(apiLoggingInterceptor);
       registry.addInterceptor(legacyInterceptor).addPathPatterns("/legacy");
    }
}
