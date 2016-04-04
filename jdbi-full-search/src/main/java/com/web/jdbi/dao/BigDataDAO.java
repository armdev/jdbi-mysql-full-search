package com.web.jdbi.dao;

import com.web.jdbi.mapper.BigDataMapper;
import com.web.jdbi.dto.BigData;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface BigDataDAO {

    @Mapper(BigDataMapper.class)
    @SqlQuery("SELECT * FROM bigdata WHERE MATCH(title, content) AGAINST(:searchKey  IN BOOLEAN MODE)")
    List<BigData> doFullSearch(@Bind("searchKey") String searchKey);

}
