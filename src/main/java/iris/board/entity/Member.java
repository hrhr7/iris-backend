package iris.board.entity;

import com.sun.istack.NotNull;
import iris.board.common.BaseTimeEntity;
import iris.board.dto.member.UpdateMemberDTO;
import lombok.Getter;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "member")
//@ToString
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_index")
    private Long index;

    @Column(name = "member_id")
    @NotNull
    private String id;

    @Column(name = "member_pwd")
    @NotNull
    private String pwd;

    @Column(name = "member_name")
    @NotNull
    private String name;

    @Column(name = "member_landLine")
    private String landLine;

    @Column(name = "member_phone")
    @NotNull
    private String phone;

    @Column(name = "member_remark")
    private String remark;

    @Column(name = "member_dpt")
    @NotNull
    private String department;

    @Column(name = "member_job")
    @NotNull
    private String job;

    @Column(name = "member_position")
    @NotNull
    private String position;

    @Column(name = "member_class")
    @NotNull
    private String jobClass;


    @OneToMany(mappedBy = "member")
    private List<Board> boardList = new ArrayList<>();

    public void editMember(String name,UpdateMemberDTO updateMemberDTO){
//        this.id = updateMemberDTO.getId();
//        this.name = updateMemberDTO.getName();
        this.name = name;
        this.landLine= updateMemberDTO.getLandLine();
        this.phone = updateMemberDTO.getPhone();
        this.department = updateMemberDTO.getDepartment();
        this.job = updateMemberDTO.getJob();
        this.position = updateMemberDTO.getPosition();
        this.jobClass = updateMemberDTO.getJobClass();
        this.remark = updateMemberDTO.getRemark();
    }



}
