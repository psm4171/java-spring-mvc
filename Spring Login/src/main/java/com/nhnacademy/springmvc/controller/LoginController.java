package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.repository.UserRepository;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// TODO #1: Controller로 만드세요.
@Controller
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // TODO #2: `GET /login` 요청을 처리하세요.
    //          `SESSION` 이라는 쿠키가 있으면 로그인 완료 메세지 출력 (`loginSuccess.jsp`).
    //          `SESSION` 이라는 쿠키가 없으면 로그인 폼 화면 출력 (`loginForm.jsp`).
    @GetMapping("/login")
    public String login(@CookieValue(value ="SESSION", required = false) String sessionId) {
        // required 설정이 안되어있으면 null값이 존재할 경우, 404에러가 발생하는데 이것을 false로 방지
        if(sessionId != null){
           // return "redirect:/loginSuccess.jsp";
            return "loginSuccess";
        }
            //return "redirect:/loginForm.jsp";
            return "loginForm";
    }


    // TODO #3: `POST /login` 요청을 처리하세요.
    //          `userRepository.matches(id, password)` 메서드 이용.
    //          로그인 성공 시 `SESSION` 쿠키에 session id 값 저장하고
    //          모델을 이용해서 `loginSuccess.jsp`에 세션 아이디 전달.
    //          로그인 실패 시 `/login`으로 redirect.
    @PostMapping("/login")
    // requestParam으로 id와 pwd를 지정 / loginForm 입력과 맞춰서 설정
    public String doLogin(@RequestParam("id") String id,
                          @RequestParam("pwd") String password,
                          ModelMap modelMap, // 뷰에 저장하게 될 모델 맵
                          HttpServletRequest request,
                          HttpServletResponse response) {

       if(userRepository.matches(id, password)){
           HttpSession session = request.getSession(true); // 세션을 뽑아내는 getSession
           response.addCookie(new Cookie("SESSION", session.getId()));
           modelMap.addAttribute("id", id);

           return "loginSuccess";
       }
           return "redirect:/login";
    }
}
