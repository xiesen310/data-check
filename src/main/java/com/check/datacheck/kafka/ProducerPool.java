package com.check.datacheck.kafka;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author 谢森
 * @Description kafka 生产者连接池
 * @className com.check.datacheck.kafka.ProducerPool
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/6 14:33 星期五
 */
public class ProducerPool implements Closeable {
    private CustomProducer[] pool;

    private int threadNum = 15;
    /**
     * 轮循id
     */
    private int index = 0;

    private static ProducerPool interance = null;

    public static ProducerPool getInstance() {
        if (interance == null) {
            interance = new ProducerPool();
        }
        return ProducerPool.interance;
    }

    private ProducerPool() {
        init();
    }

    public void init() {
        pool = new CustomProducer[threadNum];
        for (int i = 0; i < threadNum; i++) {
            pool[i] = new CustomProducer();
        }
    }

    public CustomProducer getProducer() {
        Integer size = 65535;
        if (index > size) {
            index = 0;
        }
        return pool[index++ % threadNum];
    }

    @Override
    public void close() throws IOException {

    }
}
