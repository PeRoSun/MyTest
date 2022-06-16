package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName("book")
@ApiModel(value = "Book对象", description = "")
@Data
public class Book {
    private String isbn;
    private int categoryId;
    private String categoryName;
    private String bookName;
    private String author;
    private String publisher;
    private Date publishDate;
    private float unitPrice;
    private String imgUrl;
    private String summary;
    private int allNum;
    private String tags;
    private int lastNum;
    private int status=1;
}
