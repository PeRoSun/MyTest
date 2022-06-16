package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Reader;
import java.util.Date;


@Getter
@Setter
//@TableName("borrow_book")
//@ApiModel(value = "BorrowBook对象", description = "")
//@Data
public class BorrowBook {
    private int isbn;
    private Book book;
    private Reader reader;
    private Date borrowDate;
    private Date returnDate;
    private float fine=0;
    private int status=1;


}
