package io.shs0160.controller;

import io.shs0160.app.Chief;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontDesk {

    private final Chief chief;

    public FrontDesk(Chief chief) {
        this.chief = chief;
    }

    //doGet
    @GetMapping("/hall")
    public String orderCuisine(
            //파라미터가 필요하다는걸 인지 -> 파라미터 강요 -> 없으면 오류
            //required = false 로 주면 매개변수가 강제가 안됨 -> 매개변수으면 null로 들어감
            @RequestParam(name="ingredients", required = false) List<String> ingredients

    ) {

        //Optional로 해결 가능
        if(ingredients != null) {
            System.out.println("요리 완료");
            chief.cook(ingredients);
        }

        System.out.println("홀로 출발");
        return "hall";
        //view 파일 경로를 찾음 -> templateEngine에서


        //html 파일 이름(view)만 지정해줌
    }

    @GetMapping("/check-exp")
    public void checkExp(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws Exception {
        int currentExp = chief.checkExp();

        PrintWriter writer = resp.getWriter();

        //응답 본문에 직접 값을 넣어줘서 오류가 나지 않음
        System.out.println("current exp : " + currentExp);
    }

}
