package com.sky.controller.admin;


import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/admin/common")
@Slf4j
@Api(tags = "公共文件上传")
public class CommonController {

    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file){
        log.info("文件上传：{}", file);
        try {
            file.transferTo(new File("D:/images/" + file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success("D:/images/" + file.getOriginalFilename());



    }


}
