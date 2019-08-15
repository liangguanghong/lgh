package cn.sz.lgh.service;

import cn.sz.lgh.pojo.Book;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface InterBookService {
    public List<Book> selectbookinfo();
    public Book selectbookinfoByid(Integer bookid);
    public List<Book> selectBookByPage(Integer pageNum, Integer pageSize, Map<String ,Object> map);
    public Boolean addbook(Book book);
    public Boolean deletebook(Integer bookid);


}
