package xyz.chaobei.demo.infrastructure.repository.mysql;

import org.springframework.stereotype.Service;
import xyz.chaobei.demo.domain.repository.IUserRepository;
import xyz.chaobei.demo.infrastructure.dao.UserDao;
import xyz.chaobei.demo.infrastructure.po.UserEntity;

import javax.annotation.Resource;

@Service("userMysqlRepository")
public class UserMysqlRepository implements IUserRepository {

    @Resource
    private UserDao userDao;

    @Override
    public UserEntity queryById(Long id) {
        return userDao.queryById(id);
    }

    @Override
    public void save(UserEntity entity) {
        userDao.save(entity);
    }
}
