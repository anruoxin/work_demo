package cn.weicelove.robot.exception;

/**
 * @author QIU PANWEI Create in 2019/10/16 11:29
 */
public class NotFindChessException extends RuntimeException{

    private static final long serialVersionUID = 6557530285439399264L;

    public NotFindChessException() {
        super();
    }

    public NotFindChessException(String message) {
        super(message);
    }
}
