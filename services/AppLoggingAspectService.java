package ru.alexander_kramarenko.java_web_shop.services;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;



import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Aspect
@Service
@RequiredArgsConstructor
public class AppLoggingAspectService {

    private String classCalled;

    private Map<String, Long> totalDurations = new HashMap<>();

    private List keyCallResult = new ArrayList();

    @Around("execution(public * ru.alexander_kramarenko.java_web_shop.services.*.*(..))")
    public Object methodProfiling1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        classCalled = proceedingJoinPoint.getTarget().getClass().getName();
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        if (totalDurations.containsKey(classCalled)) {
            totalDurations.put(classCalled, totalDurations.get(classCalled) + duration);
        } else {
            totalDurations.put(classCalled, duration);
        }
        ;
        return out;
    }

    public List getClassCallStatitic() {

        List<String> keyListResult = totalDurations.keySet().stream()
                .collect(Collectors.toList());

        List<Long> callListResult = totalDurations.values().stream()
                .collect(Collectors.toList());

        keyCallResult.clear();

        for (int i = 0; i < keyListResult.size(); i++) {
            keyCallResult.add(Arrays.asList(keyListResult.get(i), callListResult.get(i)));

        }

        return keyCallResult;
    }
}
