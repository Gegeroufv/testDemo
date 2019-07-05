package com.shibo.demo.utilsTest.httpUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class HttpUtils {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("distinationUrl")
    private String destinationUrl;

//    public <T> T send(BaseSubReqDto reqDto, Class<T> responseClass) {
//        String writeValueAsString = null;
//        try {
//            writeValueAsString = objectMapper.writeValueAsString(reqDto);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        BaseReqDto reqParent = new BaseReqDto();
//        reqParent.setAreaNo("1101");
//        reqParent.setOperatorId("1101000000000001");
//        reqParent.setFormat("JSON");
//        reqParent.setEncoding("UTF-8");
//        reqParent.setTokenCode("000000000000000000000000000000000000");
//        reqParent.setRandom("5f7f8f7baebc4eb6");
//        reqParent.setReqParamsSet(writeValueAsString);
//        reqParent.setMac("00000000");
//        BaseResDto postForObject = restTemplate.postForObject("https://223.72.157.173:8000/secure-gateway-api" + reqDto.getUrl(), reqParent, BaseResDto.class);
//        if(!"0000".equals(postForObject.getCode())) {
//            throw new RuntimeException("请求异常[501]:" + postForObject.getMsg());
//        }
//        T readValue = null;
//        try {
//            readValue = objectMapper.readValue(postForObject.getRespParamsSet(), responseClass);
//        } catch (IOException e) {
//            throw new RuntimeException("请求异常[502]:类型转换错误，请联系管理员" );
//        }
//        return readValue;
//    }
//    public <T> T PostMethod(Object obj,Class<T> responseClass){
//
//    }

    public static HttpServletRequest getCurrentRequest() throws IllegalStateException{
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs == null) {
            throw new IllegalStateException("当前线程中不存在 Request 上下文");
        }
        return attrs.getRequest();
    }
//    // 区域编码
//    private String areaNo;
//
//    // 运营商编码
//    private String operatorId;
//
//    // 参数格式
//    private String format;
//
//    // 参数编码
//    private String encoding;
//
//    // 令牌
//    private String tokenCode;
//
//    // 随机数
//    private String random;
//
//    // 参数集合
//    private String reqParamsSet;
//
//    // 校验码
//    private String mac;
}
