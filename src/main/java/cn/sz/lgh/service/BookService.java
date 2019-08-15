package cn.sz.lgh.service;

import cn.sz.lgh.dao.InterBookDao;
import cn.sz.lgh.pojo.Book;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService implements InterBookService {
    /*注入book的dao*/
    @Autowired
    private InterBookDao iBookDao;

    public Book selectbookinfoByid(Integer bookid) {
        return iBookDao.selectbookinfoByid(bookid);
    }

    public List<Book> selectbookinfo() {


        return iBookDao.selectbookinfo();
    }

    public Boolean deletebook(Integer bookid) {
        if (bookid==null){
            return false;
        }
        iBookDao.deletebook(bookid);
        return true;
    }

    public List<Book> selectBookByPage(Integer pageNum, Integer pageSize, Map<String ,Object> map){

            PageHelper.startPage(pageNum, pageSize);

            List<Book> books = iBookDao.selectbookinfosplit(map);
            if(books == null){
                return null;
            }
           PageInfo<Book> pageInfo = new PageInfo<Book>(books);
            List<Book> list = pageInfo.getList();

         return list;

    }

    public Boolean addbook(Book book) {
        if (book==null){
            return false;
        }
        iBookDao.addbook(book);
        return true;

    }
}

