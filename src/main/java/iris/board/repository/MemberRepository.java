package iris.board.repository;

import iris.board.dto.member.UpdateMemberDTO;
import iris.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findById(String id);
    List<Member> findByPwd(String pwd);
//    List<Member> findByIdAndPassword(String id, String pwd);

    //회원 고유 인덱스로 사람 찾기
    Optional<Member> findByIndex(Long index);
    List<Member> searchById(String id);

//    Optional<Member> findById(String id);

    // 회원 index로 마이페이지 수정
    @Modifying
    @Query("UPDATE Member m SET m.name = :#{#paramMember.name}," +
            "m.landLine = :#{#paramMember.landLine},"+
            "m.phone = :#{#paramMember.phone},"+
            "m.department = :#{#paramMember.department},"+
            "m.job = :#{#paramMember.job},"+
            "m.position = :#{#paramMember.position},"+
            "m.jobClass = :#{#paramMember.jobClass},"+
            "m.remark = :#{#paramMember.remark}")
    Integer updateMember(@Param("paramMember") UpdateMemberDTO member);

}
