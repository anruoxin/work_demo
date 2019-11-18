package cn.weicelove.robot.entity;

import cn.weicelove.robot.constants.ChineseChessEnum.ChessEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.util.Pair;
import lombok.Data;

/**
 * @author QIU PANWEI Create in 2019/9/29 14:19
 */
@Data
public class RedChess extends ChineseChess{

    /**
     * 中文标号 一~九 从左到右
     */
    public RedChess() {
        super();
        this.setBeRed(true);
        this.setKing(new Pair<>(ChessEnum.RED_KING.getCode(), new Position(5,1)));
        this.setRookLeft(new Pair<>(ChessEnum.RED_ROOK.getCode(), new Position(1,1)));
        this.setRookRight(new Pair<>(ChessEnum.RED_ROOK.getCode(), new Position(9,1)));
        this.setCannonLeft(new Pair<>(ChessEnum.RED_CANNON.getCode(), new Position(2,3)));
        this.setCannonRight(new Pair<>(ChessEnum.RED_CANNON.getCode(), new Position(8,3)));
        this.setElephantLeft(new Pair<>(ChessEnum.RED_ELEPHANT.getCode(), new Position(3,1)));
        this.setElephantRight(new Pair<>(ChessEnum.RED_ELEPHANT.getCode(), new Position(7,1)));
        this.setKnightLeft(new Pair<>(ChessEnum.RED_KNIGHT.getCode(), new Position(2,1)));
        this.setKnightRight(new Pair<>(ChessEnum.RED_KNIGHT.getCode(), new Position(8,1)));
        this.setMandarinLeft(new Pair<>(ChessEnum.RED_MANDARIN.getCode(), new Position(4,1)));
        this.setMandarinRight(new Pair<>(ChessEnum.RED_MANDARIN.getCode(), new Position(6,1)));
        this.setPawnLeft1(new Pair<>(ChessEnum.RED_PAWN.getCode(), new Position(1,4)));
        this.setPawnLeft2(new Pair<>(ChessEnum.RED_PAWN.getCode(), new Position(3,4)));
        this.setPawnLeft3(new Pair<>(ChessEnum.RED_PAWN.getCode(), new Position(5,4)));
        this.setPawnLeft4(new Pair<>(ChessEnum.RED_PAWN.getCode(), new Position(7,4)));
        this.setPawnLeft5(new Pair<>(ChessEnum.RED_PAWN.getCode(), new Position(9,4)));
    }

    @Override
    public String toString() {
        return "RedChess{" +
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
}
