package com.xl.admin.role.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xl
 * @since 2021-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("CFG_T_RL_INF")
public class CfgTRlInf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId("RL_ID")
    private String rlId;

    /**
     * 角色名
     */
    @TableField("RL_NM")
    private String rlNm;

    /**
     * 角色描述
     */
    @TableField("RL_DSC")
    private String rlDsc;

    /**
     * 最后更新时间
     */
    @TableField("LAST_UDT_DT")
    private LocalDateTime lastUdtDt;

    /**
     * 省
     */
    @TableField("PROV_CD")
    private String provCd;

    /**
     * 市
     */
    @TableField("CITY_CD")
    private String cityCd;

    /**
     * 区
     */
    @TableField("ZON_CD")
    private String zonCd;

    /**
     * 镇
     */
    @TableField("STR_CD")
    private String strCd;

    /**
     * 角色层级
     */
    @TableField("RL_LV")
    private String rlLv;

    /**
     * 最后操作人
     */
    @TableField("LAST_OPT_USR")
    private String lastOptUsr;

    /**
     * 角色激活状态0注销，1正常
     */
    @TableField("RL_STATUS")
    private String rlStatus;


}
