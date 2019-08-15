package cn.sz.lgh.service;

import cn.sz.lgh.Exception.BalanceLessException;
import cn.sz.lgh.Exception.StoreHouseLessException;

import java.util.HashMap;

public interface InterStoreHouseService {

    public Integer selectcountBybookid(Integer bookid);

    public Boolean updateBookCountAndBalance(Integer bookid, Integer booknum,Integer accid,Double bookPrice) throws BalanceLessException, StoreHouseLessException;

    public Double selectAccountbyAccid(Integer moneyAccount);
}
