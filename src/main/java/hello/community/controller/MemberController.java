package hello.community.controller;

import hello.community.domain.Member;
import hello.community.dto.MemberSaveReqdto;
import hello.community.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMember(@RequestBody MemberSaveReqdto memberSaveReqdto) {
        Member member = memberService.create(memberSaveReqdto);
        //toString을 이용해서 문자열 응답하지만 추후에 json 형식으로도 변환하여 가져오도록 생각해보자
        return new ResponseEntity<>(member.getId(), HttpStatus.CREATED);
    }

}
