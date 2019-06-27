package com.shibo.util.extractUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        String str1="2019-06-10 09:40:15 [http-nio-6011-exec-32] INFO  c.a.e.b.c.a.ControllerAspect:69 - 请求开始, 各个参数, logid:8c0b2d5f-bae8-4d93-be94-56db9b46906e, url: http://10.237.16.11:6011/obu/reg, args: [{\"se\":\"4101191809649903\",\"sn\":\"4101191518649903\",\"companyId\":\"成谷\",\"p10\":\"MIIBMzCB2wIBADB7MSAwHgYDVQQDDBfmraPlvI9ANDEwMTE5MTgwOTY0OTkwMzEYMBYGA1UECgwP5Lqk6YCa6L+Q6L6T6YOoMQswCQYDVQQGDAJDTjEwMC4GA1UECwwn5rKz5Y2X55yB6KeG5Y2a55S15a2Q6IKh5Lu95pyJ6ZmQ5YWs5Y+4MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAESNaOvRw/zoB6p3E6PhZMT1mdqdW9hSxX9+0Qz8ZsqYx0eEpYIGiLtKCA9X9dfdUGHURekhNXSLowtV1QhlzZXDAKBggqgRzPVQGDdQNHADBEAiBhQZQbyFP6TRMC2Ifj3G09+geC7XdJPFzvDbyiCtI8GwIgSzsHpbXQHuJqNrGL7nbWD9tHBFif2W7NDqIgDHj2aXo=\",\"obuModel\":\"EfsysT103\",\"obuType\":\"01\",\"fileName\":\"补申请证书数据1082.xlsx\",\"pk\":\"48D68EBD1C3FCE807AA7713A3E164C4F599DA9D5BD852C57F7ED10CFC66CA98C74784A5820688BB4A080F57F5D7DD5061D445E92135748BA30B55D50865CD95C\"}], queryString:null ";
        String resRegex="url\\:.{1}http://10.237.16.11:6011/obu/reg\\,.{1}args\\:.{1}\\[(.+?)\\]";
        Pattern res=Pattern.compile(resRegex);
        Matcher matcher=res.matcher(str1);
        //必须先find才能group
        if(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
