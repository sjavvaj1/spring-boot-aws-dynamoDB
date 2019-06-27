package com.springboot.controller;

import com.springboot.domain.OrderCassandraRequest;
import com.springboot.domain.OrderCassandraResponse;
import com.springboot.service.CassandraOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

/**
 * Created by sk on 28/10/18.
 */

@RestController
@RequestMapping("/orderCassandra")
public class OrderCassandraController {

    @Autowired
    CassandraOrderService cassandraOrderService;

    @PostMapping
    public ResponseEntity createBirthdayInvitation(@RequestBody OrderCassandraRequest orderCassandraRequest) {

        OrderCassandraResponse invitationResponse = cassandraOrderService.createOrderCassandra(orderCassandraRequest);

        if (null != invitationResponse) {
            return new ResponseEntity(invitationResponse, OK);
        } else {
            return new ResponseEntity("Issue while writing invitationRequest message", BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity getBirthdayInvitation(@RequestParam String orderId) {

        OrderCassandraResponse invitationResponse = cassandraOrderService.getOrderCassandra(orderId);

        if (null != invitationResponse) {
            return new ResponseEntity(invitationResponse, OK);
        } else {
            return new ResponseEntity("No invitation exists", BAD_REQUEST);
        }
    }

}
