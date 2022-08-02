package cn.luischen.service.user.impl;

import cn.luischen.constant.ErrorConstant;
import cn.luischen.dao.UserDaoMapper;
import cn.luischen.exception.BusinessException;
import cn.luischen.interceptor.BaseInterceptor;
import cn.luischen.model.UserDomain;
import cn.luischen.service.user.UserService;
import cn.luischen.utils.TaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by winterchen on 2018/4/20.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGE = LoggerFactory.getLogger(BaseInterceptor.class);

    @Resource
    private UserDaoMapper userDaoMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateUserInfo(UserDomain user) {
        if (null == user.getUid()){
            throw BusinessException.withErrorCode("用户编号不可能为空");
        }
        return userDaoMapper.updateUserInfo(user);
    }

    @Override
    public UserDomain getUserInfoById(Integer uId) {
        return userDaoMapper.getUserInfoById(uId);
    }

    @Override
    public UserDomain login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            throw BusinessException.withErrorCode(ErrorConstant.Auth.USERNAME_PASSWORD_IS_EMPTY);
        }

        String pwd = TaleUtils.MD5encode(username + password);
        LOGGE.info("pwd:{}",pwd);
        UserDomain user = userDaoMapper.getUserInfoByCond(username, pwd);
        if (null == user){
            throw BusinessException.withErrorCode(ErrorConstant.Auth.USERNAME_PASSWORD_ERROR);
        }

        return user;
    }


}
