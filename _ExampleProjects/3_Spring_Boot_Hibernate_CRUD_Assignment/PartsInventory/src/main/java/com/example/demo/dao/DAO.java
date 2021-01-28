package com.example.demo.dao;

import com.example.demo.entity.CPU;

import java.util.List;


public interface DAO {
    List<Object> findAll(String q);
    Object findById(Object table, int id);
    void save(Object o);
    void deleteById(String table, int id);
}
