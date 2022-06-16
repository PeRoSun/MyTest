package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.entity.Book;
import com.example.demo.entity.BorrowBook;
import com.example.demo.entity.Category;
import com.example.demo.entity.User;
import com.example.demo.service.IBookService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Setter
public class BookController {
    @Autowired
    private IBookService bookService;

    @RequestMapping("/getBooks")
    @ResponseBody
    public Result getBooks(HttpServletRequest request, HttpSession session){
        //按页码返回书籍
        String curPage=request.getParameter("curPage");
        String pageSize=request.getParameter("pageSize");
        if(curPage==null){
            curPage="0";
        }
        if(pageSize==null){
            pageSize="24";
        }
        User user =(User) session.getAttribute("USER_SESSION");
        ArrayList<Book> books;
        if(user!=null&&user.getType()==0){
            books=bookService.getBooks(Integer.parseInt(curPage),Integer.parseInt(pageSize),0);
        }else{
            books=bookService.getBooks(Integer.parseInt(curPage),Integer.parseInt(pageSize),1);
        }

        return Result.success(books);
    }
    @RequestMapping("/getBookDetail")
    @ResponseBody
    public Result getBook(HttpServletRequest request, HttpSession session){
        //按页码返回书籍
        String isbn=request.getParameter("id");
        if(isbn==null){
            return Result.error("没有id");
        }else{
            Book book=bookService.getBook(isbn);
            return Result.success(book);
        }
    }

    @RequestMapping("/borrowBook")
    @ResponseBody
    public Result borrowBook(HttpServletRequest request, HttpSession session){
        //按isbn借阅图书
        User user =(User) session.getAttribute("USER_SESSION");
        String isbn=request.getParameter("isbn");
        if(isbn==null){
            return Result.error("没有isbn");
        }else{
            bookService.borrowBook(isbn,user.getId());
            return Result.success();
        }
    }
    @RequestMapping("/returnBook")
    @ResponseBody
    public Result returnBook(HttpServletRequest request, HttpSession session){
        //按isbn借阅图书
        User user =(User) session.getAttribute("USER_SESSION");
        String id=request.getParameter("id");
        String isbn=request.getParameter("isbn");
        if(id==null||isbn==null){
            return Result.error("未找到该条记录");
        }else{
            bookService.returnBook(Integer.parseInt(id),isbn,user.getId());
            return Result.success();
        }
    }
    @RequestMapping("/getBorrowBooks")
    @ResponseBody
    public Result getBorrowBooks( HttpSession session){
        User user =(User)session.getAttribute("USER_SESSION");
        try {
            ArrayList<BorrowBook> borrowBooks= bookService.getBorrowBooks(user.getId());
            return Result.success(borrowBooks);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return Result.error("出错");
    }


    @RequestMapping("/enableBook")
    @ResponseBody
    public Result enableBook(HttpServletRequest request, HttpSession session){
        //按isbn借阅图书
        User user =(User) session.getAttribute("USER_SESSION");
        String isbn = request.getParameter("isbn");

        if(isbn == null||user.getType()!=0){
            return Result.error("未找到该条记录");
        }else{
            bookService.enableBook(isbn);
            return Result.success();
        }
    }
    @RequestMapping("/disableBook")
    @ResponseBody
    public Result disableBook(HttpServletRequest request, HttpSession session) throws IllegalStateException,IOException {
        //按isbn借阅图书
        User user =(User) session.getAttribute("USER_SESSION");
        String isbn=request.getParameter("isbn");

        if(isbn == null||user.getType()!=0){
            return Result.error("未找到该条记录");
        }else{
            bookService.disableBook(isbn);
            return Result.success();
        }
    }
    @RequestMapping("/getCategory")
    @ResponseBody
    public Result getCategory(HttpServletRequest request, HttpSession session){
        //按isbn借阅图书
        User user = (User) session.getAttribute("USER_SESSION");
        ArrayList<Category> categories=bookService.getCategory();
        return Result.success(categories);

    }

//    //文件上传
//    @RequestMapping(value = "/api/book/uploadBook",method = RequestMethod.POST)
//    @ResponseBody
//    public Result uploadBook(HttpServletRequest request,@RequestParam(value="img", required = false) MultipartFile file)
//    {
////        String isbn=request.getParameter("isbn");
////        String categoryId=request.getParameter("categoryId");
////        String bookName=request.getParameter("bookName");
////        String author=request.getParameter("author");
////        String publisher=request.getParameter("publisher");
////        String publishDate=request.getParameter("publishDate");
////        String unitPrice=request.getParameter("unitPrice");
////        String summary=request.getParameter("summary");
////        int allNum=Integer.parseInt(request.getParameter("allNum"));
////        String imgUrl=file.getOriginalFilename();
////        String tags=request.getParameter("tags");
////        int status=1;
////        int lastNum=allNum;
////        Book book = new Book(isbn, Integer.parseInt(categoryId),"", bookName, author, publisher, new Date(publishDate),Float.parseFloat(unitPrice), imgUrl,summary, allNum, tags, lastNum, status);
////        bookService.addBook(book);
//
//
//        String path=request.getSession().getServletContext().getRealPath("/img/")+file.getOriginalFilename();
//        try{
//            file.transferTo(new File(path));
//        }catch (IOException ex){
//            ex.printStackTrace();
//            return Result.error("图片读取错误");
//        }finally {
//            return Result.success();
//        }


    @RequestMapping(value = "/updateBook",method = RequestMethod.POST)
    @ResponseBody
    public Result updateBook(HttpServletRequest request,@RequestParam(value="img", required = false) MultipartFile file)
    {
        String originIsbn=request.getParameter("oringnIsbn");
        String isbn=request.getParameter("isbn");
        String categoryId=request.getParameter("categoryId");
        String bookName=request.getParameter("bookName");
        String author=request.getParameter("author");
        String publisher=request.getParameter("publisher");

        String tmpDate=request.getParameter("publishDate");
        Date publishDate;
        publishDate = new Date(tmpDate);

        String unitPrice=request.getParameter("unitPrice");
        String summary=request.getParameter("summary");

        int allNum=Integer.parseInt(request.getParameter("allNum"));
//        String imgUrl=file.getOriginalFilename();
        String imgUrl="";
        if(file!=null)
        {
            imgUrl=file.getOriginalFilename();
        }
        String tags=request.getParameter("tags");
        int status=1;
        int lastNum=allNum;

        Book book = new Book();
//        Book book = new Book(isbn, Integer.parseInt(categoryId),"", bookName, author, publisher, publishDate,Float.parseFloat(unitPrice), imgUrl,summary, allNum, tags, lastNum, status);
        bookService.updateBook(originIsbn,book);

        if(file!=null){
            String path=request.getSession().getServletContext().getRealPath("/img/")+file.getOriginalFilename();
            try{
                file.transferTo(new File(path));
            }catch (IOException ex){
                ex.printStackTrace();
                return Result.error("图片读取错误");
            }finally {
                return Result.success();
            }
        }

        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Book book) {
        bookService.saveOrUpdate(book);
        return Result.success();
    }
}
