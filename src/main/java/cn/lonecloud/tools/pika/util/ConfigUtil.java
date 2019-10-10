package cn.lonecloud.tools.pika.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author lonecloud
 * @version v1.0
 * @date 2019-08-05 14:20
 */
public class ConfigUtil {

    private static Properties properties=new Properties();

    static {
        String filePath = Objects.requireNonNull(ConfigUtil.class.getClassLoader().getResource("config.properties")).getFile();
        try {
            properties.load(new FileInputStream(new File(filePath)));
        } catch (IOException e) {
            throw new RuntimeException("error to get resource file",e);
        }
    }

    public static Integer getInteger(String key){
        String property = properties.getProperty(key);
        if (NumberUtils.isNumber(property)){
            return Integer.valueOf(property);
        }
        return 0;
    }
    public static boolean getBoolean(String key){
        String property = properties.getProperty(key);
        if (StringUtils.isNoneBlank(property)){
            return "true".equalsIgnoreCase(property);
        }
        return false;
    }

    public static String getString(String key){
        return properties.getProperty(key);
    }
}
