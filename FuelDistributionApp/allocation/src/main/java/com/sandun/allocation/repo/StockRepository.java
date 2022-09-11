package com.sandun.allocation.repo;

import com.sandun.allocation.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Stock Table Repository
@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {

    //Getting the Last Entered Value
    @Query(nativeQuery = true, value="SELECT * FROM stock ORDER BY id DESC LIMIT 1")
    public List<Stock> findByIdDESC();
}
