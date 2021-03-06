package com.edward.edu.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

public class EduSubject implements Serializable {
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Integer id;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String title;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Integer parentId;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Integer sort;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Integer isDeleted;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Date gmtCreated;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
        return "EduSubject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", parentId=" + parentId +
                ", sort=" + sort +
                ", isDeleted=" + isDeleted +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
