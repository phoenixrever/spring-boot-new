package com.phoenixhell.annotation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @since 2022/1/15 0015-上午 8:53
 */
@Data
@TableName("users")
public class UserEntity {
    //一定要有这个注解 不然argument type mismatch
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
}
