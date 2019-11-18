package cn.weicelove.robot.util;

import cn.weicelove.robot.entity.Board;
import cn.weicelove.robot.entity.Position;
import cn.weicelove.robot.regexhandle.FiveLengthHandle;
import cn.weicelove.robot.regexhandle.FourLengthHandle;
import cn.weicelove.robot.regexhandle.PositionHandle;
import cn.weicelove.robot.regexhandle.SixLengthHandle;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QIU PANWEI Create in 2019/11/18 14:14
 */
public class RegexUtil {

    private static Logger logger = LoggerFactory.getLogger(RegexUtil.class);

    public static Position dealOperate(String operate, Board board) {
        if (StringUtils.isBlank(operate)) {
            return null;
        }
        PositionHandle positionHandle = selectHandleByLength(operate);
        if (positionHandle == null) {
            return null;
        }
        return positionHandle.getPosition(operate, board);
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
