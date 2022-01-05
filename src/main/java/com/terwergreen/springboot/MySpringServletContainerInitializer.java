package com.terwergreen.springboot;

import javax.servlet.Filter;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServlet;
import java.util.Set;

/**
 * @author: terwer
 * @date: 2022/1/6 00:35
 * @description: MySpringServletContainerInitializer
 */
// 这里的意思是把实现了这些接口的类注入到下面的onStartup中的set集合，用于特殊处理
@HandlesTypes({HttpServlet.class, Filter.class})
public class MySpringServletContainerInitializer implements ServletContainerInitializer {

    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("servlet调用MySpringServletContainerInitializer");

        // 下面的不需要，因为实现了WebApplicationInitializer接口的类Spring会自己调用
        // 跟踪代码可以看到，Spring也有一个SpringServletContainerInitializer
        // SpringServletContainerInitializer也是servlet容器负责调用的
        // 那里面会自动调用实现了ServletContainerInitializer接口的onStartup方法
        // new MyWebApplicationInitializer().onStartup(servletContext);
    }
}
