package xyz.chaobei.demo.domain.model.aggregates;

import xyz.chaobei.demo.domain.model.vo.CardVO;
import xyz.chaobei.demo.domain.model.vo.UserVO;

import java.util.List;

public class UserCardBO {

    private List<CardVO> card;

    private UserVO user;

    public List<CardVO> getCard() {
        return card;
    }

    public void setCard(List<CardVO> card) {
        this.card = card;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }
}
