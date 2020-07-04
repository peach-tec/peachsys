package com.dyh.peachsys.xizudemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/30-14:14
 * @address 成都
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("xz_topic")
public class XZTopic implements Serializable {
//    @TableId
//    private Integer id;
    private String title;
    private String img;
    private String content;
}
