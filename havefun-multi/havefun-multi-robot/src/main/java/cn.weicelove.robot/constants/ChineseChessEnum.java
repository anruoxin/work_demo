package cn.weicelove.robot.constants;

import cn.weicelove.robot.exception.NotFindChessException;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang.StringUtils;

/**
 * @author QIU PANWEI Create in 2019/9/29 17:11
 */
public class ChineseChessEnum {

    private static final String[] chess = new String[] {"車","馬",
            "相","仕","軳","帅","兵","车","马","象","士","炮","将","卒"};

    public static String[] getChess() {
        return chess;
    }


    @AllArgsConstructor
    public enum NumberEnum {
        YI("一", 1),
        ER("二", 2),
        SAN("三", 3),
        SI("四", 4),
        WU("五", 5),
        LIU("六", 6),
        QI("七", 7),
        BA("八", 8),
        JIU("九", 9);
        @Getter
        private String key;
        @Getter
        private Integer value;

        private static final Map<String, NumberEnum> kvMaps;

        static {
            kvMaps = new LinkedHashMap<>();
            for (NumberEnum value : NumberEnum.values()) {
                kvMaps.put(value.getKey(), value);
            }
        }

        public static NumberEnum of(String key) {
            return kvMaps.get(key);
        }

    }

    @AllArgsConstructor
    public enum ChessEnum {

        RED_ROOK(1,"車"),
        RED_KNIGHT(2,"馬"),
        RED_ELEPHANT(3,"相"),
        RED_MANDARIN(4,"仕"),
        RED_CANNON(5,"軳"),
        RED_KING(6,"帅"),
        RED_PAWN(7, "兵"),
        BLACK_ROOK(8,"车"),
        BLACK_KNIGHT(9,"马"),
        BLACK_ELEPHANT(10,"象"),
        BLACK_MANDARIN(11,"士"),
        BLACK_CANNON(12,"炮"),
        BLACK_KING(13,"将"),
        BLACK_PAWN(14, "卒");

        @Getter
        private Integer code;

        @Getter
        private String name;

        private static final Map<Integer, ChessEnum> kvMaps;

        static {
            kvMaps = new LinkedHashMap<>();
            for (ChessEnum value : ChessEnum.values()) {
                kvMaps.put(value.getCode(), value);
            }
        }

        public static ChessEnum of(Integer code) {
            return kvMaps.get(code);
        }

        public static Integer getCode(String name) {
            if (StringUtils.isBlank(name)) {
                throw new NullPointerException("the chess name is null");
            }
            for (ChessEnum value : ChessEnum.values()) {
                if (value.getName().equals(name)) {
                    return value.getCode();
                }
            }
            throw new NotFindChessException("no find the chess " + name);
        }

        public static boolean isBlack(String name){
            if (StringUtils.isBlank(name)) {
                throw new NullPointerException("the chess name is null");
            }
            return isBlack(getCode(name));
        }

        public static boolean isBlack(Integer code) {
            return code < 1 || code > 7;
        }

    }



}
