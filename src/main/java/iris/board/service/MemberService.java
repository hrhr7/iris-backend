package iris.board.service;

import iris.board.dto.member.LoginDto;
import iris.board.dto.member.LoginResDto;
import iris.board.dto.member.MemberDto;
import iris.board.dto.member.UpdateMemberDTO;
import iris.board.entity.Member;
import iris.board.exception.CustomErrorCode;
import iris.board.exception.CustomException;
import iris.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public LoginResDto login(LoginDto loginResDto) {
       Member findMember = memberRepository.findById(loginResDto.getId());
        log.info("로그인아이디 " + findMember.getId());
        if (findMember == null) {
            throw new CustomException(CustomErrorCode.EMPTY_ID);
        }
        if (!findMember.getPwd().equals(loginResDto.getPwd())){
            throw new CustomException(CustomErrorCode.EMPTY_PASSWORD);
        }
        return new LoginResDto().toDTO(findMember);
    }

    //정보 수정 페이지에서 회원 단일 조회하기
    public List<MemberDto> memberList(MemberDto memberDto){
        List<MemberDto> memberDtoList = new ArrayList<>();

       List<Member> memberList = memberRepository.searchById(memberDto.getId());
        for(Member e : memberList){
            memberDtoList.add(new MemberDto().toDto(e));
        }

        return memberDtoList;
    }
    @Transactional
    public void updateMypage(UpdateMemberDTO updateMemberDTO){
        //회원 조회
        Member findOne = memberRepository.findById(updateMemberDTO.getId());

//         String editName= String.valueOf(memberRepository.findById(findOne.getId()));
        findOne.editMember(findOne.getName(),updateMemberDTO);
    }

}
