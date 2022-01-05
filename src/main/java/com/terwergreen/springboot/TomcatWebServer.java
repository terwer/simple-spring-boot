package com.terwergreen.springboot;

import org.apache.catalina.startup.Tomcat;

/**
 * @author: terwer
 * @date: 2022/1/6 00:06
 * @description: TomcatWebServer
 */
public class TomcatWebServer {
    private Tomcat tomcat;

    public TomcatWebServer(Tomcat tomcat) {
        this.tomcat = tomcat;
    }

    public void start() throws Exception {
        this.tomcat.start();
        System.out.println("Tomcat已启动");
    }

    public void stop() throws Exception {
        this.tomcat.stop();
        System.out.println("Tomcat已停止");
    }
}
