package com.cumt.video.repository;

import com.cumt.video.dataobject.Videos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Videos, String> {
    public List<Videos> findAllByuserId(String userId);
}
