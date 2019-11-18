package cn.weicelove.robot.entity;

/**
 * @author QIU PANWEI Create in 2019/10/15 10:48
 */
public class Board {

    private int[][] board;

    public Board() {
        this.board = new int[11][11];
    }

    public int[][] getBoard() {
        return board;
    }
}
