package priv.lint.Utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ReptileUtil {
    C3P0Util c3P0Util;
    Connection connection;
    {
        try {
            connection = c3P0Util.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
