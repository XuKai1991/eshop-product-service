package com.eshop.eshopproductservice.service.impl;

import com.eshop.eshopproductservice.mapper.ProductIntroMapper;
import com.eshop.eshopproductservice.model.ProductIntro;
import com.eshop.eshopproductservice.rabbitmq.RabbitMQSender;
import com.eshop.eshopproductservice.rabbitmq.RabbitQueue;
import com.eshop.eshopproductservice.service.ProductIntroService;
import org.springframework.amqp.rabbit.connection.RabbitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductIntroServiceImpl implements ProductIntroService {

    @Autowired
    private ProductIntroMapper productIntroMapper;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void add(ProductIntro productIntro, String operationType) {
        productIntroMapper.add(productIntro);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"add\", \"data_type\":\"product_intro\", \"id\":" + productIntro.getId() + ", \"product_id\": " + productIntro.getProductId() + "}");
    }

    @Override
    public void update(ProductIntro productIntro, String operationType) {
        productIntroMapper.update(productIntro);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"update\", \"data_type\":\"product_intro\", \"id\":" + productIntro.getId() + ", \"product_id\": " + productIntro.getProductId() + "}");
    }

    @Override
    public void delete(Long id, String operationType) {
        Long productId = findById(id).getProductId();
        productIntroMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"delete\", \"data_type\":\"product_intro\", \"id\":" + id + ", \"product_id\": " + productId + "}");
    }

    @Override
    public ProductIntro findById(Long id) {
        return productIntroMapper.findById(id);
    }

}
