package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Book;
import com.example.demo.entity.BorrowBook;
import com.example.demo.entity.Category;
import com.example.demo.entity.Menu;

import java.util.ArrayList;
import java.util.List;


public interface IBookService extends IService<Book> {

    ArrayList<Book> getBooks(int curPage, int pageSize, int mode);
    Book getBook(String isbn);
    void borrowBook(String isbn, int readerId);
    ArrayList<BorrowBook> getBorrowBooks(int id);
    void returnBook(int id,String isbn,int readerId);
    void disableBook(String isbn);
    void enableBook(String isbn);
    ArrayList<Category> getCategory();
    void addBook(Book book);
    void updateBook(String originBook,Book book);
}

