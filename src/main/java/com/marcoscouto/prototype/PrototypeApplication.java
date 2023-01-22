package com.marcoscouto.prototype;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.task.TaskExecutor;

import static com.marcoscouto.prototype.ThreadLocalHolder.getPrototypeData;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

@Slf4j
@SpringBootApplication
public class PrototypeApplication implements CommandLineRunner, Runnable {

    private final TaskExecutor executor;

    public PrototypeApplication(TaskExecutor executor) {
        this.executor = executor;
    }


    public static void main(String[] args) {
        SpringApplication.run(PrototypeApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        executor.execute(this); // execute first thread
        waitFiveSeconds();
        executor.execute(this); // execute second thread
        waitFiveSeconds();
        executor.execute(this); // execute third thread
    }

    @Override
    public void run() {
        log.info("{} - get prototype value 1 {}, object {}", currentThread(), getPrototypeData().getReference(), getPrototypeData());
        log.info("{} - get prototype value 2 {}, object {}", currentThread(), getPrototypeData().getReference(), getPrototypeData());
    }

    @SneakyThrows
    private void waitFiveSeconds(){
        sleep(5000L);
    }
}
