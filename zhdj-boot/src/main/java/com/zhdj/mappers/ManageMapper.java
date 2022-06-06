package com.zhdj.mappers;


import com.zhdj.bean.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManageMapper {

    @Insert("INSERT INTO book (title, author, introduce,img_src) VALUES (#{title},#{author},#{introduce},#{img_src})")
    void insertBook(Book book);

//    @Insert("INSERT INTO dynamic (title, author, introduce,img_src) VALUES (#{title},#{author},#{introduce},#{img_src})")
//    void insertBook(Book book);

}
