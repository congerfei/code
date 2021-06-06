package com.xl.admin.aop;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 变更记录
 */
@Accessors
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UnityLog {
        /**
         * id
         */
        private Long id;

        /**
         * 数据库表名
         */
        private String unityTag;

        /**
         * 数据库表记录id对应的操作日志
         */
        private Long unityTagId;

        /**
         * 操作人
         */
        private String unityOperator;

        /**
         * 操作时间
         */
        private Date unityOperateTime;

        /**
         * 操作类型，新增，删除，修改，查询
         */
        private String unityOperate;

        /**
         * 操作事项,操作了哪些字段   "unityMatter":"[姓名][年龄][性别]",
         */
        private String unityMatter;

        /**
         * 操作内容，具体的内容变更   "unityContent":"[张三->李四][21->24][true->false]"
         */
        private String unityContent;


}
