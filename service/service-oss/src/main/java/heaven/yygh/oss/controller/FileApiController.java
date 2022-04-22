package heaven.yygh.oss.controller;

import heaven.yygh.common.result.Result;
import heaven.yygh.oss.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 19:50 2022/4/17
 * @Modified By:
 */
@RestController
@RequestMapping("/api/oss/file")
public class FileApiController {
    @Autowired
    private FileService fileService;
    //上传文件到阿里云oss
    @PostMapping("fileUpload")
    public Result fileUpload(MultipartFile file) {
        //获取上传文件
        String url = fileService.upload(file);
        return Result.ok(url);
    }
}
