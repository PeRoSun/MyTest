DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id int NOT NULL ,
    username varchar(50),
    password varchar(50),
    nickname varchar(50),
    email varchar(50),
    phone varchar(20),
    address varchar(255),
    create_time timestamp,
    avatar_url varchar(255),
    role varchar(50),
    type int,
    status int,
    PRIMARY KEY (id)
);



DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
    id int NOT NULL,
    name varchar(50),
    description varchar(255),
    flag varchar(50),
    PRIMARY KEY (id)
);



DROP TABLE IF EXISTS sys_menu;
CREATE TABLE `sys_menu`
(
    id int NOT NULL,
    name varchar(255),
    path varchar(255),
    icon varchar(255),
    description varchar(255),
    pid int,
    page_path varchar(255),
    sort_num int,
    PRIMARY KEY (id)
);



DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE `sys_role_menu`
(
    role_id int NOT NULL,
    menu_id int NOT NULL,
    PRIMARY KEY (`role_id`, `menu_id`)
);



DROP TABLE IF EXISTS course;
CREATE TABLE course
(
    id int NOT NULL,
    name varchar(50),
    time varchar(50),
    teacher_id varchar(20),
    PRIMARY KEY (id)
);



DROP TABLE IF EXISTS student_course;
CREATE TABLE student_course
(
    student_id int NOT NULL,
    course_id varchar(50),
    PRIMARY KEY (`student_id`, `course_id`)
);


DROP TABLE IF EXISTS book;
CREATE TABLE book
(
    isbn int NOT NULL,
    category_id int,
    book_name varchar(255),
    author varchar(32),
    publisher varchar(32),
    publish_date datetime(0),
    unit_price decimal(10, 2),
    img_url varchar(255),
    summary text,
    all_num int,
    tags varchar(255),
    last_num int,
    status int,
    PRIMARY KEY (isbn)
);


DROP TABLE IF EXISTS category;
CREATE TABLE category
(
    id int NOT NULL,
    category_name varchar(32),
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS borrow_book;
CREATE TABLE borrow_book  (
    id int NOT NULL,
    isbn varchar(32),
    reader_id int,
    borrow_date datetime(0),
    return_date datetime(0),
    fine decimal(10, 0),
    status int,
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS reader;
CREATE TABLE reader
(
    id int NOT NULL,
    name varchar(16),
    age int,
    sex int,
    phone varchar(11),
    regdate datetime(0),
    level int,
    PRIMARY KEY (id)
);



DROP TABLE IF EXISTS sys_file;
CREATE TABLE sys_file
(
    id int NOT NULL,
    name varchar(255),
    type varchar(255),
    size bigint,
    url varchar(255),
    md5 varchar(255),
    is_delete tinyint,
    enable tinyint,
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS sys_dict;
CREATE TABLE sys_dict
(
    name   varchar(255),
    matter varchar(255),
    type   varchar(255)
)

