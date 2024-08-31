package br.com.laplaza.record.orderStatus;

import br.com.laplaza.model.OrderStatus;

import java.time.LocalDateTime;

public record OrderStatusListData(
        Long id,
        String shortName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {

     public OrderStatusListData(OrderStatus orderStatus){
         this(orderStatus.getId(),orderStatus.getShortName(),orderStatus.getCreatedAt(),orderStatus.getCreatedAt());
     }
}
