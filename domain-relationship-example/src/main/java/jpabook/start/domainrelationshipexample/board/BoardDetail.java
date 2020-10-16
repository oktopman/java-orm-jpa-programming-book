package jpabook.start.domainrelationshipexample.board;

import javax.persistence.*;

@Entity
@Table(name = "board_detail")
public class BoardDetail {

    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "board_id")
    private Board board;

    private String content;
}
