package cn.weicelove.util.model;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * @author QIU PANWEI Create in 2019/11/28 20:22
 */
@Data
public class FileInfo implements Serializable {

    private static final long serialVersionUID = -6055945916771501877L;

    private String fileName;

    private Integer fileSeize;

    private List<FileInfo> fileInfoList;
}
