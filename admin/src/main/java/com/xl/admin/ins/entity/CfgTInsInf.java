package com.xl.admin.ins.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("CFG_T_INS_INF")
public class CfgTInsInf implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("INS_ID")
    private String insId;

    @TableField("PROV_CD")
    private String provCd;

    @TableField("CITY_CD")
    private String cityCd;

    @TableField("ZON_CD")
    private String zonCd;

    @TableField("STR_CD")
    private String strCd;

    @TableField("INS_NM")
    private String insNm;

    @TableField("INS_ADDR")
    private String insAddr;

    @TableField("INS_TYPE")
    private BigDecimal insType;


}
