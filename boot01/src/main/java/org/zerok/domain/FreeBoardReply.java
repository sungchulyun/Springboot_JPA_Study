package org.zerok.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "tb1_free_replies")
@ToString(exclude = "board`")
@EqualsAndHashCode(of = "rno")
public class FreeBoardReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long rno;

    private String reply;

    private String replyer;

    @CreationTimestamp
    private Timestamp replydate;

    @UpdateTimestamp
    private Timestamp updatedate;

    @ManyToOne
    private FreeBoard board;
}
