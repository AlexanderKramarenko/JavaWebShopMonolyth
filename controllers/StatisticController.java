package ru.alexander_kramarenko.java_web_shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexander_kramarenko.java_web_shop.services.AppLoggingAspectService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/statistic")
@RequiredArgsConstructor
public class StatisticController {

    private final AppLoggingAspectService appLoggingAspectService;

    @GetMapping
    public List getStatistic() {
        return appLoggingAspectService.getClassCallStatitic();
    }

}
