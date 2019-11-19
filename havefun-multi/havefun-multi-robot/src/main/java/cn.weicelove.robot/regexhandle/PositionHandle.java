package cn.weicelove.robot.regexhandle;

import cn.weicelove.robot.constants.ChineseChessEnum;
import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;
import cn.weicelove.robot.operation.CannonOperation;
import cn.weicelove.robot.operation.ElephantOperation;
import cn.weicelove.robot.operation.KingOperation;
import cn.weicelove.robot.operation.KnightOperation;
import cn.weicelove.robot.operation.MandarinOperation;
import cn.weicelove.robot.operation.Operation;
import cn.weicelove.robot.operation.PawnOperation;
import cn.weicelove.robot.operation.RookOperation;

/**
 * @author QIU PANWEI Create in 2019/11/18 14:45
 */
public abstract class PositionHandle {

    /**
     * 上面是红色，下面是黑色
     */
    public abstract Position getPosition(String operate, Board board);

    public abstract Operation getOperation(String operate, Board board);

    Operation getOperationByHead(String head, boolean beBlack, Board board) {
        switch (head) {
            case "軳":
            case "炮":
                return new CannonOperation(!beBlack, board);
            case "象":
            case "相":
                return new ElephantOperation(!beBlack, board);
            case "将":
            case "帅":
                return new KingOperation(!beBlack, board);
            case "仕":
            case "士":
                return new MandarinOperation(!beBlack, board);
            case "兵":
            case "卒":
                return new PawnOperation(!beBlack, board);
            case "车":
            case "車":
                return new RookOperation(!beBlack, board);
            case "馬":
            case "马":
                return new KnightOperation(!beBlack, board);
        }
        return null;
    }

    Position surePosition(boolean beBlack, Integer number,Integer column, Board board, Integer code) {
        int  cnt = 1;
        int preRow = 1;
        if (beBlack) {
            column = 9 - column + 1;
            for(int i = 1; i <= 10 ; i ++) {
                if (board.getBoard()[column][i] == code) {
                    if (number == cnt) {
                        if (number == 1) {
                            preRow = 10 - i + 1;
                        }
                        return new Position(column, 10 - preRow + 1);
                    }
                    preRow = i;
                    cnt ++;
                }
            }
            if (number == -1) {
                return new Position(column, 10 - preRow + 1);
            }
        } else {
            for(int i = 10; i >= 1 ; i --) {
                if (board.getBoard()[column][i] == code) {
                    if (number == cnt) {
                        return new Position(column, i);
                    }
                    preRow = i;
                    cnt ++;
                }
            }
            if (number == -1) {
                return new Position(column, preRow);
            }
        }
        return null;
    }
}
