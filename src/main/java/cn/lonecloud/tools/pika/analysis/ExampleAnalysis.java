package cn.lonecloud.tools.pika.analysis;

import cn.lonecloud.tools.pika.filter.DataFilter;
import cn.lonecloud.tools.pika.pojo.Data;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.tools.pika.analysis
 * @Description: TODO
 * @date 2019/10/13 10:35 PM
 */
public class ExampleAnalysis extends DataAnalysis {
    public ExampleAnalysis(DataFilter dataFilter) {
        super(dataFilter);
    }

    @Override
    protected void invokeData(Data data) throws InterruptedException {
        //这里开始解析你的数据,data
    }
}
