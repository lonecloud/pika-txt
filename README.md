# Pika-txt 工具

## 项目由来
> 由于之前项目中需要将pika中的全量数据进行导出，然后将该库中的所有数据取出部分我们业务中需要的数据，然后进行分割，解析完成后插入到我们的自己的DB中。
由于在我们线上生产中的Pika并不知道该Key的组成，所以不能使用`get`方式来进行获取参数

## 使用说明
1. 将你的pika数据文件拷贝到与tool相同的目录下,在linux环境下运行,先将数据导出到txt中

```shell
./pika_to_txt ./blackwidow_db ./data.txt
```

2. 将`data.txt`复制到`config.properties`文件中的`text.file`中
3. 运行start.sh即可

## 相关接口
`DataAnalysis`:数据解析类，如果需要对数据进行处理，则继承该类，重写`invokeData`方法即可。
`DataFilter`:数据过滤器接口，判断哪些数据需要过滤掉