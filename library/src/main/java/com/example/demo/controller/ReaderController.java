package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.entity.Reader;
import com.example.demo.entity.User;
import com.example.demo.service.IReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ReaderController {

    @Autowired
    private IReaderService readerService;

    @RequestMapping(value = "/getReaderInfo",method = RequestMethod.GET)
    @ResponseBody
    public Result getReaderInfo(HttpSession session){
        User user=(User)session.getAttribute("USER_SESSION");
        Reader reader=readerService.getReader(user.getId());
        if(reader!=null){
            return Result.success(reader);
        }else{
            return Result.error("未找到该用户");
        }

    }

    @RequestMapping(value = "/updateReaderInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result updateReaderInfo(@RequestBody Reader reader, HttpSession session){
        User user=(User)session.getAttribute("USER_SESSION");
        reader.setId(user.getId());
        readerService.updateReader(reader);
        return Result.success();

    }
}
