package xyz.chaobei.demo.infrastructure.repository.mysql;

import org.springframework.stereotype.Service;
import xyz.chaobei.demo.domain.repository.ICardRepository;
import xyz.chaobei.demo.infrastructure.dao.CardDao;
import xyz.chaobei.demo.infrastructure.po.CardEntity;

import javax.annotation.Resource;
import java.util.List;

@Service("cardMysqlRepository")
public class CardMysqlRepository implements ICardRepository {

    @Resource
    private CardDao cardDao;

    @Override
    public List<CardEntity> listCardsByUserId(Long userId) {
        return cardDao.listCardsByUserId(userId);
    }
}
