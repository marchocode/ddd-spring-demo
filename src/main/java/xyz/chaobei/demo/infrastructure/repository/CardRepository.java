package xyz.chaobei.demo.infrastructure.repository;

import org.springframework.stereotype.Service;
import xyz.chaobei.demo.domain.repository.ICardRepository;
import xyz.chaobei.demo.infrastructure.po.CardEntity;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service("cardRepository")
public class CardRepository implements ICardRepository {

    @Resource(name = "cardRedisRepository")
    private ICardRepository cardRedisRepository;

    @Resource(name = "cardMysqlRepository")
    private ICardRepository cardMysqlRepository;

    @Override
    public List<CardEntity> listCardsByUserId(Long userId) {

        List<CardEntity> result = cardRedisRepository.listCardsByUserId(userId);

        if (Objects.nonNull(result)) {
            return result;
        }

        return cardMysqlRepository.listCardsByUserId(userId);
    }
}
