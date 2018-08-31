package com.cumt.video.params;

public class VideoUploadParam {
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoSeconds() {
        return videoSeconds;
    }

    public void setVideoSeconds(Integer videoSeconds) {
        this.videoSeconds = videoSeconds;
    }

    private Integer userId;
    private Integer videoSeconds;

    @Override
    public String toString() {
        return "VideoUploadParam{" +
                "userId=" + userId +
                ", videoSeconds=" + videoSeconds +
                '}';
    }
}
