package com.example.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AppConfig {
    /**
     * destroyMethod
     * thread pool 이 정리가 안될 경우 방지 위해 destory method 설정
     */
    @Bean(name = "defaultTaskExcutor", destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor defaultTaskExcutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(10);
        executor.setCorePoolSize(200);
        executor.setMaxPoolSize(300);
//        executor.setKeepAliveSeconds(10);
//        executor.setQueueCapacity(100); // Queue 에 몇개씩 담을 건지
        return executor;
    }

    @Bean(name = "messageTaskExcutor", destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor messageTaskExcutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(200);
        executor.setMaxPoolSize(300);
        return executor;
    }
}
