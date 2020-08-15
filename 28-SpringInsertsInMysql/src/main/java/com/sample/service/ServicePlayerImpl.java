package com.sample.service;

import com.sample.beans.Player;
import com.sample.dao.DAOPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePlayerImpl implements ServicePlayer {

    @Autowired
    private DAOPlayer daoPlayer;

    @Override
    public void register(Player player) throws Exception {
        try {
            daoPlayer.register(player);
        } catch(Exception e) {
            throw e;
        }
    }
}
