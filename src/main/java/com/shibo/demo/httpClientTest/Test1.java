package com.shibo.demo.httpClientTest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;
//https://blog.csdn.net/gabriel576282253/article/details/81531746证书安装
//ssl安全间套层需要被忽略
//https://blog.csdn.net/gabriel576282253/article/details/81531746
public class Test1 {
    public static void main(String[] args) {
        //获取http客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //创建post请求
        HttpPost httpPost = new HttpPost("https://223.72.157.173:8000/secure-gateway-api/v1/sm/card/second/issue/listno");
        String json = "{\n" +
                "\t\"areaNo\":\"1101\",\n" +
                "\t\"operatorId\":\"1101000000000001\",\n" +
                "\t\"encoding\":\"UTF-8\",\n" +
                "\t\"random\":\"BCF9547D4F7E46C2\",\n" +
                "\t\"tokenCode\":\"000000000000000000000000000000000000\",\n" +
                "\t\"format\":\"JSON\",\n" +
                "\t\"reqParamsSet\":\"{\\\"proListNo\\\":\\\"1101012019021912000038844b2db6581a9a\\\",\\\"cardNo\\\":\\\"1815000000000001\\\",\\\"keyVersion\\\":\\\"51\\\"}\",\n" +
                "\t\"mac\":\"00000000\"\n" +
                "}";
        StringEntity entity = new StringEntity(json, "utf-8");
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应内容长度为：" + responseEntity.getContentLength());
            System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
