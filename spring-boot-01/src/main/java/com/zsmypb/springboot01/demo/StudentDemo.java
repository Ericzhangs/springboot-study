package com.zsmypb.springboot01.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangs.
 * @date 2020/3/27.
 */
public class StudentDemo {

    public static void main(String[] args) {

        List<StudentVo> studentVos = new ArrayList<>();
        studentVos.add(StudentVo.builder().student("z1").gender("M").stature(170).build());
        studentVos.add(StudentVo.builder().student("z2").gender("M").stature(180).build());
        studentVos.add(StudentVo.builder().student("z3").gender("G").stature(150).build());
        System.out.println(studentVos);
//        seat(studentVos);
    }

    private static void seat(List<StudentVo> studentVos) {
        List<StudentVo> collect = studentVos.stream().sorted(Comparator.comparing(StudentVo::getStature)).collect(Collectors.toList());
        Map<Integer, Node> seatMap = initSeat();
        for (int i = 0; i < collect.size(); i++) {
            StudentVo vo = collect.get(i);
            if (i == 0) {
                Node node = seatMap.get(0);
                node.setLeft(vo);
                seatMap.put(0, node);
                continue;
            }
            if (i == 1) {
                Node node;
                node = seatMap.get(0);
                node.setRight(vo);
                seatMap.put(0, node);
                continue;
            }
            Node node = seatMap.get(i / 2);
            if (i % 2 == 0) {
                node.setLeft(collect.get(i));
                seatMap.put(i % 2, node);
            }
            if (i % 2 == 1) {
                node.setRight(collect.get(i));
                seatMap.put(i % 2, node);
            }

        }
        collect.forEach(studentVo -> {

        });

    }

    private static Map<Integer, Node> initSeat() {
        Map<Integer, Node> seatMap = new HashMap<>();
        seatMap.put(1, Node.builder().build());
        seatMap.put(2, Node.builder().build());
        seatMap.put(3, Node.builder().build());
        seatMap.put(0, Node.builder().build());
        return seatMap;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class StudentVo {
    private String student; // 姓名
    private String gender;  // 性别
    private Integer stature; // 身高
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Node {
    private StudentVo left;
    private StudentVo right;

}

