package xyz.chaobei.demo.application.service;


import xyz.chaobei.demo.domain.model.aggregates.UserCardBO;

public interface UserService {

    UserCardBO queryUserCardById(Long id);
}
