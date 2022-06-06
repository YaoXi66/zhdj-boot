package com.zhdj.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    @TableId(type = IdType.AUTO)
    private  int id;
    private String name;
    private String number;
    private String man;
    private String link;
    private String time;

}
