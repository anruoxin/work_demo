package cn.weicelove.robot.entity;

import cn.weicelove.robot.constants.ChineseChessEnum.ChessEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.util.Pair;
import lombok.Data;
import lombok.ToString;

/**
 * @author QIU PANWEI Create in 2019/9/29 14:20
 */
@Data
public class BlackChess extends ChineseChess {

    private static final long serialVersionUID = 6482941519816391110L;

    /**
     * 站在对面的角度
     * 数字棋盘 1-9 ，从左到右
     *----------------------------
     * 九 八 七 六 五 四 三 二 一
     * ---------------------------
     * 车 马 象 士 将 士 象 马 车
     *
     *   炮               炮
     * 卒   卒    卒    卒    卒
     *
     * ---------------------------
     */
    public BlackChess() {
        super();
        this.setBeRed(false);
        this.setKing(new Pair<>(ChessEnum.BLACK_KING.getCode(), new Position(5,1)));
        this.setRookLeft(new Pair<>(ChessEnum.BLACK_ROOK.getCode(), new Position(1,1)));
        this.setRookRight(new Pair<>(ChessEnum.BLACK_ROOK.getCode(), new Position(9,1)));
        this.setCannonLeft(new Pair<>(ChessEnum.BLACK_CANNON.getCode(), new Position(2,3)));
        this.setCannonRight(new Pair<>(ChessEnum.BLACK_CANNON.getCode(), new Position(8,3)));
        this.setElephantLeft(new Pair<>(ChessEnum.BLACK_ELEPHANT.getCode(), new Position(3,1)));
        this.setElephantRight(new Pair<>(ChessEnum.BLACK_ELEPHANT.getCode(), new Position(7,1)));
        this.setKnightLeft(new Pair<>(ChessEnum.BLACK_KNIGHT.getCode(), new Position(2,1)));
        this.setKnightRight(new Pair<>(ChessEnum.BLACK_KNIGHT.getCode(), new Position(8,1)));
        this.setMandarinLeft(new Pair<>(ChessEnum.BLACK_MANDARIN.getCode(), new Position(4,1)));
        this.setMandarinRight(new Pair<>(ChessEnum.BLACK_MANDARIN.getCode(), new Position(6,1)));
        this.setPawnLeft1(new Pair<>(ChessEnum.BLACK_PAWN.getCode(), new Position(1,4)));
        this.setPawnLeft2(new Pair<>(ChessEnum.BLACK_PAWN.getCode(), new Position(3,4)));
        this.setPawnLeft3(new Pair<>(ChessEnum.BLACK_PAWN.getCode(), new Position(5,4)));
        this.setPawnLeft4(new Pair<>(ChessEnum.BLACK_PAWN.getCode(), new Position(7,4)));
        this.setPawnLeft5(new Pair<>(ChessEnum.BLACK_PAWN.getCode(), new Position(9,4)));
    }

    @Override
    public String toString() {
        return "BlackChess{" +
                "RookLeft=" + RookLeft +
                ", RookRight=" + RookRight +
                ", KnightLeft=" + KnightLeft +
                ", KnightRight=" + KnightRight +
                ", ElephantLeft=" + ElephantLeft +
                ", ElephantRight=" + ElephantRight +
                ", MandarinLeft=" + MandarinLeft +
                ", MandarinRight=" + MandarinRight +
                ", CannonLeft=" + CannonLeft +
                ", CannonRight=" + CannonRight +
                ", King=" + King +
                ", PawnLeft1=" + PawnLeft1 +
                ", PawnLeft2=" + PawnLeft2 +
                ", PawnLeft3=" + PawnLeft3 +
                ", PawnLeft4=" + PawnLeft4 +
                ", PawnLeft5=" + PawnLeft5 +
                ", beRed=" + beRed +
                '}';
    }

    public List<Pair<Integer, Position>> getList() {
        return new ArrayList<>(Arrays.asList(RookLeft,
                RookRight, KnightLeft, KnightRight, ElephantLeft,
                ElephantRight, MandarinLeft, MandarinRight,
                CannonLeft, CannonRight, King, PawnLeft1,
                PawnLeft2, PawnLeft3, PawnLeft4, PawnLeft5));
    }

    public static void main(String[] args) {
        System.out.println(new BlackChess());
    }
}
