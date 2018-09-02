package com.eshop.eshopproductservice.service.impl;

import com.eshop.eshopproductservice.mapper.ProductSpecificationMapper;
import com.eshop.eshopproductservice.model.ProductSpecification;
import com.eshop.eshopproductservice.rabbitmq.RabbitMQSender;
import com.eshop.eshopproductservice.rabbitmq.RabbitQueue;
import com.eshop.eshopproductservice.service.ProductSpecificationService;
import org.springframework.amqp.rabbit.connection.RabbitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

    @Autowired
    private ProductSpecificationMapper productSpecificationMapper;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void add(ProductSpecification productSpecification, String operationType) {
        productSpecificationMapper.add(productSpecification);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"add\", \"data_type\":\"product_specification\", \"id\":" + productSpecification.getId() + ", \"product_id\": " + productSpecification.getProductId() + "}");
    }

    @Override
    public void update(ProductSpecification productSpecification, String operationType) {
        productSpecificationMapper.update(productSpecification);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"update\", \"data_type\":\"product_specification\", \"id\":" + productSpecification.getId() + ", \"product_id\": " + productSpecification.getProductId() + "}");
    }

    @Override
    public void delete(Long id, String operationType) {
        Long productId = findById(id).getProductId();
        productSpecificationMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"delete\", \"data_type\":\"product_specification\", \"id\":" + id + ", \"product_id\": " + productId + "}");
    }

    @Override
    public ProductSpecification findById(Long id) {
        return productSpecificationMapper.findById(id);
    }

    @Override
    public ProductSpecification findByProductId(Long productId) {
        return productSpecificationMapper.findByProductId(productId);
    }
}
