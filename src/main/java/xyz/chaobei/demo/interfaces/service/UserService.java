package xyz.chaobei.demo.interfaces.service;


import xyz.chaobei.demo.domain.model.aggregates.UserCardBO;

public interface UserService {

    UserCardBO queryUserCardById(Long id);
}
