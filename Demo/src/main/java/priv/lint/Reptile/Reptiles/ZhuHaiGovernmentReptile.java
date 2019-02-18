package priv.lint.Reptile.Reptiles;

import com.sun.istack.internal.NotNull;
import javafx.scene.input.DataFormat;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import priv.lint.Reptile.Entity.Policy;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ZhuHaiGovernmentReptile {
    @NotNull
    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36";
    public Map<URL, Policy> getPageList(URL url) {
        Map<URL, Policy> map = new HashMap<>();
        String s = url.toString();
        Connection connect = Jsoup.connect(s);
        try {
            Document document = connect.userAgent(userAgent).get();
            Elements select = document.select("div[class=col-2-2] a");
            for (Element element : select) {
                String substring = s.substring(0, s.lastIndexOf("/") + 1);
                String href = substring + element.attr("href");
                URL urlList = new URL(href);
                Policy policy = new Policy();
                policy.setUrl(href);
                policy.setRemark(getType(href));
                policy.setCrawlTime(new Date());
                map.put(urlList,policy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }



    public Map<URL,Policy> getTask(Map<URL, Policy> pages) {
        Set<URL> urls = pages.keySet();
        for (URL url : urls) {
            try {
                Document document = Jsoup.connect(url.toString()).userAgent(userAgent).get();
                String html = document.select("div[class=main]").html();
                pages.get(url).setContent(html);
            } catch (IOException e) {
                Document document = null;
                try {
                    document = Jsoup.connect(url.toString()).userAgent(userAgent).get();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                String html = document.select("div[class=main]").html();
                pages.get(url).setContent(html);
                e.printStackTrace();
            }
        }
        return pages;
    }

    public <T> List<T> handleTask(Class<T> tClass, List<URL> tasks) {
        return null;
    }

    public String getType(String href){
        return href.substring(href.lastIndexOf(".")+1);
    }


}
