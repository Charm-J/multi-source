package com.yeting.multisource.db.dao.second;


import com.yeting.multisource.db.entity.UserAlbumInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAlbumInfoRepoS extends JpaRepository<UserAlbumInfo, Long> {

}
