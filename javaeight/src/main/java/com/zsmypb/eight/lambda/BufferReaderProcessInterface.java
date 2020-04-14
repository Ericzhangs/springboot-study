package com.zsmypb.eight.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author zhangs.
 * @date 2020/4/10.
 */
@FunctionalInterface
public interface BufferReaderProcessInterface {
    String process(BufferedReader br) throws IOException;
}
