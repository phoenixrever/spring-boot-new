package com.phoenixhell.annotation.tx;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.phoenixhell.annotation.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
