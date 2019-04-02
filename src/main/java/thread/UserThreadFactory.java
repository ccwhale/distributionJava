package thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xingxi
 * @date 2019-03-14 10:23:02 星期四
 */
@Slf4j
public class UserThreadFactory implements ThreadFactory {
    // final属性需要在构造函数中实例化或者直接赋值
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger();


    public UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "UserThreadFactory's" + whatFeatureOfGroup + "-work-";
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(r, name);
        return thread;
    }

    class Task implements Runnable {
        private final AtomicLong count = new AtomicLong(0L);

        @Override
        public void run() {
            log.info("running_" + count.getAndIncrement());
        }
    }
}
