package com.zsmypb.springboot01.car;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author zhangs.
 * @date 2020/4/13.
 */
@Data
public class CarDto {

    @Excel(name = "a_name", width = 60)
    private String a_name;

    @Excel(name = "b_name", width = 60)
    private String b_name;
}
