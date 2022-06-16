package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Book;
import com.example.demo.entity.Reader;
import com.example.demo.mapper.ReaderMapper;
import com.example.demo.service.IReaderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

@Service
public class ReaderServiceImpl implements IReaderService {

    @Resource
    private ReaderMapper readerMapper;

    @Override
    public Reader getReader(int id) {
        return readerMapper.getReader(id);
    }

    @Override
    public void updateReader(Reader reader) {
        readerMapper.updateReader(reader);
    }

    @Override
    public ArrayList<Reader> getReaders(int curPage,int pageSize) {
        return readerMapper.getReaders(curPage,pageSize);
    }
//
//    @Override
//    public boolean saveBatch(Collection<Book> entityList, int batchSize) {
//        return false;
//    }
//
//    @Override
//    public boolean saveOrUpdateBatch(Collection<Book> entityList, int batchSize) {
//        return false;
//    }
//
//    @Override
//    public boolean updateBatchById(Collection<Book> entityList, int batchSize) {
//        return false;
//    }
//
//    @Override
//    public boolean saveOrUpdate(Book entity) {
//        return false;
//    }
//
//    @Override
//    public Book getOne(Wrapper<Book> queryWrapper, boolean throwEx) {
//        return null;
//    }
//
//    @Override
//    public Map<String, Object> getMap(Wrapper<Book> queryWrapper) {
//        return null;
//    }
//
//    @Override
//    public <V> V getObj(Wrapper<Book> queryWrapper, Function<? super Object, V> mapper) {
//        return null;
//    }
//
//    @Override
//    public BaseMapper<Book> getBaseMapper() {
//        return null;
//    }
//
//    @Override
//    public Class<Book> getEntityClass() {
//        return null;
//    }
}
