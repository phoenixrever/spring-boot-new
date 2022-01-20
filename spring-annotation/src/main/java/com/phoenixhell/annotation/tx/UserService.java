package com.phoenixhell.annotation.tx;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phoenixhell.annotation.entity.UserEntity;
import org.springframework.stereotype.Service;

/**
 * @author phoenixhell
 * @since 2022/1/20 0020-上午 10:33
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {
}
