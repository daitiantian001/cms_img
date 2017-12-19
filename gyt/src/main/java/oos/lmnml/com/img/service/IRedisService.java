package oos.lmnml.com.img.service;

import oos.lmnml.com.img.entity.ImgInfo;

import java.util.List;

/**
 * Created by daitian on 2017/12/15.
 */
public interface IRedisService {
    List findAll();

    void addImg(List<ImgInfo> imgInfo);

    void delImg();
}
