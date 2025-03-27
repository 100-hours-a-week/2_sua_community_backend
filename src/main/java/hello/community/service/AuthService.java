package hello.community.service;


import hello.community.domain.Member;
import hello.community.dto.LonginReqdto;
import hello.community.dto.LonginResponsedto;
import hello.community.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final MemberRepository memberRepository;


    public LonginResponsedto login(LonginReqdto dto) {
        //회원가입된 대상인지, 비밀번호 맞는지 검증
        Member member = memberRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("해당 회원이 존재하지 않습니다."));

        // 인증 성공 시 회원 ID 반환
        return new LonginResponsedto(member.getId());
    }

}
