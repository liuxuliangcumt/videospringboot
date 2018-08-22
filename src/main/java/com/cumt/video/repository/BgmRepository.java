package com.cumt.video.repository;

import com.cumt.video.dataobject.Bgm;
import com.cumt.video.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BgmRepository extends JpaRepository<Bgm, String> {

}
