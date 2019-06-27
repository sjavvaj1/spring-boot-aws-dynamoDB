package com.springboot.mapper;

import com.springboot.domain.OrderCassandra;
import com.springboot.domain.OrderCassandraRequest;
import com.springboot.domain.OrderCassandraResponse;
import com.springboot.domain.OrderDynamo;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class OrderDynamoMapper {


    public static OrderDynamo toDomainFromRequest(OrderCassandraRequest orderCassandraRequest) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        if (null != orderCassandraRequest) {
            try {

                //UUID uuid = UUID.randomUUID();
                //String randomUUIDString = uuid.toString();

                OrderDynamo orderDynamo = new OrderDynamo();
               // orderDynamo.setOrderId(randomUUIDString);
                orderDynamo.setFirstName(orderCassandraRequest.getFirstName());
                orderDynamo.setLastName(orderCassandraRequest.getLastName());
                orderDynamo.setCity(orderCassandraRequest.getCity());
                orderDynamo.setState(orderCassandraRequest.getState());
                orderDynamo.setZipCode(orderCassandraRequest.getZipCode());
                orderDynamo.setOrderTotal(orderCassandraRequest.getOrderTotal());

                orderDynamo.setProductName(orderCassandraRequest.getProductName());
                orderDynamo.setProductPrice(orderCassandraRequest.getProductPrice());
                orderDynamo.setQty(orderCassandraRequest.getQty());
                orderDynamo.setSkuId(orderCassandraRequest.getSkuId());

                return orderDynamo;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static OrderCassandraResponse toResponseFromDomain(OrderDynamo orderDynamo) {
        //SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        if (null != orderDynamo) {
            OrderCassandraResponse orderCassandraResponse = new OrderCassandraResponse();
            orderCassandraResponse.setFirstName(orderDynamo.getFirstName());
            orderCassandraResponse.setLastName(orderDynamo.getLastName());
            orderCassandraResponse.setCity(orderDynamo.getCity());
            orderCassandraResponse.setState(orderDynamo.getState());
            orderCassandraResponse.setZipCode(orderDynamo.getZipCode());
            orderCassandraResponse.setOrderId(orderDynamo.getOrderId());
            return orderCassandraResponse;
        }

        return null;

    }
}
