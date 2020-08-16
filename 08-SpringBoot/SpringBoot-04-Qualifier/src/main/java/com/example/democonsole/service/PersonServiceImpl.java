package com.example.democonsole.service;

import com.example.democonsole.repository.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    @Qualifier("person1")
    private IPersonRepo repo;

    @Override
    public void register(String name) {
        repo.register(name);
    }
}
