package cn.fastrpc;

/**
 * @File : ConsumerApplication.py
 * @Author : LiXin Huang, NWPU
 * @Desc :  Consumer启动项
 * @Email : iHuanglixin@outlook.com
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}