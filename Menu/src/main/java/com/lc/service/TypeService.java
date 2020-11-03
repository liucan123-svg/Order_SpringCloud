package com.lc.service;

import com.lc.entity.Type;

import java.util.List;


public interface TypeService {
    public Type findById(Integer id);

    public List<Type> findAll();
}
