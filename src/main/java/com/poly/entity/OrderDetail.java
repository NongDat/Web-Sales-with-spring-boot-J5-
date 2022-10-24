// Generated with g9.

package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrderDetails")
public class OrderDetail implements Serializable {

   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @Column(name="Id", unique=true, nullable=false, precision=19)
    private Integer id;
//    @Column(name="Price", nullable=false, precision=53)
    private double price;
//    @Column(name="Quantity", nullable=false, precision=10)
    private Integer quantity;
    
    @ManyToOne
    @JoinColumn(name="OrderId")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name="ProductId")
    private Product product;

    

}
