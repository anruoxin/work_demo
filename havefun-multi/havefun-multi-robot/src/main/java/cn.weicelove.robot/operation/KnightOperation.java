package cn.weicelove.robot.operation;

import cn.weicelove.robot.constants.ChineseChessEnum.NumberEnum;
import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;
import cn.weicelove.robot.util.RegexUtil;
import org.apache.commons.lang.StringUtils;

/**
 * 马
 * @author QIU PANWEI Create in 2019/10/30 14:05
 */
public class KnightOperation extends Operation{

    public KnightOperation(boolean beRed, Board board) {
        super(beRed, board);
    }

    @Override
    public void Xaxis(Position pos, int step) {
        throw new UnsupportedOperationException("Knight can't do this");
    }

    @Override
    public void Yaxis(Position pos, int step) {
        throw new UnsupportedOperationException("Knight can't do this");
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
    public void dealChessOperate(String operateStr) {

        Position position = RegexUtil.dealOperate(operateStr, getChessBoard());
        if (position == null) {
            throw new NullPointerException("未在棋盘上找到该棋子");
        }
        String direction = StringUtils.substring(operateStr, -2, -1);
        Integer step = NumberEnum.of(StringUtils.substring(operateStr, -1)).getValue();
        switch (direction) {
            case "进":
                int xx;
                int yy;
                if (isBeRed()) {
                    if (position.getX() < step) {
                        if (step - 2 == position.getX()) {
                            xx = 2;
                            yy = 1;
                        } else {
                            xx = 1;
                            yy = 2;
                        }
                    } else {
                        if (step - 2 == position.getX()) {
                            xx = -2;
                            yy = 1;
                        } else {
                            xx = -1;
                            yy = 2;
                        }
                    }
                } else {
                    if (position.getX() < (9 - step + 1)) {
                        if ((9 - step + 1) - 2 == position.getX()) {
                            xx = 2;
                            yy = -1;
                        } else {
                            xx = 1;
                            yy = -2;
                        }
                    } else {
                        if ((9 - step + 1) - 2 == position.getX()) {
                            xx = -2;
                            yy = -1;
                        } else {
                            xx = -1;
                            yy = -2;
                        }
                    }
                }
                XYaxis(position, xx, yy);
                break;
            case "退":
                if (isBeRed()) {
                    if (position.getX() < step) {
                        if (step - 2 == position.getX()) {
                            xx = 2;
                            yy = -1;
                        } else {
                            xx = 1;
                            yy = -2;
                        }
                    } else {
                        if (step - 2 == position.getX()) {
                            xx = -2;
                            yy = -1;
                        } else {
                            xx = -1;
                            yy = -2;
                        }
                    }
                } else {
                    if (position.getX() < (9 - step + 1)) {
                        if ((9 - step + 1) - 2 == position.getX()) {
                            xx = 2;
                            yy = 1;
                        } else {
                            xx = 1;
                            yy = 2;
                        }
                    } else {
                        if ((9 - step + 1) - 2 == position.getX()) {
                            xx = -2;
                            yy = 1;
                        } else {
                            xx = -1;
                            yy = 2;
                        }
                    }
                }
                XYaxis(position, xx, yy);
                break;
        }

    }
}