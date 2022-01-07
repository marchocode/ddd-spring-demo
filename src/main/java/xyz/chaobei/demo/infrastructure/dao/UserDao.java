package xyz.chaobei.demo.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.chaobei.demo.infrastructure.po.UserEntity;

@Mapper
public interface UserDao {

    int save(UserEntity record);

    UserEntity queryById(Long id);
}