package com.sandun.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
//Order Controller Class
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/data")
    public void placeOrder(@RequestBody OrderRequest orderRequest){
        log.info("New Order has been Placed {}",orderRequest);
        orderService.placeOrder(orderRequest);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get-all")
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

}
