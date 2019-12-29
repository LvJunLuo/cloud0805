package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    /**
     * 写操作
     * @param payment
     */
    public void create(Payment payment);

    /**
     * 读操作
     * @param id
     * @return
     */
    public Payment getPaymentById(Long id);




}
