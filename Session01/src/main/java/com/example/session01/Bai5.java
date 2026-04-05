package com.example.session01;

import com.example.session01.config.AppConfig;
import com.example.session01.model.SystemConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Bai5 {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SystemConfig config = context.getBean(SystemConfig.class);

        System.out.println("Tên chi nhánh: " + config.getBranchName());
        System.out.println("Giờ mở cửa: " + config.getOpeningHour());
    }
}