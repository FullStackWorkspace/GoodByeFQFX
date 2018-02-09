package cn.fqfx.GoodByeFQFX;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class AutoIncrLockNumber {
    /**
     * 设置最大自增数
     */
    private final static Integer MAX_NUMBER = 9999;
    private AtomicInteger count;
    private AutoIncrLockNumber(){
        count = new AtomicInteger(0);
    }

    public Integer GetAndIncr(){
        Integer n = count.getAndIncrement();
        if(n.equals(MAX_NUMBER)){
            count.set(0);
        }

        return n;
    }
}
