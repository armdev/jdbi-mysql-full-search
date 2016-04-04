package com.web.jdbi.init;

import com.web.jdbi.dto.BigData;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import com.web.jdbi.dao.BigDataDAO;
import javax.faces.bean.ViewScoped;

@ManagedBean(eager = false, name = "databaseBean")
@ViewScoped
public class DatabaseBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private final DBI dbi = new DBI(DatabaseBean.getDataSource());

    private BigDataDAO bigDataDao = null;
    private Handle handle;
    private String searchKey;

    public DatabaseBean() {

    }

    @PostConstruct
    public void init() {
        bigDataDao = dbi.open(BigDataDAO.class);
    }

    public List<BigData> getContentList() {

        List<BigData> list = bigDataDao.doFullSearch(searchKey);
        return list;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    private static DataSource getDataSource() {
        DataSource ds = null;
        InitialContext contex;
        try {
            contex = new InitialContext();

            ds = (DataSource) contex.lookup("java:comp/env/jdbc/mysql");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ds;
    }
}
