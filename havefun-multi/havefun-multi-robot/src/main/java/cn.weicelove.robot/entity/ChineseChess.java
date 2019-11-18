package cn.weicelove.robot.entity;

import java.io.Serializable;
import javafx.util.Pair;
import lombok.Data;

/**
 * @author QIU PANWEI Create in 2019/9/29 14:07
 */
@Data
public abstract class ChineseChess implements Serializable {

    private static final long serialVersionUID = -6361139210722307376L;

    /**
     * 车
     */
    protected Pair<Integer, Position> RookLeft;

    protected Pair<Integer, Position> RookRight;

    /**
     * 马
     */
    protected Pair<Integer, Position> KnightLeft;

    protected Pair<Integer, Position> KnightRight;

    /**
     * 象
     */
    protected Pair<Integer, Position> ElephantLeft;

    protected Pair<Integer, Position> ElephantRight;

    /**
     * 士
     */
    protected Pair<Integer, Position> MandarinLeft;

    protected Pair<Integer, Position> MandarinRight;

    /**
     * 炮
     */
    protected Pair<Integer, Position> CannonLeft;

    protected Pair<Integer, Position> CannonRight;
    /**
     * 将
     */
    protected Pair<Integer, Position> King;

    /**
     * 卒
     */
    protected Pair<Integer, Position> PawnLeft1;

    protected Pair<Integer, Position> PawnLeft2;

    protected Pair<Integer, Position> PawnLeft3;

    protected Pair<Integer, Position> PawnLeft4;

    protected Pair<Integer, Position> PawnLeft5;

    protected boolean beRed;

    public ChineseChess() {
//        this.setKing(new Pair<>(1, new Position(5,1)));
//        this.setRookLeft(new Pair<>(1, new Position(1,1)));
//        this.setRookRight(new Pair<>(1, new Position(9,1)));
//        this.setCannonLeft(new Pair<>(1, new Position(2,3)));
//        this.setCannonRight(new Pair<>(1, new Position(8,3)));
//        this.setElephantLeft(new Pair<>(1, new Position(3,1)));
//        this.setElephantRight(new Pair<>(1, new Position(7,1)));
//        this.setKnightLeft(new Pair<>(1, new Position(2,1)));
//        this.setKnightRight(new Pair<>(1, new Position(8,1)));
//        this.setMandarinLeft(new Pair<>(1, new Position(4,1)));
//        this.setMandarinRight(new Pair<>(1, new Position(6,1)));
//        this.setPawnLeft1(new Pair<>(1, new Position(1,4)));
//        this.setPawnLeft2(new Pair<>(1, new Position(3,4)));
//        this.setPawnLeft3(new Pair<>(1, new Position(5,4)));
//        this.setPawnLeft4(new Pair<>(1, new Position(7,4)));
//        this.setPawnLeft5(new Pair<>(1, new Position(9,4)));
    }

}
