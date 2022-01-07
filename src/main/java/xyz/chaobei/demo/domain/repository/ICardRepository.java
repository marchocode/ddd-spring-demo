package xyz.chaobei.demo.domain.repository;

import xyz.chaobei.demo.infrastructure.po.CardEntity;

import java.util.List;

public interface ICardRepository {

    List<CardEntity> listCardsByUserId(Long userId);
}
