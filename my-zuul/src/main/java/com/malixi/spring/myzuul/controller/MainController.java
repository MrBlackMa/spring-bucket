package com.malixi.spring.myzuul.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.malixi.spring.myzuul.mapper.MyUserServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/24 - 1:47
 * @Description: com.malixi.spring.myzuul.controller
 * @version: 1.0
 */
@Controller
public class MainController {

    @Autowired
    private MyUserServiceMapper myUserServiceMapper;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }


    @RequestMapping("/UserNpError")
    public String UserNpError(){
        System.out.println("进入了该方法");
        return "UserNpError";
    }

    @Autowired
    Producer captchaProducer;

    @GetMapping("/kaptcha/getImg")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();


        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
