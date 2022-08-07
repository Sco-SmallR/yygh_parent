package heaven.yygh.common.exception;

import heaven.yygh.common.result.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 16:33 2022/3/31
 * @Modified By:
 */
@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    /**
     * 自定义异常处理方法
     *
     * @param e
     * @return
     */
    @ExceptionHandler(YyghException.class)
    @ResponseBody
    public Result error(YyghException e) {
        return Result.build(e.getCode(), e.getMessage());
    }
}

