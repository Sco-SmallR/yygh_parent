package heaven.yygh.hosp.controller.api;


import heaven.yygh.common.exception.YyghException;
import heaven.yygh.common.result.Result;
import heaven.yygh.common.result.ResultCodeEnum;
import heaven.yygh.helper.HttpRequestHelper;
import heaven.yygh.hosp.service.DepartmentService;
import heaven.yygh.hosp.service.HospitalService;
import heaven.yygh.hosp.service.HospitalSetService;
import heaven.yygh.hosp.service.ScheduleService;
import heaven.yygh.model.hosp.Department;
import heaven.yygh.model.hosp.Hospital;
import heaven.yygh.model.hosp.Schedule;
import heaven.yygh.utils.MD5;
import heaven.yygh.vo.hosp.DepartmentQueryVo;
import heaven.yygh.vo.hosp.ScheduleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 22:04 2022/4/8
 * @Modified By:
 */

@Api(tags = "医院管理API接口")
@RestController
@RequestMapping("/api/hosp")
public class ApiController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HospitalSetService hospitalSetService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ScheduleService scheduleService;

    // 删除排班
    @ApiOperation(value = "删除科室")
    @PostMapping("schedule/remove")
    public Result removeSchedule(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
        //必须参数校验 略
        String hoscode = (String)paramMap.get("hoscode");
        //必填
        String hosScheduleId = (String)paramMap.get("hosScheduleId");
        if(StringUtils.isEmpty(hoscode)) {
            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
        }
//        //签名校验
//        if(!HttpRequestHelper.isSignEquals(paramMap, hospitalSetService.getSignKey(hoscode))) {
//            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
//        }

        scheduleService.remove(hoscode, hosScheduleId);
        return Result.ok();
    }


    // 上传排版接口
    @ApiOperation(value = "上传排班")
    @PostMapping("saveSchedule")
    public Result saveSchedule(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
        //必须参数校验 略
        String hoscode = (String) paramMap.get("hoscode");
        if (StringUtils.isEmpty(hoscode)) {
            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
        }
//        //签名校验
//        if (!HttpRequestHelper.isSignEquals(paramMap, hospitalSetService.getSignKey(hoscode))) {
//            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
//        }

        scheduleService.save(paramMap);
        return Result.ok();
    }
        // 查询排班接口
        @ApiOperation(value = "获取排班分页列表")
        @PostMapping("schedule/list")
        public Result schedule (HttpServletRequest request){
            Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
            //必须参数校验 略
            String hoscode = (String) paramMap.get("hoscode");
            //非必填
            String depcode = (String) paramMap.get("depcode");
            int page = StringUtils.isEmpty(paramMap.get("page")) ? 1 : Integer.parseInt((String) paramMap.get("page"));
            int limit = StringUtils.isEmpty(paramMap.get("limit")) ? 10 : Integer.parseInt((String) paramMap.get("limit"));

            if (StringUtils.isEmpty(hoscode)) {
                throw new YyghException(ResultCodeEnum.PARAM_ERROR);
            }
//        //签名校验
//        if (!HttpRequestHelper.isSignEquals(paramMap, hospitalSetService.getSignKey(hoscode))) {
//            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
//        }

            ScheduleQueryVo scheduleQueryVo = new ScheduleQueryVo();
            scheduleQueryVo.setHoscode(hoscode);
            scheduleQueryVo.setDepcode(depcode);
            Page<Schedule> pageModel = scheduleService.selectPage(page, limit, scheduleQueryVo);
            return Result.ok(pageModel);
        }


        // 删除科室

        @ApiOperation(value = "删除科室")
        @PostMapping("department/remove")
        public Result removeDepartment (HttpServletRequest request){
            Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
            //必须参数校验 略
            String hoscode = (String) paramMap.get("hoscode");
            //必填
            String depcode = (String) paramMap.get("depcode");
            if (StringUtils.isEmpty(hoscode)) {
                throw new YyghException(ResultCodeEnum.PARAM_ERROR);
            }
            //签名校验
            if (!HttpRequestHelper.isSignEquals(paramMap, hospitalSetService.getSignKey(hoscode))) {
                throw new YyghException(ResultCodeEnum.SIGN_ERROR);
            }

            departmentService.remove(hoscode, depcode);
            return Result.ok();
        }


        //查询科室接口
        @ApiOperation(value = "获取分页列表")
        @PostMapping("department/list")
        public Result finddepartment (HttpServletRequest request){
            Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
            //必须参数校验 略
            String hoscode = (String) paramMap.get("hoscode");
            // 医院编号
            String depcode = (String) paramMap.get("depcode");
            // 当前页 和 每页记录数
            int page = StringUtils.isEmpty(paramMap.get("page")) ? 1 : Integer.parseInt((String) paramMap.get("page"));
            int limit = StringUtils.isEmpty(paramMap.get("limit")) ? 10 : Integer.parseInt((String) paramMap.get("limit"));

            if (StringUtils.isEmpty(hoscode)) {
                throw new YyghException(ResultCodeEnum.PARAM_ERROR);
            }
            //签名校验（略）
//        if(!HttpRequestHelper.isSignEquals(paramMap, hospitalSetService.getSignKey(hoscode))) {
//            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
//        }

            DepartmentQueryVo departmentQueryVo = new DepartmentQueryVo();
            departmentQueryVo.setHoscode(hoscode);
            departmentQueryVo.setDepcode(depcode);
            Page<Department> pageModel = departmentService.selectPage(page, limit, departmentQueryVo);
            return Result.ok(pageModel);
        }

        // 上传科室接口（和上传医院类似）

        @ApiOperation(value = "上传科室")
        @PostMapping("saveDepartment")
        public Result saveDepartment (HttpServletRequest request){
            Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
            //必须参数校验 略
            // 1、获取医院系统中传递过来的签名
            String hospSign = (String) paramMap.get("sign");

            //2、根据传递过来的医院编码，查询数据库，查询签名
            String hoscode = (String) paramMap.get("hoscode");
            String signKey = hospitalSetService.getSignKey(hoscode);

            //3 把数据库查询的签名进行MD5加密
            String signKeyMd5 = MD5.encrypt(signKey);
            //4 判断签名是否一致
            if (!hospSign.equals(signKeyMd5)) {
                throw new YyghException(ResultCodeEnum.SIGN_ERROR);
            }

            departmentService.save(paramMap);
            return Result.ok();
        }


        //查询医院接口
        @ApiOperation(value = "获取医院信息")
        @PostMapping("hospital/show")
        public Result hospital (HttpServletRequest request){
            Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());

            //必须参数校验(和保存方法中一致)

            // 1、获取医院系统中传递过来的签名
            String hospSign = (String) paramMap.get("sign");

            //2、根据传递过来的医院编码，查询数据库，查询签名
            String hoscode = (String) paramMap.get("hoscode");
            String signKey = hospitalSetService.getSignKey(hoscode);

            //3 把数据库查询的签名进行MD5加密
            String signKeyMd5 = MD5.encrypt(signKey);
            //4 判断签名是否一致
            if (!hospSign.equals(signKeyMd5)) {
                throw new YyghException(ResultCodeEnum.SIGN_ERROR);
            }
            // 调用方法实现根据医院编号查询
            Hospital hospital = hospitalService.getByHoscode(hoscode);
            return Result.ok(hospital);
        }

        //上传医院接口
        @PostMapping("saveHospital")
        public Result saveHosp (HttpServletRequest request){
            //获取传递过来的医院信息
            Map<String, String[]> requestMap = request.getParameterMap();
            Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

            // 1、获取医院系统中传递过来的签名
            String hospSign = (String) paramMap.get("sign");

            //2、根据传递过来的医院编码，查询数据库，查询签名
            String hoscode = (String) paramMap.get("hoscode");
            String signKey = hospitalSetService.getSignKey(hoscode);

            //3 把数据库查询的签名进行MD5加密
            String signKeyMd5 = MD5.encrypt(signKey);
            //4 判断签名是否一致
            if (!hospSign.equals(signKeyMd5)) {
                throw new YyghException(ResultCodeEnum.SIGN_ERROR);
            }

            //传输过程中“+”转换为了“ ”，因此我们要转换回来
            String logoDataString = (String) paramMap.get("logoData");
            String logoData = logoDataString.replaceAll(" ", "+");
            paramMap.put("logoData", logoData);

            //调用service的方法
            hospitalService.save(paramMap);
            return Result.ok();
        }

    }

