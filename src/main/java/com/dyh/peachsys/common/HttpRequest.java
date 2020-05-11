package com.dyh.peachsys.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dyh.peachsys.dto.ProductDto;
import io.swagger.annotations.Api;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Peach-華
 * @version V1.0
 * @desc 网络请求工具包
 * @copyright &copy; DYH
 * @date 2020/5/11-20:38
 * @address 成都
 */
@Api(tags = "网络请求工具包")
public class HttpRequest {
    public static JSONArray httpRequest() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(RequestCommon.url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);//执行请求
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {//请求成功执行
                HttpEntity entity = response.getEntity();//获取返回的数据
                String s = EntityUtils.toString(entity);//转换成字符串
                JSONObject datas = JSONObject.parseObject(s);//转换成JSON格式
                Integer status = (Integer) datas.get("status");//获取返回数据状态，get获取的字段需要根据提供的返回值去获取
                if (status == 200) {//返回的状态
                    JSONObject data = JSONObject.parseObject(datas.get("data").toString());//"data"是根据返回值设定
                    JSONObject jo = JSONObject.parseObject(data.toJSONString());
                    JSONArray records = JSONObject.parseArray(jo.get("records").toString());//"records"是根据返回值设定
                    return records;//返回的数据就是我需要去解析的
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void getData() {
        JSONArray datas = httpRequest();//调用方法，回去"data"里面的数据
        List<ProductDto> products = new ArrayList<>();//创建dto对象，这个对象的结构来自于返回值
        if (!datas.isEmpty()) {//如果返回的数据不为空
            products = JSONArray.parseArray(datas.toJSONString(), ProductDto.class);//转换成对象
        }
        //输出测试
        products.forEach(product -> System.out.println(product));
    }
}
