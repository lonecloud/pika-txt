package cn.lonecloud.tools.pika.analysis;

import cn.lonecloud.tools.pika.filter.DataFilter;
import cn.lonecloud.tools.pika.pojo.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lonecloud
 * @version v1.0
 * @date 2019-07-24 14:06
 */
public abstract class DataAnalysis {

    static Logger logger= LoggerFactory.getLogger(DataAnalysis.class);

    private DataFilter dataFilter;

    AtomicLong count=new AtomicLong(0);

    public DataAnalysis(DataFilter dataFilter) {
        this.dataFilter = dataFilter;
    }

    public long analysis(File file) throws IOException, InterruptedException {
        FileInputStream fis=new FileInputStream(file);
        Data data;
        while ((data=getData(fis))!=null){
            if (dataFilter.filter(data)){
                invokeData(data);
            }
        }
        return count.get();
    }

    protected abstract void invokeData(Data data) throws InterruptedException;

    private  Data getData(FileInputStream fis) throws IOException {
        //key
        int len = getLen(fis);
        if (len > 0){
            Data data =new Data();
            String value = getValue(fis, len);
            data.setKeyLen(len);
            data.setKey(value);
            //value
            int valueLen = getLen(fis);
            if (valueLen>0){
                String keyValue = getValue(fis, valueLen);
                data.setValue(keyValue);
                data.setValueLen(valueLen);
                return data;
            }else {
                logger.error("valueLen <0 value is:"+valueLen);
            }
        }else {
            logger.error("keyLen <0 value is:"+len);
        }

        return null;
    }
    private int getLen(FileInputStream fis) throws IOException {
        byte[] len=new byte[4];
        int read = fis.read(len);
        if (read==-1){
            //长度
            return -1;
        }
        return byteArrToInt(len);
    }



    private String getValue(FileInputStream fis, int keyLen) throws IOException {
        byte[] key=new byte[keyLen];
        int keyRead = fis.read(key);
        if (keyRead==-1){
            return null;
        }
        return new String(key);
    }

    private int byteArrToInt(byte[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int incr = arr[i] << (8 * i);
            sum+=incr;
        }
        if (sum<0){
            logger.error("byteArrToInt------->"+sum+arr[0]+arr[1]+arr[2]+arr[3]);
        }
        return sum;
    }

}
