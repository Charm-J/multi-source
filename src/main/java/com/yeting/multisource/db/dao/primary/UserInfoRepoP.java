package com.yeting.multisource.db.dao.primary;


import com.yeting.multisource.common.Const;
import com.yeting.multisource.db.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepoP extends JpaRepository<UserInfo, Long> {

    List<UserInfo> findByRegChannel(Const.RegChannel h5);
}
