package iris.board.entity;

import com.sun.istack.NotNull;
import iris.board.common.BaseTimeEntity;
import lombok.Getter;
import javax.persistence.*;

@Getter
@Entity
@Table(name = "board")
//@ToString
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_index")
    private Long index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_name")
    private Member member;

    @Column(name = "board_category")
    @NotNull
    private String category;

    @Column(name = "posting_startDate")
    private String startDate;

    @Column(name = "posting_endDate")
    private String endDate;

    @NotNull
    @Column(name = "board_title")
    private String title;

    @NotNull
    @Column(name = "board_content")
    private String content;


    public Board createBoard(Member member, String title, String category, String content, String startDate, String endDate){
        this.title = title;
        this.category = category;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;

        this.member = member;
        member.getBoardList().add(this);

        return this;
    };
}
