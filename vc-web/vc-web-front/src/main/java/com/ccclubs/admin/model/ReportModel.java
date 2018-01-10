package com.ccclubs.admin.model;

import java.io.Serializable;

public class ReportModel implements Serializable {

    private static final long serialVersionUID = -5731620092430214124L;

    private String field;
    private String title;
    private Integer width;
    private Boolean sort;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Boolean getSort() {
        return sort;
    }

    public void setSort(Boolean sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "ReportParams{" +
                "field='" + field + '\'' +
                ", title='" + title + '\'' +
                ", width=" + width +
                ", sort=" + sort +
                '}';
    }
}
