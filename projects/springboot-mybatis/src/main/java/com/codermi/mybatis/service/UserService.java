package com.codermi.mybatis.service;

import com.codermi.mybatis.aspect.annotaion.LogAccess;
import com.codermi.mybatis.data.entity.User;
import com.codermi.mybatis.data.vo.UserVo;
import com.codermi.mybatis.mapper.UserMapper;
import com.codermi.mybatis.mapper.param.UserParam;
import com.codermi.mybatis.utils.Pagination;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author qiudm
 * @date 2018/12/12 14:34
 * @desc
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getByUserId(int userId) {
        return userMapper.getByUserId(userId);
    }


    @Transactional
    public int insert(String name) {
        User user = new User();
        user.setName(name);
        user.setCreateTime(new Date());
        userMapper.insert(user);
        return user.getUserId();
    }

    @LogAccess(remark = "获取用户列表")
    public Pagination<UserVo> getUserList(int pageNum, int pageSize) {
        Pagination<UserVo> pagination = new Pagination<>(pageNum, pageSize);

        Page<User> pageUserInfo = PageHelper
                .startPage(pageNum, pageSize).doSelectPage(() -> userMapper.getUserList());


        if (!CollectionUtils.isEmpty(pageUserInfo)) {
            pagination.setTotal(pageUserInfo.getTotal());
            List<UserVo> userVoList = Lists.newArrayList();
            for (User user : pageUserInfo) {
                UserVo userVo = new UserVo();
                BeanUtils.copyProperties(user, userVo);
                userVoList.add(userVo);
            }
            pagination.setDataList(userVoList);
        }

        return pagination;
    }


    public List<User> findByCondition() {
        UserParam userParam = new UserParam();
        userParam.setName("qdm");
        userParam.setUserId(100001);
        List<User> byCondition = null;
        for(int i=0;i <100;i++) {
            byCondition = userMapper.findByCondition(userParam);
        }

        return byCondition;
    }


    public void updateUserName(int userId, String name){
        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        userMapper.update(user);
    }



}
