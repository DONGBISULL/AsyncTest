package com.example.async.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 1) 빈을 프록시 객체로 랩핑하여 사용해야만 비동기 방식으로 작동함!!
 * * * 빈 주입 방식을 사용
 * => 3번 방식에서 비동기적으로 실행되지 않는 것 인지해야함 !!!
 * 2) @Async 사용시 public 사용해아함!
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AsyncService {

    private final EmailService emailService;

    // 빈주입 방식
    public void asyncCall_1() {
        log.info("[asyncCall_1] " + Thread.currentThread().getName());
        /*
          순수한 빈 Async 서비스에 반환하는 것 X
          EmailService => 프록시 객체로 반환
          - 비동기로 동작할 수 있게 sub Thread 에게 위임
          - emailService.sendMail();
          => 이를 위해서 Spring에 등록된 빈으로 사용해야 함 !!!
        */
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    /**
     * 동일한 스레드 사용
     */
    public void asyncCall_2() {
        log.info("[asyncCall_2] " + Thread.currentThread().getName());
        EmailService emailService = new EmailService();
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    /**
     * 동일한 스레드 사용
     */
    //    async 어노테이션 붙은 내부 메서드 실행
    public void asyncCall_3() {
        /*
         빈을 가져왔고 해당 빈 안에 있는 메소드에 다이렉트 접근
         -> 스프링 프레임워크 도움 안 받음
         */
        log.info("[asyncCall_3] " + Thread.currentThread().getName());
        sendMail();
    }

    /*
        @Async
        많은 요청을 빠르게 다양하게 분산해서 병렬적으로 처리하기 위해 사용
    */
    @Async
    public void sendMail() {
        log.info("sendMail >>>> " + Thread.currentThread().getName());
    }

}
