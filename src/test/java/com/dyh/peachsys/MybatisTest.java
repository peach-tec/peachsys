package com.dyh.peachsys;

import com.dyh.peachsys.mybatisdemo.entity.MybatisStudent;
import com.dyh.peachsys.mybatisdemo.entity.MybatisTeacher2;
import com.dyh.peachsys.mybatisdemo.entity.MybatisUser;
import com.dyh.peachsys.mybatisdemo.mapper.MybatisStudentMapper;
import com.dyh.peachsys.mybatisdemo.mapper.MybatisTeacherMapper2;
import com.dyh.peachsys.mybatisdemo.mapper.MybatisUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

/**
 * @author Peach-華
 * @version V1.0
 * @desc mybatis测试
 * @copyright &copy; DYH
 * @date 2020/6/12-22:07
 * @address 成都
 */
@SpringBootTest
public class MybatisTest {
    @Autowired
    private MybatisUserMapper userMapper;

    @Autowired
    private MybatisTeacherMapper2 teacherMapper;

    @Autowired
    private MybatisStudentMapper studentMapper;

    @Test
    public void teacherMapper() {
        List<MybatisTeacher2> list = teacherMapper.getList();
        for (MybatisTeacher2 teacher : list) {
            System.out.println(teacher);
        }
    }

    @Test
    public void teacherMapper2() {
        List<MybatisTeacher2> list = teacherMapper.getList2();
        for (MybatisTeacher2 teacher : list) {
            System.out.println(teacher);
        }
    }


    @Test
    public void studentMapper() {
        List<MybatisStudent> list = studentMapper.getStudentList();
        for (MybatisStudent student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void studentMapper2() {
        List<MybatisStudent> list = studentMapper.getStudentList2();
        for (MybatisStudent student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void addUser2() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("name", "星梦");
        params.put("age", 25);
        params.put("email", "1234567@163.com");
        userMapper.addUser2(params);
    }

    @Test
    public void deleteUser() {
        userMapper.deleteUser(6);
    }

    @Test
    public void updateUser() {
        userMapper.updateUser("147258@qq.com", 4);

    }

    @Test
    public void addUser() {
        userMapper.addUser(new MybatisUser(null, "华仔", 26, "163.com"));
    }

    @Test
    public void getUser() {
        System.out.println(userMapper.getUser(1));
    }

    @Test
    public void getList() {
        List<MybatisUser> list = userMapper.getList();
        for (MybatisUser user : list) {
            System.out.println(user);
        }
    }
}
