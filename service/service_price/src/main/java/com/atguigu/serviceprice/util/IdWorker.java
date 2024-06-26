package com.atguigu.serviceprice.util;

public class IdWorker {

    private long workerId;
    private long datacenterId;
    private long sequence = 0;
    /**
     * 固定的时间戳，用于计算时间戳差值部分
     */
    private long twepoch = 1611072299L;

    private long workerIdBits = 5L;
    private long datacenterIdBits = 5L;
    private long sequenceBits = 12L;

    private long workerIdShift = sequenceBits;
    private long datacenterIdShift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    // 得到初始UUID，0000000000000000000000000000000000000000000000000000111111111111
    private long sequenceMask = ~(-1L << sequenceBits);

    private long lastTimestamp = -1L;


    public IdWorker(long workerId, long datacenterId){
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }
    public synchronized long nextId() {
        long timestamp = timeGen();
        //时间回拨，抛出异常处理
        //通常来说如果时间回拨时间短，比如配置5ms以内，那么可以直接等待一定的时间，让机器的时间追上来。
        //还可以利用扩展位来直接赋值
        if (timestamp < lastTimestamp) {
            System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }

        // 并发访问的控制
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }

    /**
     * 当前ms已经满了
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    // 获取当前时间
    private long timeGen(){
        return System.currentTimeMillis();
    }
    // 测试


    public IdWorker() {
    }
}


