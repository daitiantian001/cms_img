package oos.lmnml.com.img.service.impl;

import oos.lmnml.com.img.common.Config;
import oos.lmnml.com.img.entity.ImgInfo;
import oos.lmnml.com.img.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by daitian on 2017/12/15.
 */
@Service
public class RedisService implements IRedisService {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public List findAll() {
       return redisTemplate.opsForHash().values(Config.PROD_IMG_SHOW);
    }

    @Override
    public void addImg(List<ImgInfo> imgInfo) {
        for (int i = 0; i <imgInfo.size() ; i++) {
            redisTemplate.opsForHash().put(Config.PROD_IMG_SHOW,String.valueOf(imgInfo.get(i).getIid()),imgInfo.get(i));
        }
    }

    @Override
    public void delImg() {
        redisTemplate.delete(Config.PROD_IMG_SHOW);
    }
}
