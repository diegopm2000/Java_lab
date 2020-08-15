package com.sample.dao;

import com.sample.beans.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class DAOPlayerImpl implements DAOPlayer {

    @Autowired
    private DataSource dataSource;

    @Override
    public void register(Player player) throws Exception {
        String sql = "INSERT INTO player (id, name, idTeam, idShirt) values(?,?,?,?)";
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, player.getId());
            ps.setString(2, player.getName());
            ps.setInt(3, player.getTeam().getId());
            ps.setInt(4, player.getShirt().getId());
            ps.executeUpdate();
            ps.close();
        } catch(Exception e) {
            throw e;
        } finally {
            if (con !=null) {
                con.close();
            }
        }
    }

}
