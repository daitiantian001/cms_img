package oos.lmnml.com.img.controller.qiniu;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import oos.lmnml.com.img.common.Config;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daitian on 2017/7/21.
 */
@RestController
public class SimpleUp {

    @GetMapping("token")
    public Map simpleUp(){
        Auth auth =Auth.create(Config.QN_AK,Config.QN_SK);
        Map map = new HashMap<>();
        map.put("uptoken",auth.uploadToken(Config.QN_BK));
        return map;
    }
}
