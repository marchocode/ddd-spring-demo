package xyz.chaobei.demo.infrastructure.repository;

import org.springframework.stereotype.Service;
import xyz.chaobei.demo.domain.repository.IUserRepository;
import xyz.chaobei.demo.infrastructure.po.UserEntity;

import javax.annotation.Resource;
import java.util.Objects;

@Service("userRepository")
public class UserRepository implements IUserRepository {

    @Resource(name = "userMysqlRepository")
    private IUserRepository userMysqlRepository;

    @Resource(name = "userRedisRepository")
    private IUserRepository userRedisRepository;

    @Override
    public UserEntity queryById(Long id) {

        // 查询缓存
        UserEntity cache = userRedisRepository.queryById(id);
        if (Objects.nonNull(cache)) {
            return cache;
        }

        // 查询数据库
        UserEntity entity = userMysqlRepository.queryById(id);

        return entity;
    }

    @Override
    public void save(UserEntity entity) {
        userMysqlRepository.save(entity);
        userRedisRepository.save(entity);
    }
}
