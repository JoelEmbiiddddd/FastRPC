package cn.fastrpc.controller;

import cn.fastrpc.rpc.api.service.HelloWordService;
import cn.fastrpc.rpc.client.annotation.RpcAutowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @File : HelloWorldController.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

@Controller
public class HelloWorldController {

    @RpcAutowired(version = "1.0")
    private HelloWordService helloWordService;

    @GetMapping("/hello/world")
    public ResponseEntity<String> pullServiceInfo(@RequestParam("name") String name){
        return  ResponseEntity.ok(helloWordService.sayHello(name));
    }


    @GetMapping("/hello/world2")
    public ResponseEntity<String> pullServiceInfo_2(@RequestParam("name") String name){
        return  ResponseEntity.ok(helloWordService.sayHello("I got your message"));
    }



}
