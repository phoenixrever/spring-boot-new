package com.phoenixhell.annotation.tx;

import com.phoenixhell.annotation.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 *
 */

@RestController
public class TxController {
    @Autowired
    private UserService userService;

    @GetMapping("/tx")
    public List<UserEntity> tx(){
        List<UserEntity> list = userService.list();
        return list;
    }

    @Transactional
    @GetMapping("/insert")
    public List<UserEntity> insert(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("测试事务-"+ UUID.randomUUID().toString().substring(0,6));
        userEntity.setPassword("测试事务");
        userService.save(userEntity);
        List<UserEntity> list = userService.list();
        int x=1/0;
        return list;
    }

}
