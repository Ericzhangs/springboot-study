package com.zsmypb.springboot01.car;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @author zhangs.
 * @date 2020/4/13.
 */
public class CarService1 {
    public static void main(String[] args) throws IOException {
        System.out.println(1111);
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        long start = new Date().getTime();
        List<CarDto> list = ExcelImportUtil.importExcel(
                new File("/Users/zhangs/car/车型名称映射.xlsx"),
                CarDto.class, params);
        params.setStartSheetIndex(1);
        List<CarDto> listB = ExcelImportUtil.importExcel(
                new File("/Users/zhangs/car/车型名称映射.xlsx"),
                CarDto.class, params);
        System.out.println(list);
        System.out.println(listB);
        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(listB.get(0));
        List<CarDto> test = new ArrayList<>();
        test.addAll(list);
        for (int i = 0; i < test.size(); i++) {
            String[] s = test.get(i).getA_name().split(" ");
            List<String> strings = Arrays.asList(s);

            for (int j = 0; j < listB.size(); j++) {
                List<String> strings1 = Arrays.asList(listB.get(j).getB_name().split(" "));
                long count = strings1.stream().filter(s1 -> strings.contains(s1)).count();
                if (count > 6) {
                    test.get(i).setB_name(listB.get(j).getB_name());
                    continue;
                }
                if (count > 5 && (strings1.get(strings1.size() - 1).equals(strings.get(strings.size() - 1)))) {
                    test.get(i).setB_name(listB.get(j).getB_name());
                    continue;
                }
                if (compareDistinct(strings, strings1)) {
                    test.get(i).setB_name(listB.get(j).getB_name());
                    continue;
                }
            }
        }
        export(test);
        System.out.println(new Date().getTime() - start);

    }

    public static boolean compareDistinct(List<String> s1, List<String> s2) {
        List<String> collect = s2.stream().distinct().collect(Collectors.toList());
        boolean flag = false;
        if (s1.size() > 5 && s2.size() > 5) {
            for (int i = 0; i < 4; i++) {
                flag = s1.get(i).equals(collect.get(i)) ? true : false;
            }
        }
        return flag;
    }

    public static boolean compareContain1(String s1, String s2) {
        return s1.contains(s2);
    }


    public static boolean compareTime(List<String> s1, List<String> s2) {
//        if (s1.get(0).equals("奥迪")) {
        return s1.get(2).equals(s2.get(2));
//        }
//        return s1.contains(s2) || s2.contains(s1);
    }

    public static boolean compareContain(String s1, String s2) {
        return s1.contains(s2) || s2.contains(s1);
    }

    public static long compare(List<String> list1, List<String> list2) {
        AtomicLong count = new AtomicLong();
        list1.forEach(o -> {
            count.set(list2.stream().filter(o1 -> {
//                System.out.println(o + "-----" + o1);
                return o1.contains(o) || o.contains(o1);
            }).count());
        });
        return count.get();
    }

    public static void export(List data) throws IOException {
        System.out.println(data);
        Workbook sheets = ExcelExportUtil.exportExcel(
                new ExportParams(), CarDto.class,
                data);
        FileOutputStream fos = new FileOutputStream("/Users/zhangs/car/结果w.xlsx");
        sheets.write(fos);
        fos.close();
    }

    public static List removeDuplicationByHashSet(List<String> list) {
        HashSet set = new HashSet(list);
        return new ArrayList(set);
    }
}
