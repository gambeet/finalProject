package com.yevhenii.service;

import com.yevhenii.model.ForFiles;
import com.yevhenii.repository.ForFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForFilesService {
    @Autowired
    ForFilesRepository repository;
    public void save(ForFiles item){
        repository.save(item);
    }

    public ForFiles getByName(String name){
        return repository.findByName(name);
    }
}
