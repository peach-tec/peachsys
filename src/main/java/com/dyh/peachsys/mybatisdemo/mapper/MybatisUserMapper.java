package com.dyh.peachsys.mybatisdemo.mapper;

import com.dyh.peachsys.mybatisdemo.entity.MybatisUser;

import java.util.List;
import java.util.Map;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/12-20:38
 * @address 成都
 */
public interface MybatisUserMapper {
    /**
     * 获取所有数据
     * @return
     */
    List<MybatisUser> getList();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    MybatisUser getUser(int id);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(MybatisUser user);

    /**
     * 修改
     * @param email
     * @param id
     */
    void updateUser(String email,Integer id);

    /**
     * 删除
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 通过map传入参数，适合参数太多的情况
     * @param params
     */
    void addUser2(Map<String, Object> params);


}
