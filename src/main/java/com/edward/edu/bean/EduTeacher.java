package com.edward.edu.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class EduTeacher implements Serializable {
    private Integer id;
    @NotBlank(message = "教师名称不能为空！")
    private String name;
    private Integer sort;
    @Min(message = "只能是高级讲师或者首席讲师",value = 1)
    @Max(message = "只能是高级讲师或者首席讲师",value = 2)
    private Integer level;
    @NotBlank(message = "教师资历不能为空！")
    private String career;
    @NotBlank(message = "教师简介不能为空！")
    private String intro;
    @NotBlank(message = "教师头像不能为空！")
    private String avatar; //可能出现空格 用.trim()去除
    private boolean isDeleted;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gmtCreated;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gmtModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "EduTeacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", level=" + level +
                ", career='" + career + '\'' +
                ", intro='" + intro + '\'' +
                ", avatar='" + avatar + '\'' +
                ", isDeleted=" + isDeleted +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
