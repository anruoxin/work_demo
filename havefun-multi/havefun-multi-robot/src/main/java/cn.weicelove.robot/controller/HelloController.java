package cn.weicelove.robot.controller;

import cn.weicelove.robot.constants.ChineseChessEnum;
import cn.weicelove.robot.constants.ChineseChessEnum.ChessEnum;
import cn.weicelove.robot.entity.BlackChess;
import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.ChineseChess;
import cn.weicelove.robot.entity.RedChess;
import cn.weicelove.robot.exception.NotFindChessException;
import cn.weicelove.robot.util.ChessUtil;
import cn.weicelove.robot.util.OperationDealUtil;
import java.util.Arrays;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QIU PANWEI Create in 2019/10/16 15:12
 */
@RestController
@RequestMapping("/user")
public class HelloController {

    public static void main(String[] args) {
        Board board = new Board();
        ChessUtil.initChessBoard(new BlackChess(), new RedChess(), board);
//        String s = "车一平四";
//        OperationDealUtil.dealOperate(s, board);
//        ChessUtil.printBoard(board);
//        String s1 = "相三进五";
//        OperationDealUtil.dealOperate(s1, board);
//        ChessUtil.printBoard(board);
//        String s2 = "仕四进五";
//        OperationDealUtil.dealOperate(s2, board);
//        ChessUtil.printBoard(board);
//        String s3 = "马八进九";
//        OperationDealUtil.dealOperate(s3, board);
//        ChessUtil.printBoard(board);
//        String s4 = "炮八进四";
//        OperationDealUtil.dealOperate(s4, board);
//        ChessUtil.printBoard(board);
//        String s5 = "軳八进四";
//        OperationDealUtil.dealOperate(s5, board);
//        ChessUtil.printBoard(board);
        String s6 = "兵九进一";
        OperationDealUtil.dealOperate(s6, board);
        ChessUtil.printBoard(board);
        String s7 = "卒九进一";
        OperationDealUtil.dealOperate(s7, board);
        ChessUtil.printBoard(board);
        String s8 = "兵九平八";
        OperationDealUtil.dealOperate(s8, board);
        ChessUtil.printBoard(board);
        String s9 = "兵八平七";
        OperationDealUtil.dealOperate(s9, board);
        ChessUtil.printBoard(board);
        String s10 = "前兵七平六";
        OperationDealUtil.dealOperate(s10, board);
        ChessUtil.printBoard(board);
        String s11 = "卒九平八";
        OperationDealUtil.dealOperate(s11, board);
        ChessUtil.printBoard(board);
        String s12 = "卒八平七";
        OperationDealUtil.dealOperate(s12, board);
        ChessUtil.printBoard(board);
        String s13 = "前卒七进一";
        OperationDealUtil.dealOperate(s13, board);
        ChessUtil.printBoard(board);
    }

}
