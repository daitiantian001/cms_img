package oos.lmnml.com.img.controller.redis;

import oos.lmnml.com.img.common.Config;
import oos.lmnml.com.img.entity.ImgInfo;
import oos.lmnml.com.img.entity.ImgInfoPO;
import oos.lmnml.com.img.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by daitian on 2017/12/15.
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    String url[] = {
            "http://cdn.joinunow.com/FuqK60nOz5uENQKqXgVUqc1b7ItZ",
            "http://cdn.joinunow.com/FvOeqkLu4sMQsc9rfpYyzI-OiUkS",
            "http://cdn.joinunow.com/FklbD5c01DQpPa89PMxecHWTtgaj",
            "http://cdn.joinunow.com/Fn8Rw9dWOn6D45iRBcZW7zfVxMaa",
            "http://cdn.joinunow.com/Fh76-2ejw-BHxeN-pkW4840TkG2A",
            "http://cdn.joinunow.com/FmV2PdckEK-8EluY3-XgX1AaFGXw",
            "http://cdn.joinunow.com/Fg9ttZsnc_Dz6_ga5ge0XCwce-rc",
            "http://cdn.joinunow.com/Fh4kRl7djzGnPIksJ0WwjX_U5uoa"
    };
    String titles[] = {
            "茶","看书睡觉", "猫", "吉他","吉他","吉他","建筑","大雁"
    };

    @Autowired
    IRedisService redisService;

    @GetMapping("all")
    public ResponseEntity findAll() {
        List list = redisService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity addImg(@RequestBody ImgInfoPO imgInfoPO) {
        String title=imgInfoPO.getTitle(),url=imgInfoPO.getUrl();
        if (title!=null&&url!=null){
            ImgInfo imgInfo = new ImgInfo();
            imgInfo.setCreateTime(new Date());
            imgInfo.setIid(Config.idWorker.nextId());
            imgInfo.setShow(true);
            imgInfo.setViewNum(0);
            imgInfo.setTitle(title);
            imgInfo.setUrl(url);
            List<ImgInfo> list = new ArrayList<>();
            list.add(imgInfo);
            redisService.addImg(list);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("init")
    public ResponseEntity addImg() {
        List<ImgInfo> list = new ArrayList<>();

        for (int i = 0; i < titles.length; i++) {
            ImgInfo imgInfo = new ImgInfo();
            imgInfo.setUrl(url[i]);
            imgInfo.setCreateTime(new Date());
            imgInfo.setIid(Config.idWorker.nextId());
            imgInfo.setShow(true);
            imgInfo.setViewNum(0);
            imgInfo.setTitle(titles[i]);
            list.add(imgInfo);
        }
        redisService.addImg(list);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("del")
    public ResponseEntity delImg() {
        redisService.delImg();
        return new ResponseEntity(HttpStatus.OK);
    }
}
