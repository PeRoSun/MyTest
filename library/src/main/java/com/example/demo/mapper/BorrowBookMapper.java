package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Book;
import com.example.demo.entity.BorrowBook;


import java.util.ArrayList;

public interface BorrowBookMapper extends BaseMapper<Book> {

    void insertBorrowBook(BorrowBook borrowBook);
    ArrayList<BorrowBook> getBorrowBooks(int id);
    void updateBorrowBookStatus(int id,int readerId);
}