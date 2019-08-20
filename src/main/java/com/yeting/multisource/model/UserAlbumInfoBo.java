package com.yeting.multisource.model;


import com.yeting.multisource.common.Const;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAlbumInfoBo {

    private Const.UserAlbumInfoType type;                       // 类型
    private String url;                                         // 图片url
    private String remarks;                                     // 备注(失败原因)
    private Const.AuthStatus authStatus = Const.AuthStatus.ing; // 认证状态

    public static UserAlbumInfoBo convert(UserAlbumInfoBo albumInfo) {
        UserAlbumInfoBo bo = new UserAlbumInfoBo();
        BeanUtils.copyProperties(albumInfo, bo);
        return bo;
    }

    public static UserAlbumInfoBo ofAvatar(boolean self,
                                           String avatar,
                                           UserAlbumInfoBo record) {
        UserAlbumInfoBo userAlbumInfoBo = new UserAlbumInfoBo();
        if (self) { // 查看自己的信息(最后一次提交审核的)
            // 默认头像
            if (null == record && null != avatar) {
                userAlbumInfoBo.setUrl(avatar);
                userAlbumInfoBo.setAuthStatus(Const.AuthStatus.pass);
                userAlbumInfoBo.setType(Const.UserAlbumInfoType.avatar);
                return userAlbumInfoBo;
            } else {
                return record;
            }
        } else { // 查看别人的信息(最后一次审核通过的)
            if (Strings.isNotBlank(avatar)) {
                userAlbumInfoBo.setUrl(avatar);
                userAlbumInfoBo.setAuthStatus(Const.AuthStatus.pass);
                userAlbumInfoBo.setType(Const.UserAlbumInfoType.avatar);
                return userAlbumInfoBo;
            } else {
                return null;
            }
        }
    }

    public static List<UserAlbumInfoBo> ofPhotoAlbum(boolean self,
                                                     List<String> passList,
                                                     List<UserAlbumInfoBo> lastList) {
        if (self) { // 查看自己的信息(最后一次提交审核的)
            return lastList;
        } else { // 查看别人的信息(最后一次审核通过的)
            if (CollectionUtils.isEmpty(passList)) {
                return null;
            }
            return passList.stream().map(url -> new UserAlbumInfoBo(Const.UserAlbumInfoType.photo_album, url,
                    null, Const.AuthStatus.pass)).collect(Collectors.toList());
        }
    }
}
