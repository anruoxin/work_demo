package cn.weicelove.robot.operation;

import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;

/**
 * 帅
 * @author QIU PANWEI Create in 2019/10/30 14:38
 */
public class KingOperation extends Operation {

    public KingOperation(boolean beRed, Board board) {
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
        throw new UnsupportedOperationException("King can't do this");
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

}
