package com.cumt.video.service;

import com.cumt.video.dataobject.Bgm;
import com.cumt.video.dataobject.Videos;
import com.cumt.video.util.PagedResult;

import java.util.List;

public interface VideoService {

    public void addBgm(Bgm bgm);

    public List<Bgm> queryBgmList(Integer page, Integer pageSize);

    public void deleteBgm(String id);

    public PagedResult queryReportList(Integer page, Integer pageSize);

    public void updateVideoStatus(String videoId, Integer status);

    public void inserVideo(Videos videos);

    public List<Videos> findVideos(String userId);
}
