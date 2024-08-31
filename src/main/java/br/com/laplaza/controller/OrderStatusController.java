package br.com.laplaza.controller;

import br.com.laplaza.model.OrderStatus;
import br.com.laplaza.record.orderStatus.OrderStatusListData;
import br.com.laplaza.record.orderStatus.OrderStatusRegistrationData;
import br.com.laplaza.record.orderStatus.OrderStatusUpdateData;
import br.com.laplaza.repository.OrderStatusRepository;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order-status")
public class OrderStatusController {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Transactional
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid OrderStatusRegistrationData orderStatus){

        OrderStatus newOrderStatus = this.orderStatusRepository.save(new OrderStatus(orderStatus));

        return  ResponseEntity.ok("Status "+newOrderStatus.getShortName()+" - "+newOrderStatus.getDescription()+" criado com sucesso.");
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody OrderStatusUpdateData orderStatusUpdateData) throws Exception {
        OrderStatus orderStatus = this.orderStatusRepository.getReferenceById(orderStatusUpdateData.id());

        orderStatus.updateData(orderStatusUpdateData);

        return ResponseEntity.ok("Alterações realizadas com sucesso");
    }

    @GetMapping("/all")
    public Page<OrderStatusListData> all(@PageableDefault(size = 10, sort = {"shortName"}) Pageable pageable ){

        return this.orderStatusRepository.findAll(pageable).map(OrderStatusListData::new);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        OrderStatus orderStatus = this.orderStatusRepository.getReferenceById(id);

        this.orderStatusRepository.delete(orderStatus);

        return ResponseEntity.ok("Status deletado com sucesso!");
    }



}
