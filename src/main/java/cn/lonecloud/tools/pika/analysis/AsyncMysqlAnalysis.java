package cn.lonecloud.tools.pika.analysis;

import cn.lonecloud.tools.pika.filter.DataFilter;
import cn.lonecloud.tools.pika.pojo.Data;
import cn.lonecloud.tools.pika.thread.DataQueue;
import cn.lonecloud.tools.pika.util.ConfigUtil;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lonecloud
 * @version v1.0
 * @date 2019-07-24 14:10
 */
public class AsyncMysqlAnalysis extends DataAnalysis{

    private static final int start= ConfigUtil.getInteger("data.start");

    public AsyncMysqlAnalysis(DataFilter dataFilter) throws IOException {
        super(dataFilter);
    }

    @Override
    protected void invokeData(Data data) throws InterruptedException {
        if (count.get()>=start) {
            DataQueue.getQueue().put(data);
        }else {
            if (count.get()%10000==0){
                logger.info("check is slow "+count);
            }
        }
        count.getAndIncrement();
    }



}
