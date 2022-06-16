package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("category")
@ApiModel(value = "Category对象", description = "")
@Data
public class Category {

        private int id;
        private String categoryName;
}
