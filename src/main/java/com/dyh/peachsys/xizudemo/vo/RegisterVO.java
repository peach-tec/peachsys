package com.dyh.peachsys.xizudemo.vo;

import lombok.Data;

/**
 * @author Peach-華
 * @version V1.0
 * @desc    注册表单
 * @copyright &copy; DYH
 * @date 2020/6/30-14:16
 * @address 成都
 */
@Data
public class RegisterVO {
    private String phone;
    private String password;
    private String password1;
    private String vCode;//验证码
    private String iCode;//邀请码
}
