package cn.weicelove.robot.operation;

import cn.weicelove.robot.constants.ChineseChessEnum.NumberEnum;
import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;
import cn.weicelove.robot.util.OperationDealUtil;
import org.apache.commons.lang.StringUtils;

/**
 * 兵
 * @author QIU PANWEI Create in 2019/10/16 11:33
 */
public class PawnOperation extends Operation {

    public PawnOperation(boolean beRed, Board board) {
        super(beRed, board);
    }

    @Override
    public void Xaxis(Position pos, int step) {

        Position newPosition = new Position();
        newPosition.setX(pos.getX() + step);
        newPosition.setY(pos.getY());
        if(!beOutOfBoundary(newPosition)) {
           changePos(pos, newPosition);
        }

    }

    @Override
    public void Yaxis(Position pos, int step) {
        Position newPosition = new Position();
        newPosition.setX(pos.getX());
        newPosition.setY(pos.getY() + step);
        if(!beOutOfBoundary(newPosition)) {
            changePos(pos, newPosition);
        }
    }

    @Override
    public void XYaxis(Position pos, int xstep, int ystep) {
        throw new UnsupportedOperationException("Pwan can't do this");
    }

    @Override
    public void dealChessOperate(Position position, String operateStr) {
        if (position == null) {
            throw new NullPointerException("未在棋盘上找到该棋子");
        }
        String direction = StringUtils.substring(operateStr, -2, -1);
        Integer step = NumberEnum.of(StringUtils.substring(operateStr, -1)).getValue();
        switch (direction) {
            case "进":
                Yaxis(position, isBeRed() ? step : -step);
                break;
            case "平":
                Xaxis(position, isBeRed() ?  step - position.getX() : (9 - step + 1) - position.getX());
                break;
        }

    }
}
