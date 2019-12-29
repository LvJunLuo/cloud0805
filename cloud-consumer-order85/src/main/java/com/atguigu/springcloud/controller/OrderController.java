package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    //public static final String PaymentSrv_URL = "http://localhost:8005";
    public static final String PaymentSrv_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8005
    public CommonResult<Payment> create(Payment payment){
        return  restTemplate.postForObject(PaymentSrv_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PaymentSrv_URL +"/payment/get/"+id, CommonResult.class, id);
    }

}
