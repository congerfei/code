package com.xl.admin.consumer.service.impl;

import com.xl.admin.consumer.entity.TUser;
import com.xl.admin.consumer.mapper.TUserMapper;
import com.xl.admin.consumer.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xl
 * @since 2021-05-02
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
