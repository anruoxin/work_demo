package cn.weicelove.robot.controller;

import cn.weicelove.robot.constants.ChineseChessEnum;
import cn.weicelove.robot.constants.ChineseChessEnum.ChessEnum;
import cn.weicelove.robot.entity.ChineseChess;
import cn.weicelove.robot.exception.NotFindChessException;
import java.util.Arrays;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QIU PANWEI Create in 2019/10/16 15:12
 */
@RestController
@RequestMapping("/user")
public class HelloController {

    public static void main(String[] args) {
        String s = "车一平四";
        boolean black = isBlack(s);
    }

    public static boolean isBlack(String s) {
        for (int i = 0; i < ChineseChessEnum.getChess().length; i++) {
            if (s.contains(ChineseChessEnum.getChess()[i])){
                return ChessEnum.isBlack(ChineseChessEnum.getChess()[i]);
            }
        }
        throw new NotFindChessException("no find the chess " + s);
    }

    public static void getOperation(String operate) {

    }
}
