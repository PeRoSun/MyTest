INSERT INTO sys_user(id,username,password,nickname,email,phone,address,create_time,avatar_url,role) VALUES (1, 'admin', 'admin', '阿聪', 'admin@qq.com', '13988997788', '海南海口', '2022-01-22 21:10:27', 'http://localhost:9090/file/8d966b0e6cf84fe191a72a58b8293b23.png', 'ROLE_ADMIN');
INSERT INTO sys_user(id,username,password,nickname,email,phone,address,create_time,avatar_url,role) VALUES (16, 'zxt', '123', '钟显涛', '166555666@qq.com', '15267895533', '北京周家口', '2022-02-26 22:10:14', NULL, 'ROLE_TEACHER');
INSERT INTO sys_user(id,username,password,nickname,email,phone,address,create_time,avatar_url,role) VALUES (18, 'wzz', '123', '王志忠', '165559966@qq.com', '15266456533', '河北石家庄', '2022-02-26 22:10:14', NULL, 'ROLE_STUDENT');
INSERT INTO sys_user(id,username,password,nickname,email,phone,address,create_time,avatar_url,role) VALUES (19, 'ww2', '123', '王文', '166557766@qq.com', '13566335533', '河南郑州', '2022-02-26 22:10:14', NULL, 'ROLE_TEACHER');




INSERT INTO sys_role(id,name,description,flag) VALUES (1, '管理员', '管理员', 'ROLE_ADMIN');
INSERT INTO sys_role(id,name,description,flag) VALUES (2, '学生', '学生', 'ROLE_STUDENT');
INSERT INTO sys_role(id,name,description,flag) VALUES (3, '老师', '老师', 'ROLE_TEACHER');




INSERT INTO sys_menu(id,name,path,icon,description,pid,page_path,sort_num) VALUES (4, '系统管理', NULL, 'el-icon-s-grid', NULL, NULL, NULL, 300);
INSERT INTO sys_menu(id,name,path,icon,description,pid,page_path,sort_num) VALUES (5, '用户管理', '/user', 'el-icon-user', NULL, 4, 'User', 301);
INSERT INTO sys_menu(id,name,path,icon,description,pid,page_path,sort_num) VALUES (6, '角色管理', '/role', 'el-icon-s-custom', NULL, 4, 'Role', 302);
INSERT INTO sys_menu(id,name,path,icon,description,pid,page_path,sort_num) VALUES (7, '菜单管理', '/menu', 'el-icon-menu', NULL, 4, 'Menu', 303);
INSERT INTO sys_menu(id,name,path,icon,description,pid,page_path,sort_num) VALUES (10, '主页', '/home', 'el-icon-menu', NULL, NULL, 'Home', 0);
-- INSERT INTO sys_menu(id,name,path,icon,description,pid,page_path,sort_num) VALUES (10, '图书管理', '/bookInfo', 'el-icon-menu', NULL, NULL, 'BookInfo', 0);


INSERT INTO sys_role_menu(role_id,menu_id) VALUES (1, 2);
INSERT INTO sys_role_menu(role_id,menu_id) VALUES (1, 4);
INSERT INTO sys_role_menu(role_id,menu_id) VALUES (1, 5);
INSERT INTO sys_role_menu(role_id,menu_id) VALUES (1, 6);
INSERT INTO sys_role_menu(role_id,menu_id) VALUES (1, 7);
INSERT INTO sys_role_menu(role_id,menu_id) VALUES (1, 8);
INSERT INTO sys_role_menu(role_id,menu_id) VALUES (1, 9);
INSERT INTO sys_role_menu(role_id,menu_id) VALUES (1, 10);
INSERT INTO sys_role_menu(role_id,menu_id) VALUES (1, 39);
INSERT INTO sys_role_menu(role_id,menu_id) VALUES (1, 40);



INSERT INTO course(id,name,time,teacher_id) VALUES (1,'格林童话',2022-12-11,'16');
INSERT INTO course(id,name,time,teacher_id) VALUES (2,'安徒生童话',2022-01-11,'19');



INSERT INTO student_course(student_id,course_id) VALUES (18, '1');
INSERT INTO student_course(student_id,course_id) VALUES (18, '2');


-- INSERT INTO book(id,category_id,book_name,author,publisher,publish_date,unit_price,img_url,summary,all_num,tags,last_num,status) VALUES ('9782511360809', 1, '流浪地球', '刘慈欣', '中国华侨出版社', '2016-06-23 16:17:01', 38.00, 's28780375.jpg', '在太阳灭亡的瞬间，一切都平息了，每个人怀揣着恐惧和希望踏上漫长的流浪之旅……', 4, '流浪;科幻', 3, 1);
-- INSERT INTO book(id,category_id,book_name,author,publisher,publish_date,unit_price,img_url,summary,all_num,tags,last_num,status) VALUES ('97875440878', 1, '解忧杂货店', '[日] 东野圭吾', '南海出版公司', '2014-05-01 10:40:31', 39.50, 's2726411.jpg', '现代人内心流失的东西，这家杂货店能帮你找回——', 2, '治愈', 2, 0);

INSERT INTO category(id,category_name) VALUES (1, '文学小说');


INSERT INTO borrow_book(id,isbn,reader_id,borrow_date,return_date,fine,status) VALUES (00000000001, '9787511360809', 1, '2019-04-18 13:57:01', '2019-06-17 13:57:01', 0, 0);
INSERT INTO borrow_book(id,isbn,reader_id,borrow_date,return_date,fine,status) VALUES (00000000002, '9787511360809', 1, '2019-04-18 13:59:52', '2019-06-17 13:59:52', 0, 0);


INSERT INTO sys_file(id,name,type,size,url,md5,is_delete,enable) VALUES (17, '649002da71c8473db39892b4a758f875.png', 'png', 634, 'http://localhost:9090/file/8d966b0e6cf84fe191a72a58b8293b23.png', 'e1a9407cd0e937c4b411a93b7aca7c87', 1, 0);
INSERT INTO sys_file(id,name,type,size,url,md5,is_delete,enable)  VALUES (18, '1641024983532cf.png', 'png', 634, 'http://localhost:9090/file/8d966b0e6cf84fe191a72a58b8293b23.png', 'e1a9407cd0e937c4b411a93b7aca7c87', 1, 0);


INSERT INTO sys_dict(name,matter,type) VALUES ('user', 'el-icon-user', 'icon');
INSERT INTO sys_dict(name,matter,type) VALUES ('house', 'el-icon-house', 'icon');
INSERT INTO sys_dict(name,matter,type) VALUES ('menu', 'el-icon-menu', 'icon');
INSERT INTO sys_dict(name,matter,type) VALUES ('s-custom', 'el-icon-s-custom', 'icon');
INSERT INTO sys_dict(name,matter,type) VALUES ('s-grid', 'el-icon-s-grid', 'icon');
INSERT INTO sys_dict(name,matter,type) VALUES ('document', 'el-icon-document', 'icon');
INSERT INTO sys_dict(name,matter,type) VALUES ('coffee', 'el-icon-coffee\r\n', 'icon');
INSERT INTO sys_dict(name,matter,type) VALUES ('s-marketing', 'el-icon-s-marketing', 'icon')
