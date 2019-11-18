package cn.weicelove.robot.regexhandle;

import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;

/**
 * @author QIU PANWEI Create in 2019/11/18 14:45
 */
public abstract class PositionHandle {

    /**
     * 上面是红色，下面是黑色
     */
    public abstract Position getPosition(String operate, Board board);

    Position surePosition(boolean beBlack, Integer number,Integer column, Board board, Integer code) {
        column = beBlack ? 9 - column + 1 : column;

        int  cnt = 1;
        int preRow = -1;
        if (beBlack) {
            column = 9 - column + 1;
            for(int i = 1; i <= 10 ; i ++) {
                if (board.getBoard()[column][i] == code) {
                    if (number == cnt) {
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
