package cn.weicelove.robot.regexhandle;

import cn.weicelove.robot.constants.ChineseChessEnum.ChessEnum;
import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;
import org.apache.commons.lang.StringUtils;

/**
 * @author QIU PANWEI Create in 2019/11/18 14:57
 */
public class FourLengthHandle extends PositionHandle {

    @Override
    public Position getPosition(String operate, Board board) {
        String head = operate.substring(0, 1);
        Integer code = ChessEnum.getCode(head);
        boolean beBlack = ChessEnum.isBlack(code);
        Integer column = Integer.valueOf(StringUtils.substring(operate, -3, -2));
        return surePosition(beBlack, 1, column, board, code);
    }


}
