package com.atguigu.serviceorganization.util;

import java.util.HashMap;
import java.util.Map;

public class ParamsUtils {
    private  Map<String, Object> params=new HashMap<>();

    public ParamsUtils(int currPage,int limit) {
        this.params.put(Constant.PAGE,currPage+"");
        this.params.put(Constant.LIMIT,limit+"");
    }

    public Map<String,Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
