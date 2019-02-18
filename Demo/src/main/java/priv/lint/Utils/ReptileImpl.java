package priv.lint.Utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import priv.lint.Entity.Log;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReptileImpl implements ReptileInterface {
    String url;
    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36";


    public ReptileImpl() {
    }

    public ReptileImpl(String url) {
        this.url = url;
    }

    @Override
    public void setURL(String url) {
        this.url = url;
    }

    @Override
    public int getPageNumber() {

        return 0;
    }

    @Override
    public List<URL> getTask(String url) {
        return null;
    }

    @Override
    public void graspData() {
        Connection connection;
        try {
            connection = C3P0Util.getConnection();
            connection.setAutoCommit(true);
            org.jsoup.Connection connect = Jsoup.connect(url);
            Document document = connect.userAgent(userAgent).get();
            System.out.println(document.select("div[class=n_new_list]"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void graspData(List<URL> urls) {

    }
}
