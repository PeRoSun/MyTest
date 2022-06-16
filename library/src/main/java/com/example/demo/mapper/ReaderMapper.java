package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Reader;

import java.util.ArrayList;

public interface ReaderMapper extends BaseMapper<Reader> {

    Reader getReader(int id);
    void updateReader(Reader reader);
    ArrayList<Reader> getReaders(int curPage, int pageSize);
}