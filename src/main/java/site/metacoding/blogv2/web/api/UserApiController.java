package site.metacoding.blogv2.web.api;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.service.UserService;
import site.metacoding.blogv2.web.api.dto.ResponseDto;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// ApiController 는 제이슨 리턴 전용 컨트롤러이다.

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;

    // 회원가입
    @PostMapping("/join")
    public ResponseDto<String> join(@RequestBody JoinDto joinDto) {
        // System.out.println(joinDto);
        userService.회원가입(joinDto);
        return new ResponseDto<String>(1, "회원가입성공", null);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseDto<String> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        User userEntity = userService.로그인(loginDto);

        if (userEntity == null) {
            return new ResponseDto<String>(-1, "로그인실패", null);
        }

        // 쿠키 로직
        if (loginDto.getRemember().equals("on")) {
            response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() + "; path=/");
        }
        // response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() + ";
        // path=/; httpOnly=true");
        // response.addHeader("Set-Cookie", "path/=");

        // addHeader 대신 addCookie 사용 가능
        // Cookie cookie = new Cookie("remember", loginDto.getUsername());
        // cookie.setPath("/");
        // response.addCookie(cookie);

        session.setAttribute("principal", userEntity);
        return new ResponseDto<String>(1, "로그인성공", null);
    }

}
