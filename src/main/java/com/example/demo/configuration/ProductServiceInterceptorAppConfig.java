package com.example.demo.configuration;

import com.example.demo.interceptor.ProductServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.validation.constraints.NotNull;

@Component
public class ProductServiceInterceptorAppConfig extends WebMvcConfigurationSupport {
    @Autowired
    ProductServiceInterceptor productServiceInterceptor;

    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
        registry.addInterceptor(productServiceInterceptor);
    }
}
