package com.zsmypb.eight.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author zhangs.
 * @date 2020/4/10.
 */
public class LambdaTest {
    public static void main(String[] args) throws IOException {
        Runnable runnable = () -> System.out.println("zzzz");
        Predicate<String> p = (String s) -> s.equals("1");
        boolean test = p.test("1");
        System.out.println(test);
        runnable.run();
        FunctionInterfaceTest test1 = (String s1, String s2) -> {
            System.out.println(s1 + s2);
        };
        test1.test("1", "2");
        Function<String, Integer> f = (String s) -> s.length();
        System.out.println(f.apply("sjdjsdjsdj"));

        // processFile(BufferedReader::readLine);

    }

    public static String processFile(BufferReaderProcessInterface p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(""))) {
            return p.process(br);
        }
    }
}
