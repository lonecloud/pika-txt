package cn.lonecloud.tools.pika;

import cn.lonecloud.tools.pika.analysis.DataAnalysis;
import cn.lonecloud.tools.pika.analysis.ExampleAnalysis;
import cn.lonecloud.tools.pika.filter.ExampleDataFilter;
import cn.lonecloud.tools.pika.thread.ThreadCountDown;
import cn.lonecloud.tools.pika.util.ConfigUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
/**
 * @author lonecloud
 * @version v1.0
 * @date 2019-07-24 14:06
 */
public class PikaToolsMain {

    private static Logger logger= LoggerFactory.getLogger(PikaToolsMain.class);
    private static String filePath = ConfigUtil.getString("text.file");


    public static void main(String[] args) throws IOException, InterruptedException {
        Instant start = Instant.now();
        if ( StringUtils.isBlank(filePath)){
            //判断文件位置
            if (args==null||args.length==0){
                throw new IllegalArgumentException("参数错误，需要传递文件地址");
            }else {
                filePath=args[0];
            }
        }

        //增加总数
        DataAnalysis analysis=syncCount();
        long count = analysis.analysis(new File(filePath));
        //判断数据是否读取完成
        logger.error("数据读取完成，数据条数："+count);
        ThreadCountDown.setReadOver(true);
        ThreadCountDown.getCountDown().await();
        Instant end = Instant.now();
        long l = Duration.between(start, end).toMillis();
        System.out.println("消耗时间："+l);

    }
    public static DataAnalysis syncCount() throws IOException {
        ThreadCountDown.init(0);
        return new ExampleAnalysis(new ExampleDataFilter());
    }
}