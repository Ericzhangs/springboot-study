package com.zsmypb.eight.chapter;

import com.zsmypb.eight.util.ArrayUtil;
import com.zsmypb.eight.vo.User;

import java.util.Comparator;
import java.util.List;

/**
 * @author zhangs.
 * @date 2020/4/6.
 */
public class One {
    public static void main(String[] args) {
        sortTest();
    }

    static void sortTest() {
        List<User> userList = ArrayUtil.getUserList();
        userList.sort(Comparator.comparing(User::getAge));
        System.out.println(userList);
    }

}
