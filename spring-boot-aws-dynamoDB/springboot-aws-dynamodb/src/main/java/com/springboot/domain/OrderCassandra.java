package com.springboot.domain;

import com.datastax.driver.core.DataType;
import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.math.BigDecimal;

/**
 * Created by sk on 28/10/18.
 */

@Table("orderData")
public class OrderCassandra {



    @PrimaryKeyColumn(name = "orderId",  ordinal = 2, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
    @CassandraType(type = DataType.Name.TEXT)
    private String orderId;

    @CassandraType(type = DataType.Name.TEXT)
    private String firstName;
    @CassandraType(type = DataType.Name.TEXT)
    private String lastName;
    @CassandraType(type = DataType.Name.TEXT)
    private String state;
    @CassandraType(type = DataType.Name.TEXT)
    private String city;
    @CassandraType(type = DataType.Name.TEXT)
    private String zipCode;
    @CassandraType(type = DataType.Name.DECIMAL)
    private BigDecimal orderTotal;

    @CassandraType(type = DataType.Name.TEXT)
    private String  skuId;
    @CassandraType(type = DataType.Name.TEXT)
    private String  productName;
    @CassandraType(type = DataType.Name.INT)
    private Integer productPrice;

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @CassandraType(type = DataType.Name.INT)
    private Integer qty;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }





}
