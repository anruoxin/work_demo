package cn.weicelove.robot.operation;

import cn.weicelove.robot.constants.ChineseChessEnum.NumberEnum;
import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;
import cn.weicelove.robot.util.ChessUtil;
import cn.weicelove.robot.util.RegexUtil;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QIU PANWEI Create in 2019/10/15 11:23
 */
@Data
public abstract class Operation {

    private static Logger logger = LoggerFactory.getLogger(Operation.class);

    private boolean beRed;

    private Board chessBoard;

    public Operation(boolean beRed, Board chessBoard) {
        this.beRed = beRed;
        this.chessBoard = chessBoard;
    }

    /**
     * 车一平四
     * 前兵一平四
     * 前二兵进四
     * 后兵一平四
     * 马八进七
     * 炮
     */
    abstract void Xaxis(Position pos, int step);
    abstract void Yaxis(Position pos, int step);
    abstract void XYaxis(Position pos, int xstep, int ystep);
    void dealChessOperate(String operateStr){
        Position position = RegexUtil.dealOperate(operateStr, getChessBoard());
        if (position == null) {
            throw new NullPointerException("未在棋盘上找到该棋子");
        }
        String direction = StringUtils.substring(operateStr, -2, -1);
        Integer step = NumberEnum.of(StringUtils.substring(operateStr, -1)).getValue();
        switch (direction) {
            case "进":
                Xaxis(position, isBeRed() ? step : -step);
                break;
            case "退":
                Xaxis(position, isBeRed() ? -step : step);
                break;
            case "平":
                Yaxis(position, isBeRed() ?  step - position.getX() : (9 - step + 1) - position.getX());
                break;
        }
    }

    /**
     * 检查棋子是否越界
     *  true： 越界
     *  false： 没有越界
     * @param pos 棋子位置
     * @return boolean
     * @author QIU PANWEI
     */
    boolean beOutOfBoundary(Position pos) {
        if (pos == null) {
            return true;
        }
        return pos.getX() < 1 || pos.getX() > 10 || pos.getY() < 1 || pos.getY() > 11;
    }

    /**
     *
     * 改变棋子位置
     * @param
     * @author QIU PANWEI
     */
    void changePos(Position oldPosition, Position newPosition) {
        try {
            chessBoard.getBoard()[newPosition.getX()][newPosition.getY()] = chessBoard.getBoard()[oldPosition.getX()][oldPosition.getY()];
            chessBoard.getBoard()[oldPosition.getX()][oldPosition.getY()] = 0;
            ChessUtil.printBoard();
        }catch (Exception e) {
            logger.error(String.format("棋子移动失败！oldPos(%d, %d) : newPos(%d, %d)",
                    oldPosition.getX(), oldPosition.getY(), newPosition.getX(), newPosition.getY()), e);
        }
    }

}
