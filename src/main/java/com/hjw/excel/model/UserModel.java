package com.hjw.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.hjw.excel.excle.utils.CellStyleFormat;
import lombok.Data;

@Data
public class UserModel extends BaseRowModel {
    @ExcelProperty(value = "姓名" ,index = 0)
    @CellStyleFormat
    private String name;

    @ExcelProperty(value = "年龄",index = 1)
    @CellStyleFormat
    private Integer age;

    @ExcelProperty(value = "手机号",index = 2)
    @CellStyleFormat
    private String mobile;

}
