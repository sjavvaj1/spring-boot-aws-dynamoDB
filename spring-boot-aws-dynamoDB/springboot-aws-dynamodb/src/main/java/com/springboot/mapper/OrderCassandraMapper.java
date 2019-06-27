package com.springboot.mapper;

import com.springboot.domain.OrderCassandra;
import com.springboot.domain.OrderCassandraRequest;
import com.springboot.domain.OrderCassandraResponse;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class OrderCassandraMapper {

    public static OrderCassandra toDomainFromRequest(OrderCassandraRequest orderCassandraRequest) {

        if (null != orderCassandraRequest) {
            try {

                UUID uuid = UUID.randomUUID();
                String randomUUIDString = uuid.toString();

                OrderCassandra orderCassandra = new OrderCassandra();
                orderCassandra.setOrderId(randomUUIDString);
                orderCassandra.setFirstName(orderCassandraRequest.getFirstName());
                orderCassandra.setLastName(orderCassandraRequest.getLastName());
                orderCassandra.setCity(orderCassandraRequest.getCity());
                orderCassandra.setState(orderCassandraRequest.getState());
                orderCassandra.setZipCode(orderCassandraRequest.getZipCode());
                orderCassandra.setOrderTotal(orderCassandraRequest.getOrderTotal());

                orderCassandra.setProductName(orderCassandraRequest.getProductName());
                orderCassandra.setProductPrice(orderCassandraRequest.getProductPrice());
                orderCassandra.setQty(orderCassandraRequest.getQty());
                orderCassandra.setSkuId(orderCassandraRequest.getSkuId());
                                        
              return orderCassandra;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static OrderCassandraResponse toResponseFromDomain(OrderCassandra orderCassandra) {

        if (null != orderCassandra) {
            OrderCassandraResponse orderCassandraResponse = new OrderCassandraResponse();
            orderCassandraResponse.setFirstName(orderCassandra.getFirstName());
            orderCassandraResponse.setLastName(orderCassandra.getLastName());
            orderCassandraResponse.setCity(orderCassandra.getCity());
            orderCassandraResponse.setState(orderCassandra.getState());
            orderCassandraResponse.setZipCode(orderCassandra.getZipCode());
            orderCassandraResponse.setOrderId(orderCassandra.getOrderId());
            return orderCassandraResponse;
        }

        return null;

    }


}
