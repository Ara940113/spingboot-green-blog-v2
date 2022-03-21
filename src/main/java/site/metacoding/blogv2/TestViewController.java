package site.metacoding.blogv2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestViewController {
    // 모든 페이지 잘 작동하는지 확인 후 푸시 - 2. 컨트롤러 페이지 작동 테스트
    @GetMapping("/post/writeForm")
    public String writeForm() {
        return "/post/writeForm";
    }

    @GetMapping("/post/updateForm")
    public String updateForm() {
        return "/post/updateForm";
    }

    @GetMapping("/post/list")
    public String list() {
        return "/post/list";
    }

    @GetMapping("/post/detail")
    public String detail() {
        return "/post/detail";
    }

    @GetMapping("/user/detail")
    public String userDetail() {
        return "/user/detail";
    }

    @GetMapping("/user/joinForm")
    public String joinForm() {
        return "/user/joinForm";
    }

    @GetMapping("/user/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String userUpdate() {
        return "/user/updateForm";
    }

}
