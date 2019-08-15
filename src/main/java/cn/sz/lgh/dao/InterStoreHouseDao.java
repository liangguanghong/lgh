package cn.sz.lgh.dao;

import java.util.HashMap;

public interface InterStoreHouseDao {
    //通过bookid查询书的数量
    public Integer selectcountBybookid(Integer bookid);
    //通过bookid修改书的库存
    public void updatecountBybookid(HashMap<String,Object> map);
}
