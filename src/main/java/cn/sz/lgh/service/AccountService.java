package cn.sz.lgh.service;

import cn.sz.lgh.dao.InterAccountDao;
import cn.sz.lgh.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class AccountService implements InterAccountService {


    @Autowired
    private InterAccountDao interAccountDao;

    public List<Account> accountByUserid(Integer userid) {
        List<Account> accounts = interAccountDao.accountByUserid(userid);
        return accounts ;
    }

    public Double selectAccountbyAccid(Integer accid) {
        Double aDouble = interAccountDao.selectAccountbyAccid(accid);
        return aDouble;
    }
}
