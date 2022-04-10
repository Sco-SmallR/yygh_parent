package heaven.easyexcel;

import com.alibaba.excel.EasyExcel;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 21:10 2022/4/5
 * @Modified By:
 */
public class TestRead {
    public static void main(String[] args) {
        // 读取文件路径
        String fileName = "F:\\excel\\01.xlsx";
        EasyExcel.read(fileName,UserData.class,new ExcelListener()).sheet().doRead();

    }
}
