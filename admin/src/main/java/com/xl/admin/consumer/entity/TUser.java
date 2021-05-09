package com.xl.admin.consumer.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author xl
 * @since 2021-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("T_USER")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("LGC_SN")
    private String lgcSn;

    /**
     * 手机号
     */
    @TableField("USER_ID")
    private String userId;

    /**
     * 名称
     */
    @TableField("USER_NAME")
    private String name;

    /**
     * 创建时间
     */
    @TableField("CREATE_DT")
    private Date createDt;

    /**
     * 更新时间
     */
    @TableField("UPDATE_DT")
    private Date updateDt;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * json
     */
    @TableField("REMAKE")
    private String remake;

    /**
     * 逻辑删除，数据状态
     */
    //@TableLogic  去掉逻辑删除
    @TableField("DELETED")
    private Integer deleted;


}
