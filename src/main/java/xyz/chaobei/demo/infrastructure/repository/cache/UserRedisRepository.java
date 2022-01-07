package xyz.chaobei.demo.infrastructure.repository.cache;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import xyz.chaobei.demo.domain.repository.IUserRepository;
import xyz.chaobei.demo.infrastructure.po.UserEntity;

import javax.annotation.Resource;

@Service("userRedisRepository")
public class UserRedisRepository implements IUserRepository {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    private final String key = "userRedisRepository:user";

    @Override
    public UserEntity queryById(Long id) {
        return JSON.parseObject(stringRedisTemplate.opsForValue().get(key), UserEntity.class);
    }

    @Override
    public void save(UserEntity entity) {
        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(entity));
    }
}
