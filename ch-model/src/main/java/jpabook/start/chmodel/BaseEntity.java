package jpabook.start.chmodel;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@MappedSuperclass
public class BaseEntity {

    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
}
