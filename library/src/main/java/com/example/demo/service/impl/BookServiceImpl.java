package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Book;
import com.example.demo.entity.BorrowBook;
import com.example.demo.entity.Category;
import com.example.demo.entity.Reader;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.BorrowBookMapper;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cong
 * @since 2022-06-05
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Resource
    private BookMapper bookMapper;

    @Resource
    private BorrowBookMapper borrowBookMapper;
    @Override
    public ArrayList<Book> getBooks(int curPage, int pageSize, int mode) {
        if(mode==0){
            return  bookMapper.getAllBooks(curPage,pageSize);
        }
        return bookMapper.getBooks(curPage,pageSize);
    }

    @Override
    public Book getBook(String isbn) {
        return bookMapper.getBook(isbn);
    }

    @Override
    public void borrowBook(String isbn, int readerId) {
        BorrowBook item=new BorrowBook();
        Book book=new Book();
        book.setIsbn(isbn);

        item.setBook(book);

        Reader reader = new Reader();
        reader.setId(readerId);
//        item.setReader(reader);
        Date date = new Date();
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.HOUR, 1440);
        Date date1=nowTime.getTime();
        item.setBorrowDate(date);
        item.setReturnDate(date1);

        borrowBookMapper.insertBorrowBook(item);
        bookMapper.updateBookNum(isbn);
    }

    @Override
    public ArrayList<BorrowBook> getBorrowBooks(int id) {
        return borrowBookMapper.getBorrowBooks(id);
    }

    @Override
    public void returnBook(int id,String isbn, int readerId) {
        borrowBookMapper.updateBorrowBookStatus(id,readerId);
        bookMapper.updateBookNum2(isbn);
    }

    @Override
    public void enableBook(String isbn) {
        bookMapper.updateBookStatus(isbn,1);
    }

    @Override
    public void disableBook(String isbn) {
        bookMapper.updateBookStatus(isbn,0);
    }

    @Override
    public ArrayList<Category> getCategory() {
        return bookMapper.getCategory();
    }

    @Override
    public void addBook(Book book) {
        bookMapper.insertBook(book);
    }

    @Override
    public void updateBook(String originBook, Book book) {
        bookMapper.updateBook(originBook,book);
    }

}
