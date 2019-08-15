package cn.sz.lgh.service;

import cn.sz.lgh.Exception.BalanceLessException;
import cn.sz.lgh.Exception.StoreHouseLessException;
import cn.sz.lgh.dao.InterAccountDao;
import cn.sz.lgh.dao.InterStoreHouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;


@Service
public class StoreHouseService implements InterStoreHouseService {

    @Autowired
    private InterStoreHouseDao interStoreHouseDao;

    @Autowired

    private InterAccountDao interAccountDao;


    public Integer selectcountBybookid(Integer bookid) {


        Integer bookcount = interStoreHouseDao.selectcountBybookid(bookid);

        return bookcount;
    }

    public Double selectAccountbyAccid(Integer accid){
        Double aDouble = interAccountDao.selectAccountbyAccid(accid);
        return aDouble;
    }
    @Transactional(isolation= Isolation.READ_COMMITTED,propagation= Propagation.REQUIRED,rollbackFor={StoreHouseLessException.class, BalanceLessException.class},readOnly=false,timeout=20)
    public Boolean updateBookCountAndBalance(Integer bookid, Integer booknum,Integer accid,Double bookPrice) throws BalanceLessException, StoreHouseLessException {

        /*获取账户的金钱*/
        Double nowbalance = this.selectAccountbyAccid(accid);


        /*获取现有的图书数量*/
        Integer lastbookcount = this.selectcountBybookid(bookid);
        /*修改账户金钱*/

        Double balance=nowbalance-bookPrice*booknum;
        if (balance<=0){
            throw new BalanceLessException("账户余额不足");

        }
        HashMap<String, Object> updateAccountmap = new HashMap<String, Object>();
        updateAccountmap.put("balance",balance);
        updateAccountmap.put("accid",accid);
        interAccountDao.updateAccountByAccid(updateAccountmap);


        Integer book_count=lastbookcount-booknum;
        if (book_count<0){
            throw new StoreHouseLessException("库存数量不足");

        }


        HashMap<String, Object> updateconuntmap =new HashMap<String,Object>();
        updateconuntmap.put("book_count",book_count);
        updateconuntmap.put("bookid",bookid);
        interStoreHouseDao.updatecountBybookid(updateconuntmap);



        return false;

    }

}
