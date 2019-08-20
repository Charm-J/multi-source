package com.yeting.multisource.db.dao.primary;


import com.yeting.multisource.db.entity.UserAlbumInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAlbumInfoRepoP extends JpaRepository<UserAlbumInfo, Long> {

    List<UserAlbumInfo> findByUserId(Long userId);
}
