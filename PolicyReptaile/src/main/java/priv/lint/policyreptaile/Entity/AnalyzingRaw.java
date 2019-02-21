package priv.lint.policyreptaile.Entity;

import javax.persistence.Entity;
import java.util.Date;

/*原始解读表*/
@Entity
public class AnalyzingRaw {
    private Integer id;                 //       '编号',
    private Integer policyRawId;      //       '临时政策表id',
    private String crawlUrl;          //       '抓取的路径',			-- 建议加crawl
    private String localPath;         //       '本地路径',
    private String content;            //       '内容',
    private Date crawlTime;         //       '抓取时间',
    private String status;             //       '状态'
}
