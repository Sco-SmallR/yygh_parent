package heaven.yygh.cmn.service;


import com.baomidou.mybatisplus.extension.service.IService;
import heaven.yygh.model.cmn.Dict;
import heaven.yygh.model.hosp.HospitalSet;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 22:37 2022/3/29
 * @Modified By:
 */
public interface DictService extends IService<Dict> {
    //根据数据id查询子数据列表
    List<Dict> findChlidData(Long id);

    void exportData(HttpServletResponse response);

    void importData(MultipartFile file);
}
