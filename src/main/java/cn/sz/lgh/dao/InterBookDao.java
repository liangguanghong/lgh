package cn.sz.lgh.dao;

import cn.sz.lgh.pojo.Book;

import java.util.List;
import java.util.Map;

public interface InterBookDao {
    //查询所有的书信息
    public List<Book> selectbookinfo();
    //查询书的详细信息
    public Book selectbookinfoByid(Integer bookid);
    //根据条件查询,所有书的信息
    public List<Book> selectbookinfosplit(Map<String ,Object> map);
    //增加书的种类
    public void addbook(Book book);
    //删除书的种类
    public void deletebook(Integer bookid);
}
