package com.zhdj.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
    @TableField(value = "pass")
    private String password;

    private String email;

    private String sex;

    private Integer grade_id;

    private String bg_img ;

    private String header_img ;

}
