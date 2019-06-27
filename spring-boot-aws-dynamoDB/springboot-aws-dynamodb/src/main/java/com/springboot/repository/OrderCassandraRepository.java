package com.springboot.repository;

import com.springboot.domain.OrderCassandra;

public interface OrderCassandraRepository {

    OrderCassandra createOrderCassandra(OrderCassandra orderCassandra);
    OrderCassandra getOrderCassandra(String orderId);
}
