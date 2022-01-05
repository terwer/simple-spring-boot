package com.terwergreen.springboot;

import com.terwergreen.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author: terwer
 * @date: 2022/1/5 23:37
 * @description: MyWebApplicationInitializer
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("开始创建Spring上下文");

        // 通过注解的方式初始化Spring的上下文
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        // 注册spring的配置类（替代传统项目中xml的configuration）
        ac.register(AppConfig.class);
        ac.refresh();

        // 基于java代码的方式初始化DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");

        System.out.println("DispatcherServlet添加完毕，Spring MVC初始化完成");
    }
}
