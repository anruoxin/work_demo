package cn.weicelove.robot.operation;

import cn.weicelove.robot.constants.ChineseChessEnum.NumberEnum;
import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;
import cn.weicelove.robot.util.OperationDealUtil;
import org.apache.commons.lang.StringUtils;

/**
 * 象
 * @author QIU PANWEI Create in 2019/10/30 14:35
 */
public class ElephantOperation extends Operation {

    public ElephantOperation(boolean beRed, Board board) {
        super(beRed, board);
    }

    @Override
    public void Xaxis(Position pos, int step) {
        throw new UnsupportedOperationException("Elephant can't do this");
    }

    @Override
    public void Yaxis(Position pos, int step) {
        throw new UnsupportedOperationException("Elephant can't do this");
    }

    @Override
    public void XYaxis(Position pos, int xstep, int ystep) {
        Position newPosition = new Position();
        newPosition.setX(pos.getX() + xstep);
        newPosition.setY(pos.getY() + ystep);
        if(!beOutOfBoundary(newPosition)) {
            changePos(pos, newPosition);
        }
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
                int xx;
                if (isBeRed()) {
                    if (position.getX() < step) {
                        xx = 2;
                    } else {
                        xx = -2;
                    }
                } else {
                    if (position.getX() < (9 - step + 1)) {
                        xx = 2;
                    } else {
                        xx = -2;
                    }
                }
                XYaxis(position, xx, isBeRed() ? 2 : -2);
                break;
            case "退":
                if (isBeRed()) {
                    if (position.getX() < step) {
                        xx = 2;
                    } else {
                        xx = -2;
                    }
                } else {
                    if (position.getX() < (9 - step + 1)) {
                        xx = 2;
                    } else {
                        xx = -2;
                    }
                }
                XYaxis(position, xx, isBeRed() ? -2 : 2);
                break;
        }
    }
}
