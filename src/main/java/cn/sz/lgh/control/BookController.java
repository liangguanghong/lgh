package cn.sz.lgh.control;

import cn.sz.lgh.pojo.Book;
import cn.sz.lgh.pojo.Users;
import cn.sz.lgh.service.InterBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/bc")
public class BookController {

    @Autowired
    private InterBookService bookService;

    /**
     * 根据页面的信息来查询对应的数据
     * @param request
     * @param bookDept 书的出版社
     * @param hisal 书的最高价格
     * @param lowsal 书的最低价格
     * @param bookName 书名
     * @param pagenow 页面的当前页
     * @param pagerow 每页显示多少行
     * @return
     */

    @RequestMapping(value = "tobook")
    public String tolistbook(HttpServletRequest request, String bookDept, String hisal, String lowsal,
                             String bookName, Integer pagenow, Integer pagerow) {

        HashMap<String, Object> map = new HashMap<String, Object>();

        //书名存在就传递书名
        if (bookName != null && !bookName.equals("")) {
            System.out.println(bookName);
            map.put("bookName", bookName);
        }
        //书的出版社不是全部,就传递书的出版社
        if (bookDept != null && !bookDept.equals("全部")) {
            map.put("kw", bookDept);
        }
        //书的最高价格存在,就传递书的最高价格
        if (hisal != null && !hisal.equals("")) {
            Double dhisal = Double.valueOf(hisal);
            map.put("hisal", dhisal);
        }
        //书的最低价格存在,就传递书的最低价格
        if (lowsal != null && !lowsal.equals("")) {
            Double dlowsal = Double.valueOf(lowsal);
            map.put("lowsal", dlowsal);
        }
        //页面没有传递当前页,默认页面为1
        if (pagenow == null) {
            pagenow = 1;
        }
        //页面没有传递每页多少行,默认每页9行
        if (pagerow == null) {
            pagerow = 9;
        }

        //查询符合条件的书
        List<Book> books = bookService.selectBookByPage(pagenow, pagerow, map);
        //把页面需要的信息传递
        request.setAttribute("books", books);
        request.setAttribute("pagenow", pagenow);
        request.setAttribute("pagerow",pagerow);

        return "book";
    }

    /**
     * 通过bookid查询book的信息
     * @param request
     * @return
     */
    @RequestMapping(value = "tobookinfo")
    public String tobookinfo(HttpServletRequest request) {

        Integer bookid = Integer.valueOf(request.getParameter("bookid"));

        Book book = bookService.selectbookinfoByid(bookid);
        //查询的书的信息传递到页面
        request.setAttribute("book", book);
        return "bookinfo";
    }

    /**
     *
     * @param book 可以封装book
     * @param request 在spring框架里面可以通过request.getparameter();
     * @param pic 获取multipart/form-date的数据
     * @param flag 传递到页面的值,显示数据
     * @return
     */
    @RequestMapping(value = "tobookadd")
    public String tobookadd(Book book, HttpServletRequest request, MultipartFile pic, String flag) {
        //可以获取文件的名字
        String originalFilename = pic.getOriginalFilename();
        //通过判断文件名字是否存在
        if (!pic.getOriginalFilename().equals("")) {
            System.out.println("文件：" + pic.getOriginalFilename());

            try {
                InputStream inputStream = pic.getInputStream();
                //根据文件名字通过application获取对应的地址
                String path = request.getSession().getServletContext().getRealPath("/file");
                System.out.println(path);
                String newfilename = UUID.randomUUID().toString();
                //从后面开始截取,包括.
                String endname = pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
                //把文件转换成2进制
                FileOutputStream fileOutputStream = new FileOutputStream(new File(path + "/" + newfilename + endname));
                FileCopyUtils.copy(inputStream, fileOutputStream);
                book.setImgPath("file/" + newfilename + endname);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //根据flag来判断页面显示的内容
        request.setAttribute("flag", flag);
        System.out.println("flag"+flag);

        Boolean addbook = bookService.addbook(book);
        //跳转书本详情页
        return "bookinfo";
    }

    /**
     * 根据bookid删除数据
     * @param bookid 书的id
     * @return
     */
    @RequestMapping(value = "deletebook")
    public String deletebook(Integer bookid) {

        bookService.deletebook(bookid);
        //转发到跳转book的controller
        return "forward:tobook";
    }

    /**
     *
     * 根据书的id查询跳转到支付页
     * @param bookid
     * @param request
     * @return
     */
    @RequestMapping(value = "topay")
    public ModelAndView topay(Integer bookid,HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookService.selectbookinfoByid(bookid);
        modelAndView.addObject("book",book);

        //Users attribute = (Users)request.getSession().getAttribute("myuser");


        modelAndView.setViewName("pay");
        return modelAndView;
    }
}