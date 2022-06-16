package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Book;
import com.example.demo.entity.Category;

import java.util.ArrayList;

public interface BookMapper extends BaseMapper<Book> {

    ArrayList<Book> getBooks(int curPage, int pageSize);
    ArrayList<Book> getAllBooks(int curPage,int pageSize);
    Book getBook(String id);
    void updateBookNum(String isbn);
    void updateBookNum2(String isbn);
    void updateBookStatus(String isbn,int status);
    ArrayList<Category> getCategory();
    void insertBook(Book book);
    void updateBook(String originIsbn,Book book);
}