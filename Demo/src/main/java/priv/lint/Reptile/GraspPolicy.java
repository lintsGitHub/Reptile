package priv.lint.Reptile;

import java.net.URL;
import java.util.List;

public interface GraspPolicy {
    /*
     * @param: 目标网站
     * @describe: 获取目标网站的政策列表页面集
     * @return: 目标网站的政策列表页面集
     * @author: 韦凇耀
     * @since: 1.0
     * */
    List<URL> getPageList(URL url);

    /*
     * @param: 政策列表页面集
     * @describe: 获取政策URL集
     * @return: 政策URL集
     * @author: 韦凇耀
     * @since: 1.0
     * */
    List<URL> getTask(List<URL> pages);

    /*
     * @param: tClass：政策实体类型；policies：政策URL集
     * @describe: 处理政策
     * @return: 政策集合
     * @author: 韦凇耀
     * @since: 1.0
     * */
    <T> List<T> handleTask(Class<T> tClass, List<URL> tasks);
}
