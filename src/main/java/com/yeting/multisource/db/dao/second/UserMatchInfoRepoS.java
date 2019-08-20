package com.yeting.multisource.db.dao.second;


import com.yeting.multisource.db.entity.UserMatchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMatchInfoRepoS extends JpaRepository<UserMatchInfo, Long> {

}
