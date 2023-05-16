package iris.board.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass //매핑정보만 상속받는 의미
@EntityListeners(AuditingEntityListener.class) // 엔티티 db적용 전, 커스텀 콜백 요청
@Getter
@NoArgsConstructor // 파라미터 없는 기본 생성자 생성
@AllArgsConstructor //모든 필드값을 파라미터로 받는 생성자 생성
@SuperBuilder
public class BaseTimeEntity {
    //생성시간
    @CreatedDate
    @JsonProperty("create_time")
    protected LocalDateTime createTime;

    //수정시간
    @LastModifiedDate
    @JsonProperty("update_time")
    protected  LocalDateTime updateTime;
}
