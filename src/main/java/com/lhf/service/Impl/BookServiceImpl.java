package com.lhf.service.Impl;

import com.lhf.controller.Code;
import com.lhf.dao.BookDao;
import com.lhf.domain.Book;
import com.lhf.exception.BusinessException;
import com.lhf.exception.SystemException;
import com.lhf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        bookDao.save(book);
        return true;
    }

    @Override
    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    @Override
    public Book getById(Integer id) {
        //将可能出现的异常进行包装，转换成自定义异常
        if(id == 1){
            throw new BusinessException(Code.BUSINESS_ERR,"请不要乱尝试");
        }
        try{
            int i = 1/0;
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_ERR,"一个系统上面的异常错误");
        }
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
