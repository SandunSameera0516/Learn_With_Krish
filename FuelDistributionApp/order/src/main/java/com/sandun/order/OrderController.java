package com.sandun.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
//Order Controller Class
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/data")
    public void placeOrder(@RequestBody OrderRequest orderRequest){
        log.info("New Order has been Placed {}",orderRequest);
        orderService.placeOrder(orderRequest);
    }

}
