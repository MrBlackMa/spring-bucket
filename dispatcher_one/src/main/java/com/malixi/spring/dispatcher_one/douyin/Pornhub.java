package com.malixi.spring.dispatcher_one.douyin;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/**
 * @Auther: smile malixi
 * @Date: 2021/1/22 - 2:08
 * @Description: com.malixi.spring.dispatcher_one.douyin
 * @version: 1.0
 */
@Slf4j
public class Pornhub {
    private  static String videoUrl="https://vd3.bdstatic.com/mda-maeqchsdm59rwwjv/540p/h264_cae/1610730726/mda-maeqchsdm59rwwjv.mp4";
    private static final String videoSavePath="d:/生活日常/视频"+"/pornhub/"+ DateTime.now().toDateStr();


    public static void main(String[] args) throws Exception {

            downVideo(videoUrl,"1",null);
    }

    public static void downVideo(String httpUrl,String title,String source) {
        String newName=DateTime.now().toDateStr();
//        String fileAddress = videoSavePath+"/"+source+"/"+title+".mp4";
        String fileAddress = videoSavePath+"/"+title+".mp4";
        int byteRead;
        try {
            URL url = new URL(httpUrl);
            //获取链接
            URLConnection conn = url.openConnection();
            //输入流
            InputStream inStream = conn.getInputStream();
            //封装一个保存文件的路径对象
            File fileSavePath = new File(fileAddress);
            //注:如果保存文件夹不存在,那么则创建该文件夹
            File fileParent = fileSavePath.getParentFile();
            if(!fileParent.exists()){
                fileParent.mkdirs();
            }
            //写入文件
            FileOutputStream fs = new FileOutputStream(fileSavePath);
            byte[] buffer = new byte[1024];
            while ((byteRead = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteRead);
            }
            inStream.close();
            fs.close();
            System.out.println("\n-----视频保存路径-----\n"+fileSavePath.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
