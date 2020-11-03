package com.lc.service;

import com.lc.dao.TypeDao;
import com.lc.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;

    @Override
    public Type findById(Integer id) {
        return typeDao.findById(id);
    }

    @Override
    public List<Type> findAll() {
        return typeDao.findAll();
    }
}
