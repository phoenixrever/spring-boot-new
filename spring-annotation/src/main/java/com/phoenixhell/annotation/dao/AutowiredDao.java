package com.phoenixhell.annotation.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * 注入的时候如果找到多个相同类型的组件，再将属性的名称(注入的时候指定的名字)作为组件的id去容器中查找
 */
@Data
@Repository
public class AutowiredDao {
  private String label="1";
}
