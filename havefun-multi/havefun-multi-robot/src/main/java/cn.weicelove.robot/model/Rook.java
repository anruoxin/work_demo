package cn.weicelove.robot.model;

import cn.weicelove.robot.entity.Position;
import cn.weicelove.robot.operation.Operation;

/**
 * @author QIU PANWEI Create in 2019/10/16 16:16
 */
public abstract class Rook {

    private boolean beBlack;

    private Position pos;

    private Operation operation;

    public Rook(boolean beBlack, Position pos, Operation operation) {
        this.beBlack = beBlack;
        this.pos = pos;
        this.operation = operation;
    }
}
