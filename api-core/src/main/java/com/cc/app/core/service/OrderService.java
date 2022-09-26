package com.cc.app.core.service;

import com.cc.app.core.dao.OrderTblRepository;
import com.cc.app.core.model.OrderTbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer save(String goodName){
        Object[] params = new Object[] { null, "xujin", goodName, 1, 100};
        int n = jdbcTemplate.update("insert into order_tbl (id, user_id, commodity_code, count, money)values(?,?,?,?,?)", params);
        return n;
    }

    public Integer save2(String goodName){
        Map<String,Object> params = new HashMap<>();
        params.put("id", null);
        params.put("user_id", "xujin2");
        params.put("commodity_code", goodName);
        params.put("count", 1);
        params.put("money", 99);
        int n = namedParameterJdbcTemplate.update("insert into order_tbl (id, user_id, commodity_code, count, money)values(:id,:user_id,:commodity_code,:count,:money)", params);
        return n;
    }

    @Autowired
    private OrderTblRepository orderTblRepository;

    public OrderTbl get(Integer id){
        Optional<OrderTbl> orderTblOptional = orderTblRepository.findById(id);
        OrderTbl orderTbl = orderTblOptional.get();
        return orderTbl;
    }

    public List<OrderTbl> getAll(){
        List<OrderTbl> list = orderTblRepository.findAll();
        return list;
    }

    public Object save3(String goodName){
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUser_id("xujin");
        orderTbl.setCommodity_code(goodName);
        orderTbl.setCount(1);
        orderTbl.setMoney(98);
        OrderTbl orderTblReturn = orderTblRepository.save(orderTbl);
        return orderTblReturn;
    }
}
