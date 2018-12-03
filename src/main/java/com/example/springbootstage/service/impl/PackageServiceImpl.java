package com.example.springbootstage.service.impl;

import com.example.springbootstage.dao.PackageDao;
import com.example.springbootstage.entity.Package;
import com.example.springbootstage.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageDao packageDao;

    @Override
    public Package save(Package p) {
        return packageDao.save(p);
    }

    @Override
    public Package getById(Long id) {
        Optional<Package> optional = packageDao.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Package> getAll() {
        Iterable<Package> it = packageDao.findAll();
        List<Package> packageList = new LinkedList<>();
        it.forEach(packageList::add);
        return packageList;
    }

    @Override
    public void delById(Long id) {
        packageDao.deleteById(id);
    }
}
