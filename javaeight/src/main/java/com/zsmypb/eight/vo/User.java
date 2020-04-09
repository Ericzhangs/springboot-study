package com.zsmypb.eight.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangs.
 * @date 2020/4/6.
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {
    private String name;
    private String sex;
    private Integer age;
    private Integer stature;
}
