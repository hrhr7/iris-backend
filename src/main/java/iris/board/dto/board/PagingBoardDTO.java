package iris.board.dto.board;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/*페이징 처리 */
@Getter
public class PagingBoardDTO {
    private Integer page; // 현재페이지
    private Integer totalPages; //총 페이지
    private Long totalResults;
    private List<BoardDTO> boardDTOList = new ArrayList<>();

    public PagingBoardDTO toPageDTO(Integer page,Integer totalPages, Long totalResults, List<BoardDTO> boardDTOList){
        this.page = page;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
        this.boardDTOList = boardDTOList;

        return  this;
    }
}
