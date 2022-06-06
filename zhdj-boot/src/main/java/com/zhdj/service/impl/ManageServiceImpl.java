package com.zhdj.service.impl;

import com.zhdj.bean.Book;
import com.zhdj.mappers.ManageMapper;
import com.zhdj.service.ManageService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@MapperScan(value = "com.zhdj.dao")
public class ManageServiceImpl implements ManageService {
    @Resource
    private ManageMapper manageMapper;

    @Override
    public void insertBook(Book book) {
        manageMapper.insertBook(book);
    }
}
