package com.zhdj.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("heartfeltwishes")
public class Communication {

    private int user_id;

    private String time ;

    private String content;

    private int id;

//    private String msg;

}
