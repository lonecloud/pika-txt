package cn.lonecloud.tools.pika.thread;

import cn.lonecloud.tools.pika.pojo.Data;
import cn.lonecloud.tools.pika.util.ConfigUtil;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author lonecloud
 * @version v1.0
 * @date 2019-07-25 10:57
 */
public class DataQueue {

    private static final LinkedBlockingDeque<Data> queue;

    static {
        Integer queueSize = ConfigUtil.getInteger("queue.size");
        queue=new LinkedBlockingDeque<>(queueSize);
    }


    public static void add(Data data) throws InterruptedException {
        queue.put(data);
    }
    public static LinkedBlockingDeque<Data> getQueue(){
        return queue;
    }

}
