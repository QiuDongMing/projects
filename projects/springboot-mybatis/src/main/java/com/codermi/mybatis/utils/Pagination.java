package com.codermi.mybatis.utils;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;

/**
 * @author qiudm
 * @date 2018/12/12 16:22
 * @desc
 */
@Data
public class Pagination<T> {

    private static final int DEFAULT_PAGESIZE = 15;

    private int pageNum;

    private int pageSize = DEFAULT_PAGESIZE;

    private long total = 0;

    private int pageCount = 0;

    private int start = 0;

    private List<T> dataList;

    public Pagination() {
        this(1, DEFAULT_PAGESIZE, 0, null);
    }

    public Pagination(int pageNum, int pageSize) {
        this(pageNum, pageSize, 0, null);
    }

    public Pagination(int pageNum, int total, List<T> dataList) {
        this(pageNum, DEFAULT_PAGESIZE, total, dataList);
    }

    public Pagination(int pageNum, int pageSize, int total, List<T> dataList) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.dataList = dataList;
        init();
    }


    private void init() {
        if (pageNum <= 0) pageNum = 1;
        if (pageSize <= 0) pageSize = 15;
        if (total <= 0) total = 0;
    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }


    public int getPageCount() {
        return (int) (total - 1) / pageSize + 1;
    }

    public int getStart() {
        return (pageNum - 1) * pageSize;
    }


    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public static void main(String[] args) {

        Pagination pagination = new Pagination(0, 3);
        pagination.setTotal(21);
        System.out.println("pagination = " + JSON.toJSONString(pagination));

    }

}
