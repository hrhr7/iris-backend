package iris.board.dto.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBoardDTO {
    private Long index;
    private String memberId;
    private String category;
    private String startDate;
    private String endDate;
    private String title;
    private String content;
//    private String createTime;
}
