package com.auto.util;

public class GetPathUtil {

    // 获取Resources 资源
    public static String getResourcesPath(String filePath){
        String path1 =  Thread.currentThread().getContextClassLoader().getResource(filePath).getPath();
        return path1;
    }

}
