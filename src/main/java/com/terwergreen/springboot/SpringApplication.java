package com.terwergreen.springboot;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author: terwer
 * @date: 2022/1/5 23:31
 * @description: SpringApplication
 */
public class SpringApplication {
    public static final String DEFAULT_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol";

    public static void run(Class<?> clazz, String[] args) {

        // 创建并启动Tomcat
        try {
            // 1、创建Tomcat
            Tomcat tomcat = new Tomcat();
            // 根目录
            File baseDir = createTempDir("tomcat");
            tomcat.setBaseDir(baseDir.getAbsolutePath());
            // 连接器
            Connector connector = new Connector(DEFAULT_PROTOCOL);
            // 端口，第一种方式不行，经过验证，必须是使用connector设置端口
            // tomcat.setPort(8080);
            connector.setPort(8080);
            tomcat.getService().addConnector(connector);
            // 注意：这一部一定要加
            File root = new File("src/main/webapp");
            tomcat.addWebapp("/", root.getAbsolutePath());
            // 取消自动部署
            tomcat.getHost().setAutoDeploy(false);

            // 2、启动Tomcat服务器
            TomcatWebServer webServer = new TomcatWebServer(tomcat);
            webServer.start();

            System.out.println("Tomcat启动完毕");
        } catch (Exception e) {
            System.out.println("Tomcat创建失败");
            e.printStackTrace();
        }
    }


    /**
     * 创建临时目录
     *
     * @param prefix
     * @return
     */
    private static final File createTempDir(String prefix) throws Exception {
        try {
            File tempDir = Files.createTempDirectory(prefix + ".").toFile();
            tempDir.deleteOnExit();
            return tempDir;
        } catch (IOException ex) {
            throw new Exception(
                    "无法创建临时目录 " + System.getProperty("java.io.tmpdir"), ex);
        }
    }
}
