package com.eshop.eshopproductservice.service.impl;

import com.eshop.eshopproductservice.mapper.ProductPropertyMapper;
import com.eshop.eshopproductservice.model.ProductProperty;
import com.eshop.eshopproductservice.rabbitmq.RabbitMQSender;
import com.eshop.eshopproductservice.rabbitmq.RabbitQueue;
import com.eshop.eshopproductservice.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

    @Autowired
    private ProductPropertyMapper productPropertyMapper;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void add(ProductProperty productProperty, String operationType) {
        productPropertyMapper.add(productProperty);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"add\", \"data_type\":\"product_property\", \"id\":" + productProperty.getId() + ", \"product_id\": " + productProperty.getProductId() + "}");
    }

    @Override
    public void update(ProductProperty productProperty, String operationType) {
        productPropertyMapper.update(productProperty);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"update\", \"data_type\":\"product_property\", \"id\":" + productProperty.getId() + ", \"product_id\": " + productProperty.getProductId() + "}");
    }

    @Override
    public void delete(Long id, String operationType) {
        Long productId = findById(id).getProductId();
        productPropertyMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"delete\", \"data_type\":\"product_property\", \"id\":" + id + ", \"product_id\": " + productId + "}");
    }

    @Override
    public ProductProperty findById(Long id) {
        return productPropertyMapper.findById(id);
    }

    @Override
    public ProductProperty findByProductId(Long productId) {
        return productPropertyMapper.findByProductId(productId);
    }
}
