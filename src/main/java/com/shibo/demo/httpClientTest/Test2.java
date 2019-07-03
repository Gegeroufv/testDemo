package com.shibo.demo.httpClientTest;


import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import sun.swing.StringUIClientPropertyKey;

public class Test2 {

    @Data
     public static class Abc{

         String areaNo;



    }

    public static void main(String[] args) throws Exception {
        String url = "https://223.72.157.173:8000/secure-gateway-api/v1/sm/card/second/issue/listno";

        ObjectMapper o = new ObjectMapper();

        Map<String, Object> params = o.readValue("{\"areaNo\":\"1101\",\"operatorId\":\"1101000000000001\",\"encoding\":\"UTF-8\",\"random\":\"BCF9547D4F7E46C2\",\"tokenCode\":\"000000000000000000000000000000000000\",\"format\":\"JSON\",\"reqParamsSet\":\"{\\\"proListNo\\\":\\\"1101012019021912000038844b2db6581a9a\\\",\\\"cardNo\\\":\\\"1815000000000001\\\",\\\"keyVersion\\\":\\\"51\\\"}\",\"mac\":\"00000000\"}", new TypeReference<HashMap<String, Object>>(){});

        post(url, params, Abc.class);
    }

    private static <T>T post(String url, Object o, Class<T> responseClass) throws Exception {

        // 创建自定义的httpclient对象
        CloseableHttpClient client = getIgnoeSSLClient();


        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        // 指定报文头Content-type、User-Agent
        httpPost.addHeader("Content-Type", ContentType.APPLICATION_JSON.getMimeType());

        ObjectMapper objectMapper = new ObjectMapper();

        StringEntity entity = new StringEntity(objectMapper.writeValueAsString(o));

        httpPost.setEntity(entity);
        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);

        // 获取结果实体
        HttpEntity rsEntity = response.getEntity();
        if (rsEntity == null) {
            throw new RuntimeException("返回失败");

        }
        // 按指定编码转换结果实体为String类型
        String body = EntityUtils.toString(entity, "UTF-8");
        String string = EntityUtils.toString(rsEntity);
        EntityUtils.consume(rsEntity);
        T t = (T)objectMapper.readValue(string, responseClass.getClass());
        System.out.println("响应内容为:" + string);


        // 释放链接
        response.close();
        return t;
    }

    // 忽略SSL
    public static CloseableHttpClient getIgnoeSSLClient() throws Exception {
        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
            // 忽略证书
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        }).build();

        // 创建httpClient
        CloseableHttpClient client = HttpClients.custom().setSSLContext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier()).build();// 关闭主机名校验，因为测试是IP
        return client;
    }
}
