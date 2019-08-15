package cn.sz.lgh.dao;

import cn.sz.lgh.pojo.Account;

import java.util.HashMap;
import java.util.List;

public interface InterAccountDao {
    //查询用户的所有账号
    public List<Account>accountByUserid(Integer userid);
    //查询账户金额通过账户id
    public Double selectAccountbyAccid(Integer accid);
    //修改账户金额
    public void updateAccountByAccid(HashMap<String,Object> map);



}
