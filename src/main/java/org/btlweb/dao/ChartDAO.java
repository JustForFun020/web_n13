package org.btlweb.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import org.btlweb.jdbc.*;

public class ChartDAO {
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<String> getLabels() {
        List<String> labels = new ArrayList<>();
        String query = "SELECT createAt FROM [BTLWEB].[dbo].[TodoList]";
        try {
            c = new JDBCUnit().getConnection();
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                Date createAt = rs.getDate(1);
                String dateString = createAt.toString();
                String day = dateString.split("-")[2] + "/" + dateString.split("-")[1];
                labels.add(day);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return labels;
    }

    public List<Integer> getData() {
        List<Integer> data = new ArrayList<>();
        String query = "SELECT COUNT(*) FROM [BTLWEB].[dbo].[TodoList] GROUP BY createAt";
        try {
            c = new JDBCUnit().getConnection();
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int count = rs.getInt(1);
                data.add(count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
