package priv.lint.URLReptile;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
    
public class URLMain {
    public static void main(String[] args) throws IOException {
        String UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36";
        String urls = "http://www.zhsme.gov.cn/main/toMainIndex";
        URL url = new URL(urls);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent",UserAgent);
        urlConnection.connect();

        System.out.println(urlConnection.getHeaderFields());
    }
}
