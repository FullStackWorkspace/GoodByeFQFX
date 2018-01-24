package cn.fqfx.GoodByeFQFX.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestTask {


    @Scheduled(fixedRate = 10000000L)
    public void Test1() {
        log.debug("TEST TEST TEST TEST");
    }
}
