package cn.weicelove.robot.regexhandle;

import cn.weicelove.robot.constants.ChineseChessEnum.ChessEnum;
import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;
import org.apache.commons.lang.StringUtils;

/**
 * @author QIU PANWEI Create in 2019/11/18 14:58
 */
public class SixLengthHandle extends PositionHandle {

    @Override
    public Position getPosition(String operate, Board board) {
        String head = operate.substring(2, 3);
        Integer code = ChessEnum.getCode(head);
        boolean beBlack = ChessEnum.isBlack(code);
        Integer column = Integer.valueOf(StringUtils.substring(operate, -3, -2));
        switch (operate.substring(1,2)) {
            case "一": surePosition(beBlack, 1, column, board, code);
            case "二": surePosition(beBlack, 2, column, board, code);
            case "三": surePosition(beBlack, 3, column, board, code);
            case "四": surePosition(beBlack, 4, column, board, code);
        }
        return null;
    }
}
