package priv.lint.Reptile.DAO;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import priv.lint.Reptile.Entity.Analyzing;
import priv.lint.Reptile.Entity.Policy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Dao {
    static ComboPooledDataSource source = new ComboPooledDataSource();
    static Connection connection;

    static {
        try {
            connection = source.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public C3P0Dao() {

    }

    static int count = 0;

    public static void insertPolicy(Policy policy) throws SQLException {
        String sql = "insert into policy_raw (url,crawl_time,content,remark) values (?,?,?,?)";
//        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, policy.getUrl());
        preparedStatement.setObject(2, policy.getCrawlTime());
        preparedStatement.setObject(3, policy.getContent());
        preparedStatement.setObject(4, policy.getUrl());

        int i = preparedStatement.executeUpdate();
        if (i > 0)
            count++;
        System.out.println(count);
    }

    public static void insertAnalyzing(Analyzing analyzing) throws SQLException {
        String sql = "insert into analyzing_raw (crawl_url,crawl_time,content,status) values (?,?,?,?)";
//        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, analyzing.getCrawlUrl());
        preparedStatement.setObject(2, analyzing.getCrawlTime());
        preparedStatement.setObject(3, analyzing.getContent());
        preparedStatement.setObject(4, analyzing.getStatus());

        int i = preparedStatement.executeUpdate();
        if (i > 0)
            count++;
        System.out.println(count);
    }
}
