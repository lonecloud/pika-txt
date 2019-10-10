package cn.lonecloud.tools.pika.pojo;

/**
 * @author lonecloud
 * @version v1.0
 * @date 2019-07-24 09:23
 */
public class Data {
    private int keyLen;

    private String key;

    private int valueLen;

    private String value;

    public int getKeyLen() {
        return keyLen;
    }

    public void setKeyLen(int keyLen) {
        this.keyLen = keyLen;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValueLen() {
        return valueLen;
    }

    public void setValueLen(int valueLen) {
        this.valueLen = valueLen;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Data{" +
                "keyLen=" + keyLen +
                ", key='" + key + '\'' +
                ", valueLen=" + valueLen +
                ", value='" + value + '\'' +
                '}';
    }
}
