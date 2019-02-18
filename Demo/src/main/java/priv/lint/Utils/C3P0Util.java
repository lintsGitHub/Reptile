package priv.lint.Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Util {
    public static Connection getConnection() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        return comboPooledDataSource.getConnection();
    }

}
