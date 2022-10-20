package com.prprv.shop.util;

import com.alibaba.fastjson2.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author 未確認の庭師
 */
public class ReqJsonUtil {
    public static JSONObject getJson(HttpServletRequest request){
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try{
            in = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while((line = in.readLine()) != null){
                result.append(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return (JSONObject) JSONObject.parse(result.toString());
    }
}
