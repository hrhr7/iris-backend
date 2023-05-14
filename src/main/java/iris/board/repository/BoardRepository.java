package iris.board.repository;

import iris.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface BoardRepository extends JpaRepository<Board, Long> {

    void deleteByIndex(Long index);

    /*검색*/
    List<Board> findByCategoryContaining(String category);

    Optional<Board> findByIndex(Long index);
}
