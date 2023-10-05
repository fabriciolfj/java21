package com.github.fabriciolfj;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringTemplateQuery {

    public static void main(String[] args) throws SQLException {
        var DB = new QueryBuilder(null);
        String type = "Les Paul";
        PreparedStatement ps = DB."SELECT * FROM Guitar g WHERE g.guitar_type = \{type}";
        ResultSet rs = ps.executeQuery();
    }
}
