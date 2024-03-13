package com.example.async.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmailService {

    @Async("defaultTaskExcutor")
    public void sendMail() {
        log.info("sendMail >>>> " + Thread.currentThread().getName());
    }

    @Async("messageTaskExcutor")
    public void sendMailWithCustomThreadPool() {
        log.info("sendMailWithCustomThreadPool >>>> " + Thread.currentThread().getName());
    }

}


