package com.web.jdbi.mapper;

import com.web.jdbi.dto.BigData;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class BigDataMapper implements ResultSetMapper<BigData> {

    @Override
    public BigData map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        return new BigData(
                r.getInt("id"), r.getString("title"),
                r.getString("content"), r.getString("url"));
    }
}
