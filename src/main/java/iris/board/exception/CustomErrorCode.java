package iris.board.exception;

import iris.board.response.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 사용자 정의 예외 처리 상수 클래스
 */
@Getter
@AllArgsConstructor
public enum CustomErrorCode {
    EMPTY_ID(StatusCode.BAD_REQUEST, "M01", "아이디가 없습니다"),
    EMPTY_PASSWORD(StatusCode.BAD_REQUEST, "M02", "비밀번호가 없습니다"),
    EMPTY_MEMBER(StatusCode.BAD_REQUEST, "M03", "아이디 또는 비밀번호를 찾을 수 없습니다"),
    EMPTY_BOARD(StatusCode.BAD_REQUEST, "B001", "조회한 게시글이 존재하지 않습니다");


    private final int status;
    private final String code;
    private final String message;
}
