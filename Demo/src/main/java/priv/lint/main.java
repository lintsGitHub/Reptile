package priv.lint;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import priv.lint.Utils.ReptileImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class main {
    public static void main(String[] args) {
        /*
        * @param: 参数
        * @describe: 对该功能，方法的一个描述信息
        * @return: 返回值
        * @author: 功能的负责人
        * @since: 版本号
        * */
//        ReptileImpl reptile = new ReptileImpl("http://www.zhrd.gov.cn/zhfg/");
//        reptile.graspData();
//        try {
//            URL url = new URL("https://st4024589553.iteye.com/blog/2366604");
//            System.out.println(url.toExternalForm());
//            System.out.println(url.toString());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        Connection connect = Jsoup.connect("http://www.zhuhai.gov.cn/zw/fggw_44493/zfgz_44495/201812/t20181207_49992062.html");
        try {
            Document document = connect.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36").get();
            System.out.println(document.select("div[class=content]"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
