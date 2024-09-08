package com.xlf.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.xlf.common.pojo.mode.BaseEntity;
import lombok.Data;

/**
 *
 * @TableName sell_comment
 */
@TableName(value ="sell_comment")
@Data
public class SellComment extends BaseEntity implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 回复的人
     */
    private Long userId;

    /**
     * 讨论Id
     */
    private Long sellId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 被回复的人
     */
    private Long parentId;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private String createBy;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    private String updateBy;

    /**
     *
     */
    private String remark;

    /**
     *
     */
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
