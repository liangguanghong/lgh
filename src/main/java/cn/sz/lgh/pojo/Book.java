package cn.sz.lgh.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private Integer bookid;
    private String bookName;
    private String bookDept;
    private Double bookPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicDate;
    private String bookAuth;
    private String imgPath;
    private String summary;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDept() {
        return bookDept;
    }

    public void setBookdept(String bookDept) {
        this.bookDept = bookDept;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }


    public String getBookAuth() {
        return bookAuth;
    }

    public void setBookDept(String bookDept) {
        this.bookDept = bookDept;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public void setBookAuth(String bookAuth) {
        this.bookAuth = bookAuth;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getSummary() {
        return summary;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookName='" + bookName + '\'' +
                ", bookDept='" + bookDept + '\'' +
                ", bookPrice=" + bookPrice +
                ", publicDate='" + publicDate + '\'' +
                ", bookAuth='" + bookAuth + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
