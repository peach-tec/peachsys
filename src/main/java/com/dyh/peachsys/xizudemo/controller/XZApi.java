package com.dyh.peachsys.xizudemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dyh.peachsys.peach.common.Res;
import com.dyh.peachsys.xizudemo.entity.XZTopic;
import com.dyh.peachsys.xizudemo.entity.XZUser;
import com.dyh.peachsys.xizudemo.service.IXZTopicService;
import com.dyh.peachsys.xizudemo.service.IXZUserService;
import com.dyh.peachsys.xizudemo.vo.LoginVO;
import com.dyh.peachsys.xizudemo.vo.RegisterVO;
import com.dyh.peachsys.xizudemo.vo.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/30-14:26
 * @address 成都
 */
@RestController
@RequestMapping("/xz/user")
public class XZApi {
    @Autowired
    private IXZUserService userService;
    @Autowired
    private IXZTopicService topicService;

    /**
     * 注册
     * @param vo
     * @return
     */
    @PostMapping("/register")
    public Res registerUser(RegisterVO vo) {
        //验证密码是否一致
        if (!vo.getPassword().equals(vo.getPassword1())) {
            return Res.fail("密码不一致", 1);
        }
        //根据手机号查询用户
        XZUser user = userService.getOne(new QueryWrapper<XZUser>().like("phone", vo.getPhone()));
        if (user != null) {
            return Res.fail("用户已经存在，请登录", 1);
        }
        //保存用户
        XZUser xzUser = new XZUser();
        xzUser.setPhone(vo.getPhone());
        xzUser.setPassword(vo.getPassword());
        xzUser.setInvitationCode(vo.getVCode());

        boolean save = userService.save(xzUser);
        if (save) {
            return Res.success();
        } else {
            return Res.fail("注册失败", 1);
        }
    }

    /**
     * 登录
     * @param vo
     * @return
     */
    @PostMapping("/login")
    public Res Login(LoginVO vo) {
        //查询用户
        XZUser user = userService.getOne(new QueryWrapper<XZUser>().like("phone", vo.getPhone()));
        if (user == null) {
            return Res.fail("登陆失败，用户不存在", 1);
        }
        if (!vo.getPassword().equals(user.getPassword())) {
            return Res.fail("登陆失败，密码不正确", 1);
        }
        return Res.success();
    }

    /**
     * 话题列表
     * @param start
     * @param limit
     * @return
     */
    @PostMapping("/topic/list")
    public Res topicList(@RequestParam("start") Integer start, @RequestParam("limit") Integer limit) {
        List<XZTopic> list = topicService.topicByPage(start, limit);
        return Res.success(list);
    }

    /**
     * 新增话题
     * @param vo
     * @return
     * @throws IOException
     */
    @PostMapping("/add/topic")
    public Res addTopic(TopicVO vo) throws IOException {
        //上传文件
        MultipartFile file = vo.getFile();
        String filePath = "G:/peachsys/";//文件保存地址
        File test = new File(filePath, file.getOriginalFilename());//文件示例，第一个参数是文件路径，第二个参数是文件名
        file.transferTo(test);//写入文件

        //保存话题
        XZTopic xzTopic = new XZTopic();
        xzTopic.setTitle(vo.getTitle());
        xzTopic.setContent(vo.getContent());
        xzTopic.setImg(filePath + file.getOriginalFilename());
        topicService.save(xzTopic);

        return Res.success();
    }

    /**
     * 根据id查询话题详情
     * @param id
     * @return
     */
    @PostMapping("/topic/info")
    public Res topicInfo(@RequestParam("id") Integer id) {
        XZTopic topic = topicService.getById(id);
        return Res.success(topic);
    }
}
