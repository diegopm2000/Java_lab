package com.sample.dao;

import com.sample.beans.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class DAOMarkImpl implements DAOMark {

    @Autowired
    private DataSource dataSource;

    @Override
    public void register(Mark mark) throws Exception {
        String sql = "INSERT INTO mark (id, name) values(?,?)";
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mark.getId());
            ps.setString(2, mark.getName());
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
