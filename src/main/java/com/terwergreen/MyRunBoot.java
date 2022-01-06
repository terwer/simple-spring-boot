package com.terwergreen;

import com.terwergreen.springboot.SpringApplication;

/**
 * @author: terwer
 * @date: 2022/1/5 23:46
 * @description: MyRunBoot
 */
public class MyRunBoot {
    public static void main(String[] args) {
        SpringApplication.run(MyRunBoot.class, args);

        // 防止执行完成服务器自动关闭
        // 还有个问题，debug完毕后会自动退出，最好加点东西
        // 实际生产环境一般是后台进程运行
        int i = 0;
        int max = 600;// 默认服务器启动1分钟
        while (i <= max) {
            if (i == 0) {
                System.out.println("接受请求中...");
                System.out.println("为了接受请求，这里持续运行，如需关闭服务器，请手动在idea中退出运行");
            }
            ++i;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i > max) {
                System.out.println("服务器已经运行" + max  + "秒，自动停止服务器...");
            }

        }
    }
}
