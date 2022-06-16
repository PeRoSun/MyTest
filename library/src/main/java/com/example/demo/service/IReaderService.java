package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Book;
import com.example.demo.entity.BorrowBook;
import com.example.demo.entity.Category;
import com.example.demo.entity.Reader;

import java.util.ArrayList;


public interface IReaderService  {

    Reader getReader(int id);
    void updateReader(Reader reader);
    ArrayList<Reader> getReaders(int curPage,int pageSize);
}

