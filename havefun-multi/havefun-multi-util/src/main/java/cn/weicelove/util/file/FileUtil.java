package cn.weicelove.util.file;

import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

/**
 * @author QIU PANWEI Create in 2019/9/17 16:06
 */
public class FileUtil {

    private static Logger log = LoggerFactory.getLogger(FileUtil.class);

    public static void main(String[] args) {
        List<File> files = listFile();
        files.forEach(System.out::println);
    }

    public static List<File> listFile() {

        Collection<File> files = FileUtils.listFiles(new File("c://anruoxin//test_file"),FileFilterUtils.asFileFilter(e ->
                e.isFile() && !e.getName().endsWith(".rar")) , DirectoryFileFilter.DIRECTORY);
        return new ArrayList<>(files);
    }

    public static void transferTo(InputStream inputStream, String desPath) throws IOException {
        File file = new File(desPath);
        FileCopyUtils.copy(inputStream, new FileOutputStream(file));
    }

    public static void transferTo(InputStream inputStream, File des) throws IOException {
        FileCopyUtils.copy(inputStream, new FileOutputStream(des));
    }

    /**
     *
     * 文件是否存在
     * @param filePath 文件路径
     * @return boolean 存在返回 true
     * @author QIU PANWEI
     */
    public static boolean beFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    /**
     *
     * 判断这个路径是否是文件夹
     * @param path 文件夹路径
     * @return boolean 是文件夹 返回 true
     * @author QIU PANWEI
     */
    public static boolean beDir(String path) {
        File file = new File(path);
        return file.exists() && file.isDirectory();
    }

    /**
     *
     * 获取路径下所有的文件名称
     * @param filePath 文件路径
     * @return com.alibaba.fastjson.JSONObject
     * @author QIU PANWEI
     */
    public static void getFileListByPath(String filePath, Set<String> fileList) {
        File file = new File(filePath);
        if (!file.exists()) {
            return ;
        }
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                getFileListByPath(file1.getAbsolutePath(), fileList);
            } else {
                fileList.add(file1.getName());
            }
        }
    }


    public static File createFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            return file;
        }

        if (!file.getParentFile().exists()) {
            log.info("目标文件所在目录不存在");
            if (!file.getParentFile().mkdirs()) {
                log.info("创建目标文件目录失败");
                return null;
            }
        }
        if (file.createNewFile()) {
            log.info("创建文件成功 {}", filePath);
            return file;
        } else {
            log.info("创建目标文件失败");
        }
        return null;
    }

    public static File createFile(String fileName, String suffix, String filePath) throws IOException {
        // FileCopyUtils.copy()
        return createFile(filePath + File.separator + fileName + suffix);
    }

}
