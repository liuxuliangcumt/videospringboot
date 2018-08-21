package com.cumt.video.data.pojo.common;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapResult {

    /**
     * 生成接口返回结果
     * @param status
     * @param desc
     * @param message
     * @return
     */
    public static Map<String,Object> createResultMap(String status, Desc desc, Object message){
        Map<String,Object> map = new HashMap<String,Object>();
        if (!StringUtils.isNotBlank(status)){
            status = "1";
        }
        if (!StringUtils.isNotBlank(desc.getCode())){
            desc.setCode(" ");
        }
        if (!StringUtils.isNotBlank(desc.getDescription())){
            desc.setDescription(" ");
        }
        if (Objects.isNull(message) || message.equals("")){
            message = " ";
        }
        map.put("desc", desc);
        map.put("status",status);
        map.put("message",message);
        return map;
    }
}
