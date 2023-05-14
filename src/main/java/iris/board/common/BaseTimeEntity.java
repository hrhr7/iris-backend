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

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
