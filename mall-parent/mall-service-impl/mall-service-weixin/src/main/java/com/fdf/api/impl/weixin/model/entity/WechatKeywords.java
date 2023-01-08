package com.fdf.api.impl.weixin.model.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 公众号消息自定义回复模版
 *
 * @author fandongfeng
 * @date 2023/1/8 13:40
 */
@Data
@TableName("wechat_keywords")
public class WechatKeywords extends Model<WechatKeywords> {

    private Long id;
    private String keywordName;
    private String keywordValue;
    private Date createTime;
    private Date updateTime;
    private Long version;
    @TableLogic
    private int isDelete;

}
