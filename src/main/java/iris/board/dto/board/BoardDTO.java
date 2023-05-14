package iris.board.dto.board;

import iris.board.entity.Board;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class BoardDTO {
    private Long index;
    private String category;
    private String id;
    private String name;
    private String title;
    private String content;
    private String startDate;
    private String endDate;
    private String createTime;

    public BoardDTO toDTO(Board board){
        this.index = board.getIndex();
        this.category = board.getCategory();
        this.id = board.getMember().getId();
        this.name = board.getMember().getName();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.startDate = board.getStartDate();
        this.endDate = board.getEndDate();
        this.createTime = board.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return this;
    }
}
