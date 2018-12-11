package com.example.springbootstage.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Store extends BaseRowModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty(value = {"id"}, index = 0)
    private Long id;
    @ExcelProperty(value = {"名称"}, index = 1)
    private String name;
    @ExcelProperty(value = {"省"}, index = 2)
    private String province;
    @ExcelProperty(value = {"市"}, index = 3)
    private String city;
    @ExcelProperty(value = {"区"}, index = 4)
    private String district;
    @ExcelProperty(value = {"详细地址"}, index = 5)
    private String detail;
    @ExcelProperty(value = {"经度"}, index = 6)
    private String longitude;
    @ExcelProperty(value = {"纬度"}, index = 7)
    private String latitude;
    @ExcelProperty(value = {"区域编码"}, index = 8)
    private String zoneCode;
    @ExcelProperty(value = {"状态"}, index = 9)
    private String status;

    @ManyToMany
    @JoinTable(name = "ModelStore", joinColumns = {@JoinColumn(name = "sid")}, inverseJoinColumns = {@JoinColumn(name = "mid")})
    private List<Model> modelList;

    @ManyToMany
    @JoinTable(name = "StorePackage", joinColumns = {@JoinColumn(name = "sid")}, inverseJoinColumns = {@JoinColumn(name = "pid")})
    private List<Package> packageList;

    private String createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String updateUser;


}
