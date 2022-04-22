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

    /**
     * 根据上级编码与值获取数据字典名称
     * @param parentDictCode
     * @param value
     * @return
     */
    String getNameByParentDictCodeAndValue(String parentDictCode, String value);

    List<Dict> findByDictCode(String dictCode);

}
