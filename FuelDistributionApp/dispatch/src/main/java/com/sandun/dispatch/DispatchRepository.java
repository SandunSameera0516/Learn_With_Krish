package com.sandun.dispatch;

import com.sandun.dispatch.entity.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatchRepository extends JpaRepository<Dispatch,Integer> {
}
