package br.com.laplaza.model;

import br.com.laplaza.record.orderStatus.OrderStatusRegistrationData;
import br.com.laplaza.record.orderStatus.OrderStatusUpdateData;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.*;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity(name = "OrderStatus")
@Table(name = "order_status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public OrderStatus(OrderStatusRegistrationData newOrderStatus){
        this.setShortName(newOrderStatus.shortName());
        this.setDescription(newOrderStatus.description());
        this.setCreatedAt(LocalDateTime.now());
        this.setCreatedAt(LocalDateTime.now());
    }

    public void updateData(@Valid OrderStatusUpdateData updateData){

        if(updateData.shortName() != null){
            this.setShortName(updateData.shortName());
        }

        if(updateData.shortName() != null){
            this.setShortName(updateData.shortName());
        }

        if(updateData.description() != null){
            this.setDescription(updateData.description());
        }

        this.setUpdatedAt(LocalDateTime.now());
    }

}
