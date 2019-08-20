package com.yeting.multisource.common;

/**
 * @author DJ
 * @date 2019/8/7 11:18
 */
public class Const {

    public static final String DATE_SIMPLE_FMT = "yyyy-MM-dd";

    /**
     * 状态
     */
    public enum Status {
        VALID,  // 正常
        INVALID // 删除
    }

    /**
     * 用户类型
     */
    public enum UserType {
        PERSON,  // 真实用户 0
        ROBOT, // 机器人 1
        RESERVE_USER // 预留用户 2
    }

    public enum RegChannel {
        APP,
        H5,
    }

    /**
     * 认证类型
     */
    public enum UserAlbumInfoType {
        avatar("头像"),         // 头像图片
        photo_album("相册图片"); // 相册图片

        String intro;

        UserAlbumInfoType(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 认证状态
     */
    public enum AuthStatus {
        unsubmited("未提交"),   // 未提交
        ing("认证中"),          // 认证中
        pass("认证通过"),         // 认证通过
        failed("认证失败");        // 认证失败

        String intro;

        AuthStatus(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 月收入
     */
    public enum MonthlyIncome {
        unlimited("不限"),            // 0
        below_3k("3千以下"),          // 1
        bewteen_3k_5k("3千-5千"),     // 2
        bewteen_5k_8k("5千-8千"),     // 3
        bewteen_8k_1w2("8千-1.2万"),  // 4
        bewteen_1w2_2w("1.2万-2万"),  // 5
        bewteen_2w_5w("2万-5万"),     // 6
        up_5w("5万以上");             // 7

        String intro;

        MonthlyIncome(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 学历
     */
    public enum Education {
        unlimited("不限学历"),                // 不限
        high_school_and_below("高中及以下"),  // 高中及以下
        special_secondary_school("中专"),    // 中专
        junior_college("大专"),              // 大专
        university("大学本科"),               // 大学本科
        master("硕士"),                      // 硕士
        doctor("博士");                      // 博士

        String intro;

        Education(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 婚姻状况
     */
    public enum Marriage {
        unlimited("不限婚姻状态"), // 不限
        single("单身"),    // 单身
        divorce("离异"),   // 离异
        widowed("丧偶");   // 丧偶

        String intro;

        Marriage(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 是否有小孩
     */
    public enum HadChildren {
        unlimited("不限是否有小孩"),            // 不限
        no("没有小孩"),                        // 没有小孩
        yes_live_together("有小孩，住在一起"),       // 有、住在一起
        yes_live_in_a_while("有小孩，偶尔住在一起"),  // 有、偶尔住在一起
        yes_separately("有小孩，不住一起");           // 有，不住一起

        String intro;

        HadChildren(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 是否想要小孩
     */
    public enum ExpectChild {
        unlimited("不限"),    // 不限
        it_depends("视情况而定"),   // 视情况而定
        yes("是"),           // 是
        no("否"),            // 否
        secret("以后告诉你"); // 保密，以后告诉你

        String intro;

        ExpectChild(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 住房情况
     */
    public enum House {
        unlimited("不限住房"),
        purchased("已买房"),           // 已购
        renting("租房"),               // 租房
        renting_after_marry("婚后租房"),// 婚后租房
        public_offer("单位住房");       // 单位住房

        String intro;

        House(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 购车情况
     */
    public enum Car {
        unlimited("不限"),
        had("已购车"),      // 已购
        have_not("无车"); // 无车

        String intro;

        Car(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }
    /**
     * 体型
     */
    public enum Shape {
        unlimited("不限体型"),// 不限
        secret("保密"),   // 保密
        normal("正常"),   // 正常
        thin("瘦长"),     // 瘦长
        sports("运动型"), // 运动型
        fat("肥胖"),      // 肥胖
        strong("魁梧"),   // 魁梧
        sturdy("壮实");   // 壮实

        String intro;

        Shape(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 希望何时结婚
     */
    public enum ExpectMarriage {
        unlimited("不限制"),
        flash("闪婚"),             // 闪婚
        one_year("一年内"),        // 一年内
        two_year("二年内"),        // 二年内
        three_year("三年内"),      // 三年内
        over_three_yea("三年以上"); // 三年以上

        String intro;

        ExpectMarriage(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 自身吸烟情况
     */
    public enum SelfSmoke {
        placeholder,                 // 0占位
        no("不抽烟"),               // 1不
        a_little("抽一点烟"),       // 2一点
        a_lot("抽很多烟"),          // 3很多
        on_social("社交场合会抽烟"); // 4社交场合

        String intro;

        SelfSmoke() {
        }

        SelfSmoke(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 自身喝酒情况
     */
    public enum SelfDrink {
        placeholder,                    // 0占位
        no("不喝酒"),               // 1不
        a_little("喝一点酒"),       // 2一点
        a_lot("喝很多酒"),          // 3很多
        on_social("社交场合会喝酒"); // 4社交场合

        String intro;

        SelfDrink() {
        }

        SelfDrink(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 对象喝酒情况
     * 备注：和SelfSmokeDrink存在包含关系
     */
    public enum TargetDrink {
        //和SelfSmokeDrink的对应关系  // TargetSmokeDrink    // SelfSmokeDrink
        unlimited("不限制是否喝酒"),                    // 0不限                 // >0
        no("不喝酒"),                                  // 1不吸烟               // =1
        yes("喝酒");                                  // 2可以吸烟             // >=2

        String intro;

        TargetDrink() {
        }

        TargetDrink(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 对象吸烟情况
     * 备注：和SelfSmokeDrink存在包含关系
     */
    public enum TargetSmoke {
        //和SelfSmokeDrink的对应关系  // TargetSmokeDrink    // SelfSmokeDrink
        unlimited("不限制是否抽烟"),                    // 0不限                 // >0
        no("不抽烟"),                                  // 1不吸烟               // =1
        yes("抽烟");                                   // 2可以吸烟             // >=2

        String intro;

        TargetSmoke() {
        }

        TargetSmoke(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }

    /**
     * 择偶照片情况
     */
    public enum TargetPic {
        unlimited("不限"),   // 不限
        yes("有照片");       // 有

        String intro;

        TargetPic() {
        }

        TargetPic(String intro) {
            this.intro = intro;
        }

        public String getIntro() {
            return intro;
        }
    }
}
