package com.example.springbootstage.service.work;

import com.example.springbootstage.dao.work.StoreDao;
import com.example.springbootstage.entity.work.Store;
import com.example.springbootstage.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService implements BaseService<Store> {

    @Autowired
    private StoreDao storeDao;

    @Override
    public Store save(Store store) {
        return storeDao.save(store);
    }

    @Override
    public Store getById(Long id) {
        Optional<Store> optional = storeDao.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Store> getAll() {
        Iterable<Store> it = storeDao.findAll();
        List<Store> storeList = new LinkedList<>();
        it.forEach(storeList::add);
        return storeList;
    }

    @Override
    public void delById(Long id) {
        storeDao.deleteById(id);
    }
}