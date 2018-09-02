package com.eshop.eshopproductservice.service.impl;

import com.eshop.eshopproductservice.mapper.BrandMapper;
import com.eshop.eshopproductservice.model.Brand;
import com.eshop.eshopproductservice.rabbitmq.RabbitMQSender;
import com.eshop.eshopproductservice.rabbitmq.RabbitQueue;
import com.eshop.eshopproductservice.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Xukai
 * @description:
 * @createDate: 2018/8/27 11:01
 * @modified By:
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void add(Brand brand, String operationType) {
        brandMapper.add(brand);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"add\", \"data_type\":\"brand\", \"id\":" + brand.getId() + "}");
    }

    @Override
    public void update(Brand brand, String operationType) {
        brandMapper.update(brand);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"update\", \"data_type\":\"brand\", \"id\":" + brand.getId() + "}");

    }

    @Override
    public void delete(Long id, String operationType) {
        brandMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"delete\", \"data_type\":\"brand\", \"id\":" + id + "}");

    }

    @Override
    public Brand findById(Long id) {
        return brandMapper.findById(id);
    }

    @Override
    public List<Brand> findByIds(String ids) {
        return brandMapper.findByIds(ids);
    }
}
