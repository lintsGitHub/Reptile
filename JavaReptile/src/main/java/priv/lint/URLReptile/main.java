package priv.lint.URLReptile;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class main {
    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("http://www.aa248.com/yckix-12.html").userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36").get();
            System.out.println(document.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
