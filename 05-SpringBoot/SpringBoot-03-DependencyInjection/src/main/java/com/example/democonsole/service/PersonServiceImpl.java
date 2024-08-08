package com.example.democonsole.service;

import com.example.democonsole.repository.IPersonRepo;
import com.example.democonsole.repository.PersonRepoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {

    private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private IPersonRepo repo;

    @Override
    public void register(String name) {

        LOG.info("Registering person...");
        repo.register(name);
        LOG.info("person registered OK!");

    }
}
