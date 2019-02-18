package priv.lint.Utils;


import java.net.URL;
import java.util.List;

public interface ReptileInterface {
    /*
    * @param: 目标网站URL
    * @describe: 设置目标网站的RUL，也可以通过构造函数进行赋值
    * @return: null
    * @author: 梁钧淋
    * @since: 1.0
    * */
    void setURL(String url);
    /*
     * @param:
     * @describe: 获取目标网站的政策列表页数
     * @return: 目标网站的政策列表页数
     * @author: 梁钧淋
     * @since: 1.0
     * */
    int getPageNumber();
    /*
     * @param: 目标网站URL
     * @describe: 获取目标网站的政策列表中的每条政策的URL
     * @return: 目标网站的政策的URL集合
     * @author: 梁钧淋
     * @since: 1.0
     * */
    List<URL> getTask(String url);
    /*
     * @param:
     * @describe: 爬虫具体方法
     * @return:
     * @author: 梁钧淋
     * @since: 1.0
     * */
    void graspData();
    /*
     * @param: 目标网站的政策URL集合
     * @describe: 爬虫具体实现
     * @return:
     * @author: 梁钧淋
     * @since: 1.0
     * */
    void graspData(List<URL> urls);
}
