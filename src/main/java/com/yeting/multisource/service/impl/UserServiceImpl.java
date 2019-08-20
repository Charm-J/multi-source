package com.yeting.multisource.service.impl;

import com.yeting.multisource.common.Const;
import com.yeting.multisource.db.dao.primary.UserAlbumInfoRepoP;
import com.yeting.multisource.db.dao.primary.UserInfoRepoP;
import com.yeting.multisource.db.dao.primary.UserMatchInfoRepoP;
import com.yeting.multisource.db.dao.second.UserAlbumInfoRepoS;
import com.yeting.multisource.db.dao.second.UserInfoRepoS;
import com.yeting.multisource.db.dao.second.UserMatchInfoRepoS;
import com.yeting.multisource.db.entity.UserAlbumInfo;
import com.yeting.multisource.db.entity.UserInfo;
import com.yeting.multisource.db.entity.UserMatchInfo;
import com.yeting.multisource.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DJ
 * @date 2019/8/7 16:04
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    private UserInfoRepoP userInfoRepoP;
    @Autowired
    private UserInfoRepoS userInfoRepoS;

    @Autowired
    private UserMatchInfoRepoP userMatchInfoRepoP;
    @Autowired
    private UserMatchInfoRepoS userMatchInfoRepoS;

    @Autowired
    private UserAlbumInfoRepoP userAlbumInfoRepoP;
    @Autowired
    private UserAlbumInfoRepoS userAlbumInfoRepoS;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int exchangeUsers() throws Exception {
        int total = 0;
        log.info("Users from H5 exchange from Test to Prod start!");
        try {
            List<UserInfo> list = userInfoRepoP.findByRegChannel(Const.RegChannel.H5);
            log.info("Test users total = {}", list.size());

            for (UserInfo userInfo : list) {
                List<UserInfo> userInfos = userInfoRepoS.findByMobile(userInfo.getMobile());
                if (!userInfos.isEmpty()) {
                    log.info("Test users user_id= {} is exsist~", userInfo.getUserId());
                    continue;
                }
                UserInfo user = new UserInfo();
                BeanUtils.copyProperties(userInfo, user, "id");
                user.setUserId(null);
                user.setNimToken(null);
                UserInfo save = userInfoRepoS.save(user);
                Long userId = save.getUserId();
                List<UserAlbumInfo> userAlbumInfos = userAlbumInfoRepoP.findByUserId(userInfo.getUserId());
                if (!userAlbumInfos.isEmpty()) {
                    List<UserAlbumInfo> userAlbs = new ArrayList<>();
                    for (UserAlbumInfo userAlbumInfo : userAlbumInfos) {
                        UserAlbumInfo userAlb = new UserAlbumInfo();
                        BeanUtils.copyProperties(userAlbumInfo, userAlb, "id");
                        userAlb.setId(null);
                        userAlb.setUserId(userId);
                        userAlbs.add(userAlb);
                    }
                    userAlbumInfoRepoS.saveAll(userAlbs);
                }

                List<UserMatchInfo> userMatchInfos = userMatchInfoRepoP.findByUserId(userInfo.getUserId());
                if (!userMatchInfos.isEmpty()) {
                    List<UserMatchInfo> userMats = new ArrayList<>();
                    for (UserMatchInfo userAlbumInfo : userMatchInfos) {
                        UserMatchInfo userMat = new UserMatchInfo();
                        BeanUtils.copyProperties(userAlbumInfo, userMat, "id");
                        userMat.setId(null);
                        userMat.setUserId(userId);
                        userMats.add(userMat);
                    }
                    userMatchInfoRepoS.saveAll(userMats);
                }
                total += 1;
            }
            log.info("Users from H5 exchange from Test to Prod end, Test total = {}, exchange total = {}", list.size(), total);
        } catch (Exception e) {
            log.error("Users from H5 exchange from Test to Prod ERROR~ e= {}", e);
            throw new Exception();
        }

        return total;
    }

}
