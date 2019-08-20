package com.yeting.multisource.db.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.yeting.multisource.common.Const;
import com.yeting.multisource.helper.JpaListStringConverter;
import com.yeting.multisource.helper.JpaListUserAlbumInfoBoConverter;
import com.yeting.multisource.helper.JpaUserAlbumInfoBoConverter;
import com.yeting.multisource.model.UserAlbumInfoBo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_info")
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends BaseEntity {
    private static final long serialVersionUID = 4724057957811226415L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;     // 用户id

    // 头像
    private String avatar;                    // 审核通过的头像
    @Convert(converter = JpaUserAlbumInfoBoConverter.class)
    private UserAlbumInfoBo avatarAuthDetail; // 最后一次头像审核详情
    private Const.AuthStatus avatarAuthStatus = Const.AuthStatus.unsubmited; // 头像审核状态

    private String mobile;       // 手机
    private String nickname;     // 用户昵称
    private Integer gender = 0;  // 性别：0未知、1男、2女
    @JSONField(format = Const.DATE_SIMPLE_FMT)
    private Date birthday;       // 生日
    private String height;       // 身高
    private String workPlace;    // 工作地址
    private String introduce;    // 简介，独白

    private String wxUnionId;    // 微信 unionId
    private String wxAppOpenId;  // 微信app openId
    private String wxMaOpenId;   // 微信小程序 openId

    // 实名信息
    private String realname;                                    // 真实姓名
    private String idcard;                                      // 身份证号码
    private Const.AuthStatus realnameAuthStatus = Const.AuthStatus.unsubmited;   // 实名认证状态

    // 相册
    @Convert(converter = JpaListStringConverter.class)
    private List<String> photoAlbum;                  // 审核通过的相册
    @Convert(converter = JpaListUserAlbumInfoBoConverter.class)
    private List<UserAlbumInfoBo> photoAlbumAuthDetail;   // 最后一次相册审核详情

    private String wxAppInfo;                         // 微信app用户信息
    private String wxMaInfo;                          // 微信小程序用户信息

    private BigDecimal yqCoin = BigDecimal.ZERO;      // 账户余额

    private Integer forbidden = 0;                    // 是否冻结：0否，1是
    private String forbiddenReason;                   // 冻结原因

    private String regIp;        // 注册ip
    private Date lastLoginTime;  // 最后登录时间

    private String agoraToken;  // 声网token
    private String nimToken;    // 云信token

    private Const.Status status = Const.Status.VALID;    // 状态: VALID正常，INVALID删除
    private Const.UserType type = Const.UserType.PERSON; // 类型: PERSON 真实用户，ROBOT 机器人

    private Const.RegChannel regChannel = Const.RegChannel.APP; // 注册渠道：默认为APP

    public boolean forbidden() {
        return Objects.equals(1, forbidden);
    }
}
