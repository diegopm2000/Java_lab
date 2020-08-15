package com.sample.service;

import com.sample.beans.Mark;
import com.sample.dao.DAOMark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceMarkImpl implements ServiceMark {

    @Autowired
    private DAOMark daoMark;

    @Override
    public void register(Mark mark) throws Exception {
        try {
            daoMark.register(mark);
        } catch(Exception e) {
            throw e;
        }
    }
}
