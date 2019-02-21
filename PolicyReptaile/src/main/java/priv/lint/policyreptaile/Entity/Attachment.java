package priv.lint.policyreptaile.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/*
* 政策附件表
* */
@Entity
@Getter
@Setter
public class Attachment {

    private Integer id;       //  '编号',
    private Integer policyId;       //  '政策表编号',
    private String name;       //  '名称',
    private String createdTime;       //  '创建时间',
    private String updatedTime;       //  '更新时间',
    private String crawlUrl;       //  '抓取路径',
    private String localPath;       //  '本地路径',
    private String description;       //  '描述',
    private String type;       //  '类型（word,excel）',
    private String fileSize;       //  '文件大小（KB）',
    private String downloadTimes;      //  '下载数'
}
