package site.metacoding.blogv2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.domain.user.UserRepository;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;

@RequiredArgsConstructor
@Service // 컴포넌트 스캔시에 IoC 컨테이너에 등록됨 // 트랜잭션 관리하는 오브젝트임. 기능을 넣어두는 모임
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(JoinDto joinDto) {
        // save하면 db에 insert하고 insert된 결과를 다시 return해준다
        userRepository.save(joinDto.toEntity());
    } // 응답을 해줘야 되면 user 안해도 되면 void

}
