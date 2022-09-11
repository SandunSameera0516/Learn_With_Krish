package com.sandun.dispatch;

import com.sandun.dispatch.entity.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DispatchRepository extends JpaRepository<Dispatch,Integer> {
    @Query(nativeQuery = true, value="SELECT * FROM dispatch ORDER BY dispatch_id DESC")
    public List<Dispatch> findAllByIdDESC();
}
