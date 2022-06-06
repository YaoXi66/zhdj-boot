package com.zhdj.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dynamic {
    @TableId(type = IdType.AUTO)
    private int id;

    private int user_id;

    private Timestamp time ;

    private String link;

    private int type;

//    @JSONField(name = "sub_title")
    private String title;

    private String preview;



}
