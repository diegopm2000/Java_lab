package com.example.democonsole.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepoImpl implements IPersonRepo {

    private static final Logger LOG = LoggerFactory.getLogger(PersonRepoImpl.class);

    @Override
    public void register(String name) {

        LOG.info("person registered OK!");
    }

}
