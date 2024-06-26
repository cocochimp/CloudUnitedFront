package com.atguigu.serviceprice.controller;

import com.atguigu.serviceprice.controller.ex.FileIOUploadException;
import com.atguigu.serviceprice.service.ex.*;
import com.atguigu.serviceprice.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*控制层基类*/
public class BaseController {
    public static final int OK=200;

    /*异常处理*/
    @ExceptionHandler({ServiceException.class})
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult<Void> result= new JsonResult<>(e);
        if (e instanceof InsertException){
            result.setState(101);
            result.setMessage(e.getMessage());
        }else if (e instanceof FileIOUploadException){
            result.setState(102);
            result.setMessage(e.getMessage());
        }else if(e instanceof DeleteException){
            result.setState(201);
            result.setMessage(e.getMessage());
        }else if (e instanceof UpdateException){
            result.setState(301);
            result.setMessage(e.getMessage());
        }else if (e instanceof PageSelectException){
            result.setState(401);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
