package cn.lonecloud.tools.pika.filter;

import cn.lonecloud.tools.pika.pojo.Data;

/**
 * @author lonecloud
 * @version v1.0
 * @date 2019-07-24 14:12
 */
public interface DataFilter {

    boolean filter(Data data);
}
