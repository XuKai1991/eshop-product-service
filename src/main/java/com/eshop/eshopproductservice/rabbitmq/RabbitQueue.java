package com.eshop.eshopproductservice.rabbitmq;

import org.apache.commons.lang3.StringUtils;

public class RabbitQueue {

    private static final String DATA_CHANGE_QUEUE = "data-change-queue";
    private static final String REFRESH_DATA_CHANGE_QUEUE = "refresh-data-change-queue";
    private static final String HIGH_PRIORITY_DATA_CHANGE_QUEUE = "high-priority-data-change-queue";

    public static String getQueue(String operationType) {
        if (StringUtils.isEmpty(operationType)) {
            return RabbitQueue.DATA_CHANGE_QUEUE;
        } else if ("refresh".equals(operationType)) {
            return RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        } else if ("high".equals(operationType)) {
            return RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        return RabbitQueue.DATA_CHANGE_QUEUE;
    }
}
