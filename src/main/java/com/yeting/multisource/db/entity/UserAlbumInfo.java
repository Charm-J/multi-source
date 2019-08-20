package com.yeting.multisource.db.entity;


import com.yeting.multisource.common.Const;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户认证相关类：头像认证，相册认证
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_album_info")
@EqualsAndHashCode(callSuper = true)
public class UserAlbumInfo extends BaseEntity {
    private static final long serialVersionUID = 6512153731944380507L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;                // 用户id

    private String url;                 // 图片url
    private Const.UserAlbumInfoType type;   // 类型
    private String remarks;             // 备注(失败原因)

    private Date authTime;              // 认证时间
    private Const.AuthStatus authStatus = Const.AuthStatus.ing;// 认证状态
    private Const.Status status = Const.Status.VALID;

    public static UserAlbumInfo ofAvatar(UserInfo userInfo,
                                         String url) {
        UserAlbumInfo userAlbumInfo = new UserAlbumInfo();
        userAlbumInfo.setUrl(url);
        userAlbumInfo.setUserId(userInfo.getUserId());
        userAlbumInfo.setType(Const.UserAlbumInfoType.avatar);
        return userAlbumInfo;
    }

    public static List<UserAlbumInfo> of(Const.UserAlbumInfoType type,
                                         UserInfo userInfo,
                                         List<String> urls) {
        return urls.stream().map(url -> {
            UserAlbumInfo userAlbumInfo = new UserAlbumInfo();
            userAlbumInfo.setUrl(url);
            userAlbumInfo.setUserId(userInfo.getUserId());
            userAlbumInfo.setType(type);
            return userAlbumInfo;
        }).collect(Collectors.toList());
    }
}
