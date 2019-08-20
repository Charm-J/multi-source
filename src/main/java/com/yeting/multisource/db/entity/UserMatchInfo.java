package com.yeting.multisource.db.entity;

import com.yeting.multisource.common.Const;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_match_info")
@EqualsAndHashCode(callSuper = true)
public class UserMatchInfo extends BaseEntity {
    private static final long serialVersionUID = 4724057957811226415L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    // 自身条件
    private Const.MonthlyIncome selfMonthlyIncome;      // 1.月收入
    private String selfProfessional;                    // 2.职业
    private Const.Education selfEducation;              // 3.学历
    private Const.Marriage selfMarriage;                // 4.婚姻状况
    private Const.HadChildren selfHadChildren;          // 5.有没有小孩
    private Const.ExpectChild selfExpectChild;          // 6.是否想要小孩
    private Const.House selfHouse;                      // 7.住房情况
    private Const.Car selfCar;                          // 8.购车情况
    private String selfOriginPlace;                     // 9.籍贯
    private String selfWeight;                          // 10.体重
    private Const.Shape selfShape;                      // 11.体型
    private String selfNation;                          // 12.民族
    private Const.ExpectMarriage selfExpectMarriage;    // 13.希望何时结婚
    private Const.SelfSmoke selfSmoke;                  // 14.抽烟情况
    private Const.SelfDrink selfDrink;                  // 15.喝酒情况

    // 择偶条件
    private String targetAge;                           // 1.年龄
    private String targetHeight;                        // 2.身高
    private Const.MonthlyIncome targetMonthlyIncome;    // 3.月收入
    private Const.Education targetEducation;            // 4.学历
    private Const.Marriage targetMarriage;              // 5.婚姻状况
    private Const.Shape targetShape;                    // 6.体型
    private String targetWorkPlace;                     // 7.工作地区
    private Const.HadChildren targetHadChildren;        // 8.有没有小孩
    private Const.ExpectChild targetExpectChild;        // 9.是否想要小孩
    private Const.TargetSmoke targetSmoke;              // 10.抽烟情况
    private Const.TargetDrink targetDrink;              // 11.喝酒情况
    private Const.TargetPic targetPics;                 // 12.是否有照片
}
