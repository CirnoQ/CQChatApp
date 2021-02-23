package com.cirnoq.controller;

import com.cirnoq.pojo.User;
import com.cirnoq.services.UserServices;
import com.cirnoq.utils.IWdzlJSONResult;
import com.cirnoq.utils.MD5Utils;
import com.cirnoq.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @RequestMapping("/registerOrLogin")
    @ResponseBody
    //用户登录与注册一体化方法
    public IWdzlJSONResult registerOrlogin(User user){//user为前端给出的用户信息
        User userResult=userServices.queryUserNameIsExist(user.getUsername());

        if(userResult!=null){//此用户存在,可以直接登录
            if(!userResult.getPassword().equals(MD5Utils.getPwd(user.getPassword()))){//判断前端密码加密后是否正确
                return  IWdzlJSONResult.errorMsg("密码不正确");
            }
        }else{//需要进行注册
            user.setNickname("张三");
            user.setQrcode("");
            user.setPassword(MD5Utils.getPwd(user.getPassword()));
            user.setFaceImage("");
            user.setFaceImageBig("");

            userResult = userServices.insert(user);
        }
        UserVo userVo=new UserVo();
        BeanUtils.copyProperties(userResult,userVo);
        return IWdzlJSONResult.ok(userVo);
    }

    @RequestMapping("/getUser")
    public String getUserById(String id, Model model) {
        User user=userServices.getUserById(id);
        model.addAttribute("user",user);
        return "test2";
    }
}
