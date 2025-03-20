package hello.community.service;

import hello.community.domain.Member;
import hello.community.dto.MemberSaveReqdto;
import hello.community.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //생성 시 이미 가입된 이메일인지 검증
    public Member create(MemberSaveReqdto memberSaveReqdto) {
        if(memberRepository.findByEmail(memberSaveReqdto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다");
        }
        Member newmember = Member.builder()
                .email(memberSaveReqdto.getEmail())
                .name(memberSaveReqdto.getName())
                .password(memberSaveReqdto.getPassword())
                .build();

        Member member = memberRepository.save(newmember);
        return member;
    }
}
