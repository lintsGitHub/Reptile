package priv.lint.Reptile;

import priv.lint.Reptile.DAO.C3P0Dao;
import priv.lint.Reptile.Entity.Analyzing;
import priv.lint.Reptile.Entity.Policy;
import priv.lint.Reptile.Reptiles.ZhuHaiAnalyzingReptile;
import priv.lint.Reptile.Reptiles.ZhuHaiGovernmentReptile;

import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        List<URL> list = new ArrayList();

        ZhuHaiGovernmentReptile zhuHaiGovernmentReptile = new ZhuHaiGovernmentReptile();
//        list.add(new URL("http://www.zhuhai.gov.cn/zw/fggw_44493/zfgz_44495/index.html"));
//        for (int i = 1; i < 11; i++) {
//            list.add(new URL("http://www.zhuhai.gov.cn/zw/fggw_44493/zfgz_44495/index_"+i+".html"));
//        }
//        for (URL url : list) {
//            List<URL> pageList = zhuHaiGovernmentReptile.getPageList(url);
//            zhuHaiGovernmentReptile.getTask(pageList);
//        }

//        list.add(new URL("http://www.zhuhai.gov.cn/zw/fggw_44493/zfgz_44495/index.html"));
//        for (int i = 1; i < 11; i++) {
//            list.add(new URL("http://www.zhuhai.gov.cn/zw/fggw_44493/zfgz_44495/index_" + i + ".html"));
//        }
//        Map<URL,Policy> map = new HashMap<>();
//        for (URL url : list) {
//            Map<URL,Policy> pageList = zhuHaiGovernmentReptile.getPageList(url);
//            Map<URL, Policy> task = zhuHaiGovernmentReptile.getTask(pageList);
//            map.putAll(task);
//        }

//        Collection<Policy> values = map.values();
//        System.out.println(values.size());
//        for (Policy value : values) {
//            try {
//                C3P0Dao.insertPolicy(value);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        ZhuHaiAnalyzingReptile zhuHaiAnalyzingReptile = new ZhuHaiAnalyzingReptile();
        list.add(new URL("http://www.zhuhai.gov.cn/zw/fggw_44493/zcjd_44498/index.html"));
        for (int i = 1; i < 26; i++) {
            list.add(new URL("http://www.zhuhai.gov.cn/zw/fggw_44493/zcjd_44498/index_" + i + ".html"));
        }
        Map<URL, Analyzing> map = new HashMap<>();
        for (URL url : list) {
            Map<URL,Analyzing> pageList = zhuHaiAnalyzingReptile.getPageList(url);
            Map<URL, Analyzing> task = zhuHaiAnalyzingReptile.getTask(pageList);
            map.putAll(task);
        }
        Collection<Analyzing> values = map.values();
//        System.out.println(values.size());
        for (Analyzing value : values) {
            try {
                C3P0Dao.insertAnalyzing(value);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
