package com.cc.app.core.dao;

import com.cc.app.core.model.OrderTbl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderTblRepository extends JpaRepository<OrderTbl, Integer> {

    @Override
    Optional<OrderTbl> findById(Integer id);

    @Override
    List<OrderTbl> findAll();

    @Override
    <S extends OrderTbl> S save(S s);
}
