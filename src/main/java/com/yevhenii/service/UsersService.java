package com.yevhenii.service;

import com.yevhenii.model.User;
import com.yevhenii.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UsersService {
    @Autowired
    private UsersRepository repository;
    public void save(User item) {
        repository.save(item);
    }

    public List<User> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());
    }

    public void delete(int id){
        repository.delete(id);
    }

    public void update(User item){
        repository.save(item);
    }

    public User getById(int id){
        return repository.findOne(id);
    }
}
