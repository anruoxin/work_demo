package cn.weicelove.robot.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author QIU PANWEI Create in 2019/10/30 13:57
 */
@Data
public class Position implements Serializable {

    private static final long serialVersionUID = -4321950396171818389L;

    public Position() {
    }

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
    private Integer x;
    private Integer y;

}
