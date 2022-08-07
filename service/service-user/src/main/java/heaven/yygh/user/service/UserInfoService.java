package heaven.yygh.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import heaven.yygh.model.user.UserInfo;
import heaven.yygh.vo.user.LoginVo;
import heaven.yygh.vo.user.UserAuthVo;
import heaven.yygh.vo.user.UserInfoQueryVo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: SmallRong
 * @Description:
 * @Date: Created in 10:10 2022/4/15
 * @Modified By:
 */

public interface UserInfoService extends IService<UserInfo> {
    Map<String, Object> loginUser(LoginVo loginVo);

    UserInfo selectWxInfoOpenId(String openId);

    void userAuth(Long userId, UserAuthVo userAuthVo);
    //用户列表（条件查询带分页）
    IPage<UserInfo> selectPage(Page<UserInfo> pageParam, UserInfoQueryVo userInfoQueryVo);

    /**
     * 用户锁定
     * @param userId
     * @param status 0：锁定 1：正常
     */
    void lock(Long userId, Integer status);

    Map<String, Object> show(Long userId);

    void approval(Long userId, Integer authStatus);

}

