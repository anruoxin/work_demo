package cn.weicelove.robot.util;

import cn.weicelove.robot.constants.ChineseChessEnum.ChessEnum;
import cn.weicelove.robot.entity.BlackChess;
import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;
import cn.weicelove.robot.entity.RedChess;
import java.util.List;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QIU PANWEI Create in 2019/9/29 15:53
 */
public class ChessUtil {
    private static Logger logger = LoggerFactory.getLogger(ChessUtil.class);

    private static String[] axisX = {"一","二","三","四","五","六","七","八","九"};

    private static Board chessBoard;

    public static void main(String[] args) {
        initChessBoard(new BlackChess(), new RedChess(), new Board());
//        System.out.println("初始化完成");
        //printBoard();
    }

    public static String initChessBoard(BlackChess blackChess, RedChess redChess,Board board) {
        ChessUtil.chessBoard = board;
        entityToMap(blackChess, redChess);
        printBoard();
        return null;
    }

    public static void printBoard() {
        if (chessBoard == null) {
            logger.info("棋盘初始化未完成！");
            return;
        }

        initAxis(false);
        initLine();
        for (int i = 1; i <= 5; i++) {
            initChess(i);
        }
        initRiver();
        for (int i = 6; i <= 10; i++) {
            initChess(i);
        }
        initLine();
        initAxis(true);

    }
    private static void initRiver() {
        initLine();
        System.out.print("  | ");
        System.out.print("   楚河  汉界   ");
        System.out.println("|");
        initLine();
    }

    private static void addRedChess(Pair<Integer, Position> chess) {
        Integer x = chess.getValue().getX();
        Integer y = chess.getValue().getY();
        chessBoard.getBoard()[x][y] = chess.getKey();
    }

    private static void addBlackChess(Pair<Integer, Position> chess) {
        Integer x = chess.getValue().getX();
        Integer y = chess.getValue().getY();
        chessBoard.getBoard()[10 - x][11 - y] = chess.getKey();
    }

    private static List<Pair<Integer, Position>> entityToMap(BlackChess blackChess, RedChess redChess) {
        // 以红色的左边的车的,以左上角为(1, 1)
        List<Pair<Integer, Position>> redChessList = redChess.getList();
        redChessList.forEach(ChessUtil::addRedChess);
        List<Pair<Integer, Position>> blackChessList = blackChess.getList();
        blackChessList.forEach(ChessUtil::addBlackChess);
        return null;
    }

    private static void initAxis(boolean flag) {
        for (int i = 0; i < 4; i++) {
            System.out.print(" ");
        }
        if (flag) {
            for (int i = 8; i >= 0; i --) {
                System.out.print(axisX[i]);
            }
        } else {
            for (int i = 0; i < 9; i++) {
                System.out.print(axisX[i]);
            }
        }
        System.out.println();
    }

    private static void initLine() {
        for (int i = 0; i < 10 * 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void initChess(int y) {
        System.out.print(String.format("%02d| ", y));
        for (int i = 1; i <= 9; i++) {
            ChessEnum chessEnum = ChessEnum.of(chessBoard.getBoard()[i][y]);
            if (chessEnum != null) {
                System.out.print(chessEnum.getName());
            } else {
                System.out.print("！");
            }
        }
        System.out.println("|");
    }

}
