
# 비동기 프로그래밍

Async 통신
실시간성 응답 필요하지 않은 상황에 사용

Ex) Notification , Email , Push 알림

main Thread 가 task 처리하는것이 아니라
Sub Thread 에게 task 위임

비동기 => sub thead 에서 작업 진행
java ThreadPool 생성하여 async 작업 처리

## 스레드 옵션

> 1. CorePoolSize

    스레드풀에 최소한 스레드를 몇개 가지고 있을 지를 지정하는 옵션
    
    (최소한 minimum 리소스를 점유할 스레드의 사이즈)

> 2. MaxPoolSize

    최대 몇 개까지 스레드를 할당할 지 사이즈 

> 3. workQueue

    먼저 들어온 순서로 처리할 수 있도록 큐를 사용하여 많은 요청들을 담아뒀다가 순차적으로 실행

> 4. KeepAliveTime

    코어풀 사이즈보다 더 많은 스레드 할당 시 스레드 반환 
    내가 지정한 시간만큼 스레드들이 일하지 않을 경우 자원 반납시키도록 하는 옵션
    Long 타입 : 시간 분 초 설정위한 유닛 단위


참고

스레드풀: 스레드가 여러개 있는 풀

생성 순서

corePoolSize 만큼의 사이즈 스레드 생성
-> corePoolSize 사이즈를 넘치는 요청 워크큐(Oueue)에 담기
-> workQueue 사이즈만큼 새로운 요청 담기
-> (workQueue에 지정한 사이즈만큼 요청이 쌓였을 경우) 맥시멈 풀 사이즈만큼 스레드 생성


Core Pool Size 값을 크게 설정할 경우 Side Effect 고려

-> 너무 큰값 설정 시 잘 사용 안되도 많은 스레드 점유할 수도 있음

-> 사용도를 잘 파악하여 설정 해야함


# @Async
1. method 접근지정자 private 사용 불가
   - private면 프록시 객체에서 사용할 수 없어서 public 을 사용해야함 
2. self-invocation(자가 호출) 불가 , inner method 사용 불가
    - 자가 호출/inner method 의 경우 프록시가 접근하지 않기 때문에 사용할 수 없음 

Async 빈을 프로시 객체로 Wrappering 을 함 => 프록시 객체화함 
AOP로 만들어진 프록시로 객체화된 bean 참조

=> async 제대로 작동하는지 무조건 테스트 해야함 !!
