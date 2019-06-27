package com.shibo.util.extractUtil;

import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 代码写的有问题，需要重新判断
 * 请求开始和请求结束……这个需要判断整合！
 */

public class Test {
    public static void main(String[] args) {
        //1.提取信息 reqRegex/resRegex
        String reqRegex="url\\:.{1}http://10.237.16.11:6011/obu/reg\\,.{1}args\\:.{1}\\[(.+?)\\]";
        String resRegex="\\{\\\"success\\\"\\:true,\\\"message\\\"\\:null\\,\\\"userCert\\\"\\:\\\"(.+?)\\\"\\,\\\"trustCert\\\"\\:\\\"(.+?)\\\"\\}";
        Pattern reqCom = Pattern.compile(reqRegex);
        Pattern resCom = Pattern.compile(resRegex);

        //2.提取信息userCert/trustCert
        String userRegex="\\\"userCert\\\"\\:\\\"(.+?)\\\"";
        Pattern userCertCom = Pattern.compile(userRegex);
        String trustRegex="\\\"trustCert\\\"\\:\\\"(.+?)\\\"";
        Pattern trustCertCom=Pattern.compile(trustRegex);

        //3.提取信息sn和se
        String snRegex="\\\"sn\\\"\\:\\\"(.+?)\\\"";
        Pattern snCom = Pattern.compile(snRegex);
        String seRegex="\\\"se\\\"\\:\\\"(.+?)\\\"";
        Pattern seCom=Pattern.compile(seRegex);

        ArrayList<HashMap<String,String>> reqResult=new ArrayList<>();
        ArrayList<HashMap<String,String>> resResult=new ArrayList<>();
        String temp="";
        try {
            //1.读取其中的值放入数据结构中
            List<String> strings = FileUtils.readLines(new File("C:\\Users\\36336\\Desktop\\develop\\test\\src\\main\\resources\\etc-base-ca.log"), "utf-8");
            for(String string:strings){
                Matcher reqMatcher=reqCom.matcher(string);
                if(reqMatcher.find()){
                    temp=reqMatcher.group();
                    System.out.println(temp);
                    Matcher snMatcher=snCom.matcher(temp);
                    Matcher seMatcher=snCom.matcher(temp);
                    if(snMatcher.find()&&seMatcher.find()){
                        reqResult.add(new HashMap(){{
                            put("sn",snMatcher.group());
                            put("se",seMatcher.group());
                        }});
                    }
                    temp="";
                    continue;
                }
                Matcher resMatcher = resCom.matcher(string);
                if(resMatcher.find()){
                    temp = resMatcher.group();
                    System.out.println(temp);
                    Matcher userCertMatcher = userCertCom.matcher(temp);
                    Matcher trustCertMatcher = trustCertCom.matcher(temp);
                    if(userCertMatcher.find()&&trustCertMatcher.find()){
                        resResult.add(new HashMap(){{
                            put("userCert",userCertMatcher.group());
                            put("trustCert",trustCertMatcher.group());
                        }});
                    }
                    temp="";
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
