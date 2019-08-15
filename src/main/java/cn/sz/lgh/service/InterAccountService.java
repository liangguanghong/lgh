package cn.sz.lgh.service;

import cn.sz.lgh.pojo.Account;

import java.util.List;

public interface InterAccountService {
    public List<Account> accountByUserid(Integer userid);

    public Double selectAccountbyAccid(Integer accid);
}
