package com.example.democonsole.repository;

import com.example.democonsole.DemoconsoleApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("person2")
public class PersonRepoImpl2 implements IPersonRepo {

    private static final Logger LOG = LoggerFactory.getLogger(DemoconsoleApplication.class);

    @Override
    public void register(String name) {
        LOG.info("person registered OK!");
    }

}
