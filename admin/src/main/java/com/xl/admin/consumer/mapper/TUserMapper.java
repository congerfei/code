package com.xl.admin.consumer.mapper;

import com.xl.admin.consumer.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xl
 * @since 2021-05-02
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

    public TUser selectUserAndInsByUserID(String lgcSn);


}
