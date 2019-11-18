package cn.weicelove.robot.operation;

import cn.weicelove.robot.constants.ChineseChessEnum.NumberEnum;
import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;
import cn.weicelove.robot.util.RegexUtil;
import org.apache.commons.lang.StringUtils;

/**
 * 士
 * @author QIU PANWEI Create in 2019/10/30 14:38
 */
public class MandarinOperation extends Operation {

    public MandarinOperation(boolean beRed, Board board) {
        super(beRed, board);
    }

    @Override
    public void Xaxis(Position pos, int step) {
        throw new UnsupportedOperationException("Mandarin can't do this");
    }

    @Override
    public void Yaxis(Position pos, int step) {
        throw new UnsupportedOperationException("Mandarin can't do this");
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
    public boolean beOutOfBoundary(Position pos) {
        boolean flag = true;
        if (pos.getX() >=5 && pos.getX() <= 7 &&
                (pos.getY() >=1 && pos.getY() <= 3 || pos.getY() <=10 && pos.getY() <= 7)) {
            flag = false;
        }
        return super.beOutOfBoundary(pos) || flag;
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
                if (isBeRed()) {
                    if (position.getX() < step) {
                        xx = 1;
                    } else {
                        xx = -1;
                    }
                } else {
                    if (position.getX() < (9 - step + 1)) {
                        xx = 1;
                    } else {
                        xx = -1;
                    }
                }
                XYaxis(position, xx, isBeRed() ? 1 : -1);
                break;
            case "退":
                if (isBeRed()) {
                    if (position.getX() < step) {
                        xx = 1;
                    } else {
                        xx = -1;
                    }
                } else {
                    if (position.getX() < (9 - step + 1)) {
                        xx = 1;
                    } else {
                        xx = -1;
                    }
                }
                XYaxis(position, xx, isBeRed() ? -1 : 1);
                break;
        }
    }
}
