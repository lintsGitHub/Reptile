package priv.lint.Reptile.Reptiles;

import com.sun.istack.internal.NotNull;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import priv.lint.Reptile.Entity.Analyzing;
import priv.lint.Reptile.Entity.Policy;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ZhuHaiAnalyzingReptile {
    @NotNull
    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36";
    public Map<URL, Analyzing> getPageList(URL url) {
        Map<URL, Analyzing> map = new HashMap<>();
        String s = url.toString();
        Connection connect = Jsoup.connect(s);
        try {
            Document document = connect.userAgent(userAgent).get();
            Elements select = document.select("div[class=col-2-2] a");
            for (Element element : select) {
                String substring = s.substring(0, s.lastIndexOf("/") + 1);
                String href = substring + element.attr("href");
                URL urlList = new URL(href);
                Analyzing analyzing = new Analyzing();
//                analyzing.setCrawlUrl(href);
                analyzing.setStatus(getType(href));
                analyzing.setCrawlTime(new Date());
                map.put(urlList,analyzing);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }



    public Map<URL,Analyzing> getTask(Map<URL, Analyzing> pages) {
        Set<URL> urls = pages.keySet();
        for (URL url : urls) {
            String s = url.toString();
            if(s.indexOf("http") != s.lastIndexOf("http")){
                s = s.substring(s.lastIndexOf("http"));
            }
            try {
                Document document = Jsoup.connect(s).userAgent(userAgent).get();
                String html = document.select("div[class=main]").html();
                pages.get(url).setContent(html);
                pages.get(url).setCrawlUrl(s);
            } catch (IOException e) {
                Document document = null;
                try {
                    document = Jsoup.connect(s).userAgent(userAgent).get();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                String html = document.select("div[class=main]").html();
                pages.get(url).setContent(html);
                pages.get(url).setCrawlUrl(s);
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
