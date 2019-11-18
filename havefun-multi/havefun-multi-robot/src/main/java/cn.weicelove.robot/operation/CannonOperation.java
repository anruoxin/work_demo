package cn.weicelove.robot.operation;

import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;

/**
 * 炮
 * @author QIU PANWEI Create in 2019/10/16 11:33
 */
public class CannonOperation extends Operation {

    public CannonOperation(boolean beRed, Board board) {
        super(beRed, board);
    }

    @Override
    public void Xaxis(Position pos, int step) {
        Position newPosition = new Position();
        newPosition.setX(pos.getX() + step);
        newPosition.setY(pos.getY());
        if (!beOutOfBoundary(newPosition)) {
            changePos(pos, newPosition);
        }

    }

    @Override
    public void Yaxis(Position pos, int step) {
        Position newPosition = new Position();
        newPosition.setX(pos.getX());
        newPosition.setY(pos.getY() + step);
        if (!beOutOfBoundary(newPosition)) {
            changePos(pos, newPosition);
        }
    }

    @Override
    public void XYaxis(Position pos, int xstep, int ystep) {
        throw new UnsupportedOperationException("Cannon can't do this");
    }

}
