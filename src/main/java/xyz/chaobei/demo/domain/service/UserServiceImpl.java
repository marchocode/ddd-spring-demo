package xyz.chaobei.demo.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import xyz.chaobei.demo.domain.model.aggregates.UserCardBO;
import xyz.chaobei.demo.domain.model.vo.CardVO;
import xyz.chaobei.demo.domain.model.vo.UserVO;
import xyz.chaobei.demo.domain.repository.ICardRepository;
import xyz.chaobei.demo.domain.repository.IUserRepository;
import xyz.chaobei.demo.infrastructure.po.CardEntity;
import xyz.chaobei.demo.infrastructure.po.UserEntity;
import xyz.chaobei.demo.application.service.UserService;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userRepository")
    private IUserRepository userRepository;

    @Resource(name = "cardRepository")
    private ICardRepository cardRepository;

    @Override
    public UserCardBO queryUserCardById(Long id) {

        UserEntity user = userRepository.queryById(id);
        List<CardEntity> cards = cardRepository.listCardsByUserId(id);

        List<CardVO> cardVOS = new LinkedList<>();
        for (CardEntity item : cards) {

            CardVO cardVO = new CardVO();
            BeanUtils.copyProperties(item, cardVO);

            cardVOS.add(cardVO);
        }

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);

        UserCardBO result = new UserCardBO();
        result.setUser(userVO);
        result.setCard(cardVOS);

        return result;
    }
}
