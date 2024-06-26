package com.atguigu.serviceprice.util;
import java.io.Serializable;

/*返回格式*/
public class JsonResult<E> implements Serializable {
    private Integer state;  //状态码
    private String message;   //描述信息
    private  E data;  //数据

    public JsonResult(){
    }

    public JsonResult(Integer state){
        this.state=state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public JsonResult(Integer state, String message, E data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}

