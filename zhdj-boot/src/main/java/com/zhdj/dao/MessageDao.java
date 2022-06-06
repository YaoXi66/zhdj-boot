package com.zhdj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhdj.bean.Book;
import com.zhdj.bean.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageDao extends BaseMapper<Message> {

}
