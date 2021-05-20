package com.xl.provider.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName(value = "TUSER")//这里踩坑，不要用USER作为表名，不然报无效的表名
public class User {
    private String lgcSn;
    private String userId;
    private String userNm;

}
