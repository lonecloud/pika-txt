package cn.lonecloud.tools.pika.filter;

import cn.lonecloud.tools.pika.pojo.Data;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.tools.pika.filter
 * @Description: TODO
 * @date 2019/10/1310:37 PM
 */
public class ExampleDataFilter implements DataFilter {
    @Override
    public boolean filter(Data data) {
        //过滤你的数据，返回true，则是你需要的数据，返回false则直接过滤掉
        return true;
    }
}
