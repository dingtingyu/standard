package com.example.standard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageGet {

    public static void main(String[] args) {
        String str = "设备名-故障内容";
        String[] split = str.split("-");
        System.out.println(split[0]+"   2："+split[1]+"  length:"+split.length);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/getImageMsg")
    public String[] getImageMsg(MultipartFile image){
        System.out.println(image.getOriginalFilename());
        String imgName = image.getOriginalFilename();
        System.out.println(imgName);
        String[] split = imgName.split("-");
        return split;
    }

}
