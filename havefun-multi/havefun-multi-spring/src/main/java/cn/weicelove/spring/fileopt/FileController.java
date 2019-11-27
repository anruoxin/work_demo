package cn.weicelove.spring.fileopt;

import cn.weicelove.util.date.DateUtil;
import cn.weicelove.util.file.FileUtil;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author QIU PANWEI Create in 2019/11/25 19:10
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.path}")
    private String fileRootPath;

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 上传文件接口
     * @param files 上传的文件列表
     * @return void
     * @author QIU PANWEI
     */
    @RequestMapping("/upload")
    public void upload(@RequestParam("files") MultipartFile[] files) {
        System.out.println("文件个数: " + files.length);
        if (files.length > 0) {
            uploadFiles(files);
        }
    }

    /**
     * 文件下载接口
     * @param fileName 下载的文件名称
     * @return void
     * @author QIU PANWEI
     */
    @RequestMapping("/download")
    public void download(String fileName) {

    }

    private void uploadFiles(MultipartFile[] files) {
        for (int i = 0; i < files.length; i++) {
            dealFile(files[i], i + 1);
        }
    }

    private void dealFile(MultipartFile file, int index) {

        if (file.isEmpty()) {
            logger.debug("第{}个文件不存在", index);
        }

        // 文件名称带后缀
        String originalFilename = file.getOriginalFilename();
        logger.info("originalFilename = {}", originalFilename);
        // 前端传递的参数名称
        String name = file.getName();
        logger.info("name= {}", name);
        long size = file.getSize();
        logger.info("size = {}", size);
        try {
            File desFile = FileUtil.createFile(fileRootPath + DateUtil.getNowTimeStr() + originalFilename);
            if (desFile == null) {
                logger.debug("目标文件生成失败");
                return;
            }
            FileUtil.transferTo(file.getInputStream(), desFile);
        } catch (IOException e) {
            logger.error("文件转换出错", e);
        }

    }

}
