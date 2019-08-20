package com.yeting.multisource.db.dao.second;


import com.yeting.multisource.db.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepoS extends JpaRepository<UserInfo, Long> {

    List<UserInfo> findByMobile(String mobile);
}
