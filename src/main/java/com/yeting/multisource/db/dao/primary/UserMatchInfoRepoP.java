package com.yeting.multisource.db.dao.primary;


import com.yeting.multisource.db.entity.UserMatchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMatchInfoRepoP extends JpaRepository<UserMatchInfo, Long> {

    List<UserMatchInfo> findByUserId(Long userId);
}
