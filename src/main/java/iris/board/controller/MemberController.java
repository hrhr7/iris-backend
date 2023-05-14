package iris.board.controller;

import iris.board.dto.member.LoginDto;
import iris.board.dto.member.LoginResDto;
import iris.board.dto.member.MemberDto;
import iris.board.dto.member.UpdateMemberDTO;
import iris.board.entity.Member;
import iris.board.response.DefaultResponse;
import iris.board.response.DefaultResponseMessage;
import iris.board.response.StatusCode;
import iris.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")

public class MemberController {
    private final MemberService memberService;

    /*단일 회원 조회(마이페이지 조회용)*/
    @GetMapping( "/findId")
    public ResponseEntity<DefaultResponse<Object>> memberList(@RequestBody MemberDto memberDto){
        List<MemberDto> memberDtoList = memberService.memberList(memberDto);
        return new ResponseEntity<>(DefaultResponse.res(StatusCode.OK,DefaultResponseMessage.SUCCESS_SEARCH_MEMBER,memberDtoList),HttpStatus.OK);
    }
    /*로그인*/
    @PostMapping("/login")
    public ResponseEntity<DefaultResponse<Object>> login (@Validated @RequestBody LoginDto loginDto){
        LoginResDto loginResDto = memberService.login(loginDto);
        return new ResponseEntity<>(DefaultResponse.res(StatusCode.OK, DefaultResponseMessage.SUCCESS_LOGIN, loginResDto), HttpStatus.OK);
    }
    /*회원정보 수정*/
    @PostMapping("/update")
    public ResponseEntity<DefaultResponse<Object>> updateMyPage(@RequestBody UpdateMemberDTO updateMemberDTO){

        memberService.updateMypage(updateMemberDTO);
        return new ResponseEntity<>(DefaultResponse.res(StatusCode.OK,DefaultResponseMessage.SUCCESS_UPDATE_MEMBER), HttpStatus.OK);
    }
}
