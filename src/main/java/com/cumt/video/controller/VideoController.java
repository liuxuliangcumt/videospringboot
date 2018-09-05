package com.cumt.video.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.cumt.video.data.pojo.common.VideoJSONResult;
import com.cumt.video.dataobject.Bgm;
import com.cumt.video.dataobject.Videos;
import com.cumt.video.params.LoginParam;
import com.cumt.video.params.VideoUploadParam;
import com.cumt.video.service.VideoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("video")
public class VideoController {

    @Autowired
    VideoService videoService;


    @PostMapping("/bgmList")
    public VideoJSONResult bgmList() {

        System.out.println(videoService.queryBgmList(1, 5));
        List<Bgm> bgms = videoService.queryBgmList(1, 5);

        return new VideoJSONResult().ok(bgms);
    }

    @GetMapping("/showBgmList")
    public String showBgmList() {
        return "video/bgmList";
    }


    @GetMapping("/showAddBgm")
    public String login() {
        return "video/addBgm";
    }


    @PostMapping("/bgmUpload")
    @ResponseBody
    public VideoJSONResult bgmUpload(@RequestParam("file") MultipartFile[] files, @RequestBody VideoUploadParam param) throws Exception {

        // 文件保存的命名空间
//		String fileSpace = File.separator + "imooc_videos_dev" + File.separator + "mvc-bgm";
        String fileSpace = "F:" + File.separator + "wechatProject" + File.separator + "upload";
        // 保存到数据库中的相对路径

        String uploadPathDB = File.separator + "bgm";
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if (files != null && files.length > 0) {
                String fileName = files[0].getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    // 文件上传的最终保存路径
                    String finalPath = fileSpace + uploadPathDB + File.separator + fileName;
                    // 设置数据库保存的路径
                    uploadPathDB += (File.separator + fileName);

                    File outFile = new File(finalPath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        // 创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }

                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files[0].getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }

            } else {
                return VideoJSONResult.errorMsg("上传出错...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return VideoJSONResult.errorMsg("上传出错...");
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        return VideoJSONResult.ok(uploadPathDB);
    }

    @PostMapping("/upload")//视频上传
    @ResponseBody
    public VideoJSONResult videiUpload(@RequestParam("file") MultipartFile[] files, String userId, String desc) throws Exception {

//		String fileSpace = File.separator + "imooc_videos_dev" + File.separator + "mvc-bgm";
        String fileSpace = "F:" + File.separator + "wechatProject" + File.separator + "upload";

        System.out.println("上传视频param：   ");

        System.out.println("上传视频param：   " + userId.toString());
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        String finalPath = "";
        String savePath = "Path/";
        try {
            if (files != null && files.length > 0) {
                String fileName = files[0].getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {

                    savePath = savePath + fileName;
                    // 文件上传的最终保存路径
                    finalPath = fileSpace + File.separator + fileName;
                    // 设置数据库保存的路径

                    File outFile = new File(finalPath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        // 创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }

                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files[0].getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }

            } else {
                return VideoJSONResult.errorMsg("上传出错...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return VideoJSONResult.errorMsg("上传出错...");
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        Videos videos = new Videos();
        videos.setVideoPath(savePath);
        videos.setUserId(userId);
        videos.setVideoDesc(desc);
        videos.setCreateTime(new Date());
        videoService.inserVideo(videos);
        return VideoJSONResult.ok(savePath);
    }

    @PostMapping("/showAll")
    @ResponseBody
    public VideoJSONResult showAll(@RequestBody LoginParam param) {
        System.out.println("video/showAll所有作品 有有有    " + param.getUserId());


        List<Videos> videosList = videoService.findVideos(param.getUserId().toString());
        return VideoJSONResult.ok(videosList);


    }

}
