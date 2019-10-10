package cn.lonecloud.tools.pika.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author lonecloud
 * @version v1.0
 * @date 2019-07-25 15:30
 */
public class ThreadCountDown {

   private static volatile CountDownLatch countDownLatch;

   private static volatile boolean readOver =false;

   public static void init(int count){
       countDownLatch=new CountDownLatch(count);
   }
   public static void down(){
       countDownLatch.countDown();
   }
   public static CountDownLatch getCountDown(){
       return countDownLatch;
   }

    public static boolean isReadOver() {
        return readOver;
    }

    public static void setReadOver(boolean readOver) {
        ThreadCountDown.readOver = readOver;
    }
}
