package com.eshop.eshopproductservice.service.impl;

import com.eshop.eshopproductservice.mapper.ProductMapper;
import com.eshop.eshopproductservice.model.Product;
import com.eshop.eshopproductservice.rabbitmq.RabbitMQSender;
import com.eshop.eshopproductservice.rabbitmq.RabbitQueue;
import com.eshop.eshopproductservice.service.ProductService;
import org.springframework.amqp.rabbit.connection.RabbitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Xukai
 * @description:
 * @createDate: 2018/8/27 11:17
 * @modified By:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void add(Product product, String operationType) {
        productMapper.add(product);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"add\", \"data_type\":\"product\", \"id\":" + product.getId() + "}");
    }

    @Override
    public void update(Product product, String operationType) {
        productMapper.update(product);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"update\", \"data_type\":\"product\", \"id\":" + product.getId() + "}");
    }

    @Override
    public void delete(Long id, String operationType) {
        productMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"delete\", \"data_type\":\"product\", \"id\":" + id + "}");
    }

    @Override
    public Product findById(Long id) {
        return productMapper.findById(id);
    }
}
