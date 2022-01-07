package xyz.chaobei.demo.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.chaobei.demo.infrastructure.po.CardEntity;

import java.util.List;

@Mapper
public interface CardDao {

    int insert(CardEntity record);

    List<CardEntity> listCardsByUserId(Long id);
}