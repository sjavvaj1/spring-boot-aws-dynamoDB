package com.springboot.repository;

import com.datastax.driver.core.querybuilder.Clause;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.springboot.domain.OrderCassandra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class OrderCassandraRepositoryImpl implements OrderCassandraRepository {

    @Autowired
    CassandraOperations cassandraOperations;

    @Override
    public OrderCassandra createOrderCassandra(OrderCassandra orderCassandra) {

        OrderCassandra updatedOrderCassandra = cassandraOperations.insert(orderCassandra);

        // System.out.println("after  createInvitation of OrderCassandraRepositoryImpl");

        return updatedOrderCassandra;

        //return null;
    }

    @Override
    public OrderCassandra getOrderCassandra(String orderId) {

        System.out.println("before query builder getOrderCassandra"+orderId);

        Select selectQuery = QueryBuilder.select().all().from("springcassandra", "orderData");
        Select.Where selectWhere = selectQuery.where();
        Clause clause = QueryBuilder.eq("orderId", orderId);
        selectWhere.and(clause);

        System.out.println("before selectQuery"+selectQuery.getKeyspace()+selectQuery.getQueryString()
        + selectWhere.getQueryString() );

        List<OrderCassandra> orderCassandraList = cassandraOperations.select(selectWhere.getQueryString(), OrderCassandra.class);


        System.out.println("orderCassandraList"+ orderCassandraList.get(1).getFirstName());

        // We can handle it better
        if(!CollectionUtils.isEmpty(orderCassandraList)) {
            return orderCassandraList.get(0);
        } else {
            return null;
        }
    }
}
