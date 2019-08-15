package cn.sz.lgh.control;


import cn.sz.lgh.Exception.BalanceLessException;
import cn.sz.lgh.Exception.StoreHouseLessException;
import cn.sz.lgh.service.InterStoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/shc")
public class StoreHouseController {

    //注入对应的storeHouseService
    @Autowired
    private InterStoreHouseService storeHouseService;


    /**
     * 传递信息到service
     * @param bookid
     * @param booknum
     * @param accid
     * @param bookPrice
     * @return
     */
    @RequestMapping(value = "tobuybook")
    public String tobuybook(Integer bookid, Integer booknum,Integer accid,Double bookPrice){

        try {
            Boolean aBoolean = storeHouseService.updateBookCountAndBalance(bookid, booknum,accid,bookPrice);
        } catch (BalanceLessException e) {
            return "err";
        } catch (StoreHouseLessException e) {
            return "err";
        }

        return "suc";
    }
}
