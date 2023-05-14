package iris.board.dto.member;

import iris.board.entity.Member;
import lombok.Getter;
/*로그인 성공시 도출되는 회원정보 DTO*/
@Getter
public class LoginResDto {
    private Long index;
    private String id;
    private String name;
    private String pwd;
    private String landLine;
    private String phone;
    private String remark;
    private String department;
    private String position;
    private String job;
    private String jobClass;

    public LoginResDto toDTO(Member member){
        this.index = member.getIndex();
        this.id = member.getId();
        this.name = member.getName();
        this.pwd = member.getPwd();
        this.landLine = member.getLandLine();
        this.phone = member.getPhone();
        this.remark = member.getRemark();
        this.department = member.getDepartment();
        this.position = member.getPosition();
        this.job  = member.getJob();
        this.jobClass = member.getJobClass();
        return this;
    }
}
