package priv.lint.policyreptaile.Entity;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
//原始政策
public class PolicyRaw {
    private Integer id;                //   '编号',
    private String crawlUrl;         //   '抓取路径',
    private Date crawlTime;        //   '抓取的时间',
    private String indexNumber;      //   '索引号',
    private String title;             //   '标题',
    private String releaseOffice;    //   '发文机关',
    private String releaseNumber;    //   '发文文号',
    private String policyBasis;      //   '依据',
    private Date wirittenTime;     //   '成文日期',
    private Date releaseTime;      //   '发布日期',
    private Date effectTime;       //   '有效日期',
    private String content;           //   '正文',
    private String imageUrl;         //   '图片路径',
    private String status;            //   '状态（是否处理)',
    private String html;              //   '抓取的HTML源页面',
    private String remark;            //   '备注，比如这条数据是本地上传的'
    private List<Attachment> attachmentList;    //附件
    private List<AnalyzingRaw> analyzingRawList; //解读

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrawlUrl() {
        return crawlUrl;
    }

    public void setCrawlUrl(String crawlUrl) {
        this.crawlUrl = crawlUrl;
    }

    public Date getCrawlTime() {
        return crawlTime;
    }

    public void setCrawlTime(Date crawlTime) {
        this.crawlTime = crawlTime;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseOffice() {
        return releaseOffice;
    }

    public void setReleaseOffice(String releaseOffice) {
        this.releaseOffice = releaseOffice;
    }

    public String getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(String releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    public String getPolicyBasis() {
        return policyBasis;
    }

    public void setPolicyBasis(String policyBasis) {
        this.policyBasis = policyBasis;
    }

    public Date getWirittenTime() {
        return wirittenTime;
    }

    public void setWirittenTime(Date wirittenTime) {
        this.wirittenTime = wirittenTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public List<AnalyzingRaw> getAnalyzingRawList() {
        return analyzingRawList;
    }

    public void setAnalyzingRawList(List<AnalyzingRaw> analyzingRawList) {
        this.analyzingRawList = analyzingRawList;
    }

    @Override
    public String toString() {
        return "PolicyRaw{" +
                "id=" + id +
                ", crawlUrl='" + crawlUrl + '\'' +
                ", crawlTime=" + crawlTime +
                ", indexNumber='" + indexNumber + '\'' +
                ", title='" + title + '\'' +
                ", releaseOffice='" + releaseOffice + '\'' +
                ", releaseNumber='" + releaseNumber + '\'' +
                ", policyBasis='" + policyBasis + '\'' +
                ", wirittenTime=" + wirittenTime +
                ", releaseTime=" + releaseTime +
                ", effectTime=" + effectTime +
                ", content='" + content + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", status='" + status + '\'' +
                ", html='" + html + '\'' +
                ", remark='" + remark + '\'' +
                ", attachmentList=" + attachmentList +
                ", analyzingRawList=" + analyzingRawList +
                '}';
    }
}
