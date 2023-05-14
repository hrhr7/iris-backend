package iris.board.service;


import iris.board.dto.board.BoardDTO;
import iris.board.dto.board.CreateBoardDTO;
import iris.board.dto.board.PagingBoardDTO;
import iris.board.entity.Board;
import iris.board.entity.Member;
import iris.board.exception.CustomErrorCode;
import iris.board.exception.CustomException;
import iris.board.repository.BoardRepository;
import iris.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = false)
@Slf4j
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    /*게시판 작성 */
    public void createBoard(CreateBoardDTO createBoardDTO){

        //게시글 작성 할때 일치하는 아이디의 회원 조회
        Member findOne = memberRepository.findById(createBoardDTO.getMemberId());
        if(findOne == null){
            throw new CustomException(CustomErrorCode.EMPTY_MEMBER);
        }
        String member = findOne.getId();
        Board writeBoard = new Board().createBoard(findOne, createBoardDTO.getTitle(), createBoardDTO.getCategory(), createBoardDTO.getContent(), createBoardDTO.getStartDate(), createBoardDTO.getEndDate());
        boardRepository.save(writeBoard);
    }
    @Transactional
    public void deleteBoard(Long index){
        boardRepository.deleteByIndex(index);
    }
    public void updateBoard(Long index){

    }

    public List<Board> search(String category){
        List<Board> boardList = boardRepository.findByCategoryContaining(category);
        return boardList;
    }

    public BoardDTO selectByIndex(Long index){
        Board boardDetail = boardRepository.findByIndex(index).orElseThrow(()->
                new CustomException(CustomErrorCode.EMPTY_BOARD));
        return new BoardDTO().toDTO(boardDetail);
    }
    /*페이징처리*/
    public PagingBoardDTO searchAll(Pageable pageable){
        List<BoardDTO> boardDTOList = new ArrayList<>();
        Page<Board> pageList = boardRepository.findAll(pageable);

        List<Board> boardList = pageList.getContent();
        Integer totalPages = pageList.getTotalPages();
        Integer page = pageList.getNumber()+1;
        Long totalResults = pageList.getTotalElements();

        for(Board e : boardList){
            BoardDTO boardDTO = new BoardDTO().toDTO(e);
            boardDTOList.add(boardDTO);
        }
        PagingBoardDTO pagingBoardDTO = new PagingBoardDTO().toPageDTO(page, totalPages, totalResults, boardDTOList);
        return  pagingBoardDTO;

    }
}
