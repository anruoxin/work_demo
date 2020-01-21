package cn.weicelove.spring.fileopt;

import cn.weicelove.spring.aop.Log;
import cn.weicelove.util.file.FileUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
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
    @Log("上传文件")
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
    public void download(String fileName, HttpServletResponse response) {

        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName="
                    + java.net.URLEncoder.encode(fileName,"utf-8"));
//            String filePath = request.getSession().getServletContext().getRealPath("/")
//                    + "WEB-INF/upload/" + fileName;
            InputStream inputStream = new FileInputStream(new File(fileRootPath + fileName));
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            os.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/getFileList")
    public String getFileList() {
        Set<String> files = new HashSet<>();
        FileUtil.getFileListByPath(fileRootPath, files);
        return JSONObject.toJSONString(files);
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
        logger.debug("originalFilename = {}", originalFilename);
        // 前端传递的参数名称
        String name = file.getName();
        logger.debug("name= {}", name);
        long size = file.getSize();
        logger.debug("size = {}", size);
        try {
            File desFile = FileUtil.createFile(fileRootPath + originalFilename);
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
