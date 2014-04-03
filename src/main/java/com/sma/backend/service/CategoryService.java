package com.sma.backend.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sma.backend.dao.CategoryDao;
import com.sma.backend.json.JCategory;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao dao;
    
    public List<JCategory> getCategoriesByType(String type) {
        return Collections.EMPTY_LIST;
    }
    
    
    public Collection<JCategory> getAll() {
        Collection<JCategory> dList= dao.getAll();
        
        return dList;
    }
    @Autowired
    public void setDao(CategoryDao dao) {
        this.dao = dao;
    }
}
