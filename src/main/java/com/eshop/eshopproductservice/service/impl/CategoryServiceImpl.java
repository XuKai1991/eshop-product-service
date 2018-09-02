package com.eshop.eshopproductservice.service.impl;

import com.eshop.eshopproductservice.mapper.CategoryMapper;
import com.eshop.eshopproductservice.model.Category;
import com.eshop.eshopproductservice.rabbitmq.RabbitMQSender;
import com.eshop.eshopproductservice.rabbitmq.RabbitQueue;
import com.eshop.eshopproductservice.service.CategoryService;
import org.springframework.amqp.rabbit.connection.RabbitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Xukai
 * @description:
 * @createDate: 2018/8/27 11:13
 * @modified By:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void add(Category category, String operationType) {
        categoryMapper.add(category);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"add\", \"data_type\":\"category\", \"id\":" + category.getId() + "}");
    }

    @Override
    public void update(Category category, String operationType) {
        categoryMapper.update(category);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"update\", \"data_type\":\"category\", \"id\":" + category.getId() + "}");

    }

    @Override
    public void delete(Long id, String operationType) {
        categoryMapper.delete(id);
        rabbitMQSender.send(RabbitQueue.getQueue(operationType), "{\"event_type\":\"delete\", \"data_type\":\"category\", \"id\":" + id + "}");

    }

    @Override
    public Category findById(Long id) {
        return categoryMapper.findById(id);
    }
}
