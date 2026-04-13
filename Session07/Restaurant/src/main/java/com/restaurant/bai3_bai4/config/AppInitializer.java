package com.restaurant.bai3_bai4.config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        MultipartConfigElement multipartConfig = new MultipartConfigElement(
                "C:/RikkeiFood_Temp/", // temp location
                10 * 1024 * 1024,// max file size = 5MB giờ là 2MB
                10 * 1024 * 1024,// max request size = 10MB giờ là 2MB
                0
        );
        registration.setMultipartConfig(multipartConfig);
    }
}