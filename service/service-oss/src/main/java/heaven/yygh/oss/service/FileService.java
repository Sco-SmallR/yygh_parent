package heaven.yygh.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 19:50 2022/4/17
 * @Modified By:
 */
public interface FileService {
    //上传文件到阿里云oss
    String upload(MultipartFile file);
}

