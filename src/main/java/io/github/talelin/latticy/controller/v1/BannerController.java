package io.github.talelin.latticy.controller.v1;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RequestMapping("/v1/banner")
@RestController
@Validated
public class BannerController {
    @GetMapping("/page")
    public void getBanners(@RequestParam(required = false, defaultValue = "0")
                           @Min(value = 0) Integer page,
                           @RequestParam(required = false, defaultValue = "1")
                           @Min(value = 1, message = "{page.count.min}")
                           @Max(value = 30, message = "{page.count.max}") Integer count) {


    }
}
