package iris.board.dto.member;

import iris.board.entity.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private String id;
//    private String pwd;
    private String name;
    private String landLine;
    private String phone;
    private String department;
    private String job;
    private String position;
    private String jobClass;
    private String remark;


    public MemberDto toDto(Member member){
        this.id = member.getId();
//        this.pwd = member.getPwd();
        this.name = member.getName();
        this.landLine = member.getLandLine();
        this.phone = member.getPhone();
        this.department = member.getDepartment();
        this.job = member.getJob();
        this.position = member.getPosition();
        this.jobClass = member.getJobClass();
        this.remark = member.getRemark();
        return this;
    }
}
