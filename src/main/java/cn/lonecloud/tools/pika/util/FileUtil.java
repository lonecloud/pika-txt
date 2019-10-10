package cn.lonecloud.tools.pika.util;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author lonecloud
 * @version v1.0
 * @date 2019-07-31 17:42
 */
public class FileUtil {

    private static Logger logger= LoggerFactory.getLogger(FileUtil.class);
    public static void write(String fileName,String content) throws IOException {
        List<String> contentList=new ArrayList<>();
        contentList.add(content);
        FileUtils.writeLines(new File(fileName), contentList,true);
    }
    public static void reader(String fileName, Consumer<String> consumer) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            //将数据转换
            String line;
            while ( (line = reader.readLine())!=null){
                //持续
                if (StringUtils.isNotBlank(line)&&!"null".equals(line)){
                    consumer.accept(line);
                }else {
                    //打印日志
                    logger.warn("get file data is {}",line);
                }
            }
        }
    }
}
