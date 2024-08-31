package br.com.laplaza.record.orderStatus;

import br.com.laplaza.model.OrderStatus;

import java.time.LocalDateTime;

public record OrderStatusListData(
        Long id,
        String shortName,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {

     public OrderStatusListData(OrderStatus orderStatus){
         this(orderStatus.getId(),orderStatus.getShortName(),orderStatus.getDescription(),orderStatus.getCreatedAt(),orderStatus.getCreatedAt());
     }
}
