package com.sandun.allocation;

import com.sandun.allocation.entity.Stock;
import com.sandun.allocation.repo.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Handles Http Requests
@RestController
@RequestMapping("api/v1/allocation-check")
@AllArgsConstructor
public class AllocationController {

    private final AllocationCheckService allocationCheckService;
    private final StockRepository stockRepository;

    //Update Stock Amount From Admin (Intial Built)
    @CrossOrigin(origins = "http://localhost:4201")
    @PostMapping("/update-stock")
    public void updatedStock(@RequestBody UpdateStockmessage updateStockmessage){
        allocationCheckService.stockUpdate(updateStockmessage);
    }
    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/get-all")
    public List<Stock> getOrders(){
        return stockRepository.findByIdDESC();
    }

}
