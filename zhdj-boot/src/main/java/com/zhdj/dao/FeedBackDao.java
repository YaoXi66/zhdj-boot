package com.zhdj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhdj.bean.Book;
import com.zhdj.bean.FeedBack;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedBackDao extends BaseMapper<FeedBack> {

}
