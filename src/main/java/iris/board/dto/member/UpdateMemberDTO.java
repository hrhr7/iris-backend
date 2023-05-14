package iris.board.dto.member;

import iris.board.entity.Member;
import lombok.Getter;

@Getter
public class UpdateMemberDTO {
    private String id;
    private String pwd;
    private String name;
    private String landLine;
    private String phone;
    private String department;
    private String job;
    private String position;
    private String jobClass;
    private String remark;


}
