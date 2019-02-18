package priv.lint.URLReptile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HttpClientTest {
    private static Connection conn;
    private static ComboPooledDataSource source = new ComboPooledDataSource();
    static String UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36";

    public static void main(String[] args) throws IOException, PropertyVetoException, SQLException {
//        String url = "http://www.zhsme.gov.cn/policy/getPolicyList";

        add();

//        HttpClient httpClient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(url);
//        httpGet.setHeader("User-Agent",UserAgent);
//        HttpResponse execute = httpClient.execute(httpGet);
//        Connection connect = Jsoup.connect(url);
//        Document document = connect.userAgent(UserAgent).get();
//        System.out.println(document.body());
//        Elements select = document.select("h4>a");
//        Element first = select.first();
//        String href = first.attr("href");
//        String hrefURL = "http://www.zhsme.gov.cn"+href;
//        Document dom = Jsoup.connect(hrefURL).userAgent(UserAgent).get();
//        System.out.println(dom.body());
//        System.out.println(dom.select("div[class = policy-txt clear]>a"));

//        for (Element element : select) {
//            System.out.print(element.attr("href"));
//            System.out.println(element.text());
//        }
//        System.out.println(select);

        /*java.sql.Connection connection = c3p0test();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from news");
        connection.commit();*/

    }

    public static java.sql.Connection c3p0test() throws PropertyVetoException, SQLException {
        source.setDriverClass("org.mariadb.jdbc.Driver");
        source.setUser("root");
        source.setPassword("love1314");
        source.setJdbcUrl("jdbc:mariadb://localhost:3306/post");
        return source.getConnection();
    }

    public static void add() throws IOException {
        int i = 1;
        boolean domisHave = true;
        do {

            Connection connect = Jsoup.connect("http://www.zhsme.gov.cn/policy/getPolicyList?pageNum=" + i + "&NameOrWords=&areaSreachValue=&areaSreachId=&scaleSreachValue=&scaleSreachId=&levelSreachValue=&levelSreachId=&isShuangChuang=");
            if (connect == null)
                domisHave = false;
            try {
                connect.userAgent(UserAgent);
                Elements select = connect.get().select("div[class=list-txt left]>h4>a");
                for (Element element : select) {
                    String text = element.text();
                    String href = "http://www.zhsme.gov.cn" + element.attr("href");
                    String content = getContent(href);
                    setSQL(text,content);
                }
//                System.out.println(connect.userAgent(UserAgent).get().body().html());
            } catch (Exception e) {
                System.out.println("有错");
                System.out.println(e.getMessage());
            }
            System.out.println(i);
            i++;

        } while (domisHave);
    }
    public static String getContent(String s) throws IOException {
        Connection connect = Jsoup.connect(s);
        Document document = connect.userAgent(UserAgent).get();
        String attr = document.select("div[class = policy-txt clear]>a:nth-child(2)[onclick]").attr("onclick");
//        System.out.println(attr);
        String substring = "http://www.zhsme.gov.cn/policy/getTextPolicyByTextPolicyId?textPolicyId=" + attr.substring(attr.indexOf("'") + 1, attr.lastIndexOf("'"));
//        System.out.println(substring);
        Elements select = Jsoup.connect(substring).userAgent(UserAgent).get().select("div[class=view-content]");
       return select.toString();
    }
    public static void setSQL(String title, String body) throws PropertyVetoException, SQLException {
        java.sql.Connection connection = c3p0test();
        Statement statement = connection.createStatement();
        int resultSet = statement.executeUpdate("insert into zhengce (title,body) value ('"+title+"','"+body+"')");
        connection.commit();
    }
}
