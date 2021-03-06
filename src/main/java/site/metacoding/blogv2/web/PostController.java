package site.metacoding.blogv2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.post.Post;
import site.metacoding.blogv2.service.PostService;

@RequiredArgsConstructor
@Controller
public class PostController { // 껍데기 디자인 용도 데이터는 apicon~
    private final PostService postService;

    @GetMapping("/post/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Post postEntity = postService.글상세보기(id);
        model.addAttribute("post", postEntity);
        return "post/detail";
    }

    // 페이지를 줘
    // /s 붙었으니까 자동으로 인터셉터가 인증 체크함. (완)
    @GetMapping("/s/post/writeForm")
    public String writeForm() {
        return "post/writeForm";
    }

    @GetMapping({ "/", "/post" })
    public String home() {
        return "post/list";
    }
}