package cn.weicelove.robot.util;

import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;
import cn.weicelove.robot.operation.Operation;
import cn.weicelove.robot.regexhandle.FiveLengthHandle;
import cn.weicelove.robot.regexhandle.FourLengthHandle;
import cn.weicelove.robot.regexhandle.PositionHandle;
import cn.weicelove.robot.regexhandle.SixLengthHandle;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QIU PANWEI Create in 2019/11/18 14:14
 */
public class OperationDealUtil {

    private static Logger logger = LoggerFactory.getLogger(OperationDealUtil.class);

    private static final Map<String, Operation> operationMap;
    static {
        operationMap = new HashMap<>();
    }

    public static void dealOperate(String operate, Board board) {
        if (StringUtils.isBlank(operate)) {
            return;
        }
        PositionHandle positionHandle = selectHandleByLength(operate);
        if (positionHandle == null) {
            return;
        }

        Operation operation = positionHandle.getOperation(operate, board);
        Position position = positionHandle.getPosition(operate, board);
        operation.dealChessOperate(position, operate);
    }

    private static PositionHandle selectHandleByLength(String operate) {
        switch (operate.length()) {
            case 4:
                return new FourLengthHandle();
            case 5:
                return new FiveLengthHandle();
            case 6:
                return new SixLengthHandle();
            default:
                logger.info("can't deal operate = {}", operate);
                return null;
        }
    }


}
