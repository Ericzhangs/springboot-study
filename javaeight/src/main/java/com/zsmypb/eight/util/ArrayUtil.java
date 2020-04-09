package com.zsmypb.eight.util;


import com.zsmypb.eight.vo.Inventory;
import com.zsmypb.eight.vo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangs.
 * @date 2020/4/6.
 */
public class ArrayUtil {
    private static List<Inventory> inventories = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    static {
        users.add(User.builder().name("zhang1").sex("M").age(18).stature(180).build());
        users.add(User.builder().name("zhang2").sex("M").age(19).stature(188).build());
        users.add(User.builder().name("zhang3").sex("G").age(18).stature(170).build());
        users.add(User.builder().name("zhang4").sex("G").age(19).stature(177).build());
    }

    public static List<User> getUserList() {
        return users;
    }

}
