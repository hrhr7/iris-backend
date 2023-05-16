package iris.board.controller;

import iris.board.dto.board.BoardDTO;
import iris.board.dto.board.CreateBoardDTO;
import iris.board.dto.board.PagingBoardDTO;
import iris.board.entity.Board;
import iris.board.response.DefaultResponse;
import iris.board.response.DefaultResponseMessage;
import iris.board.response.StatusCode;
import iris.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {
    private final BoardService boardService;

    /*게시글 작성*/
    @PostMapping("/write")
    public ResponseEntity<DefaultResponse<Object>> writeBoard(@Validated @RequestBody CreateBoardDTO createBoardDTO){
        boardService.createBoard(createBoardDTO);
        return new ResponseEntity<>(DefaultResponse.res(StatusCode.OK, DefaultResponseMessage.SUCCESS_CREATE_BOARD),HttpStatus.OK);
    }

    /*게시글 삭제*/
    @DeleteMapping("/delete/{index}")
    public ResponseEntity<DefaultResponse<Object>> deleteBoard(@PathVariable Long index){
        boardService.deleteBoard(index);
        return new ResponseEntity<>(DefaultResponse.res(StatusCode.OK, DefaultResponseMessage.SUCCESS_DELETE_BOARD),HttpStatus.OK);

    }
    /*게시글 수정*/
    @PutMapping("/edit/{index}")
    public ResponseEntity<DefaultResponse<Object>> updateBoard(@PathVariable Long index){
        return new ResponseEntity<>(DefaultResponse.res(StatusCode.OK, DefaultResponseMessage.SUCCESS_UPDATE_BOARD),HttpStatus.OK);
    }

    /*게시글 검색*/
    @GetMapping("/search")
    public ResponseEntity<DefaultResponse<Object>> search(String category){

        List<Board> searchList = boardService.search(category);
        return new ResponseEntity<>(DefaultResponse.res(StatusCode.OK, DefaultResponseMessage.SUCCESS_SEARCH_BOARD),HttpStatus.OK);
    }
    /*게시글 조회*/
    @GetMapping("/list")
    public ResponseEntity<DefaultResponse<Object>> boardList(Pageable pageable){
        PagingBoardDTO pagingBoardDTO = boardService.searchAll(pageable);
        return new ResponseEntity<>(DefaultResponse.res(StatusCode.OK, DefaultResponseMessage.SUCCESS_SEARCH_BOARD,pagingBoardDTO),HttpStatus.OK);

    }

    /*게시글 상세페이지 조회*/
    @GetMapping("/detail/{index}")
    public ResponseEntity<DefaultResponse<Object>> boardDetail(@PathVariable Long index){
        BoardDTO boardDetail =boardService.selectByIndex(index);
        return new ResponseEntity<>(DefaultResponse.res(StatusCode.OK,DefaultResponseMessage.SUCCESS_SEARCH_BOARD,boardDetail),HttpStatus.OK);
    }
}
