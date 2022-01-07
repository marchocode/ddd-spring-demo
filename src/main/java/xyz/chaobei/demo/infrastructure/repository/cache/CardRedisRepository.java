package xyz.chaobei.demo.infrastructure.repository.cache;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import xyz.chaobei.demo.domain.repository.ICardRepository;
import xyz.chaobei.demo.infrastructure.po.CardEntity;

import java.util.List;

@Service("cardRedisRepository")
public class CardRedisRepository implements ICardRepository {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private final String key = "cardRedisRepository:card";

    @Override
    public List<CardEntity> listCardsByUserId(Long userId) {
        return JSON.parseArray(redisTemplate.opsForValue().get(key), CardEntity.class);
    }
}
