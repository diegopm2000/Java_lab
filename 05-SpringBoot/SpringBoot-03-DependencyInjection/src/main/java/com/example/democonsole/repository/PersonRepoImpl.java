package com.example.democonsole.repository;

import com.example.democonsole.DemoconsoleApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepoImpl implements IPersonRepo {

    private static final Logger LOG = LoggerFactory.getLogger(DemoconsoleApplication.class);

    @Override
    public void register(String name) {
        LOG.info("person registered OK!");
    }

}
