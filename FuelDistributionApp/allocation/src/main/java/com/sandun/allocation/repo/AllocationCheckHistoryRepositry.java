package com.sandun.allocation.repo;

import com.sandun.allocation.entity.AllocationCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

//Allocation Repo Which Connects Spring JPA
//Got the Allocation Class as a <>
public interface AllocationCheckHistoryRepositry
        extends JpaRepository<AllocationCheckHistory,Long> {
}
