package cn.weicelove.robot.regexhandle;

import cn.weicelove.robot.constants.ChineseChessEnum.ChessEnum;
import cn.weicelove.robot.constants.ChineseChessEnum.NumberEnum;
import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;
import cn.weicelove.robot.operation.Operation;
import org.apache.commons.lang.StringUtils;

/**
 * @author QIU PANWEI Create in 2019/11/18 14:57
 */
public class FiveLengthHandle extends PositionHandle {

    @Override
    public Position getPosition(String operate, Board board) {

        String head = operate.substring(1, 2);
        Integer code = ChessEnum.getCode(head);
        boolean beBlack = ChessEnum.isBlack(code);
        Integer column = NumberEnum.of(StringUtils.substring(operate, -3, -2)).getValue();
        String number = operate.substring(0, 1);
        switch (number) {
            case "前": return surePosition(beBlack, 1, column, board, code);
            case "中": return surePosition(beBlack, 2, column, board, code);
            case "后": return surePosition(beBlack, -1, column, board, code);
        }
        return null;
    }

    @Override
    public Operation getOperation(String operate, Board board) {
        String head = operate.substring(1, 2);
        Integer code = ChessEnum.getCode(head);
        boolean beBlack = ChessEnum.isBlack(code);
        return getOperationByHead(head,  beBlack, board);
    }
}
