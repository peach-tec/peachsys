package com.dyh.peachsys.xizudemo.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Peach-華
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2020/6/30-14:47
 * @address 成都
 */
@Data
public class TopicVO {
    private String title;
    private MultipartFile file;
    private String content;
}
