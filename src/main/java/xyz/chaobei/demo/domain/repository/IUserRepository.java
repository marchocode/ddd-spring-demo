package xyz.chaobei.demo.domain.repository;

import xyz.chaobei.demo.infrastructure.po.UserEntity;

public interface IUserRepository {

    UserEntity queryById(Long id);

    void save(UserEntity entity);
}
