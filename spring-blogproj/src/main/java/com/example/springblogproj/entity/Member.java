package com.example.springblogproj.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb1_members")
@EqualsAndHashCode(of = "uid")
@ToString

public class Member{

    @Id

    private String uid;

    private String uname;

    private String upw;

    @CreationTimestamp
    private LocalDateTime regdate;
    @UpdateTimestamp
    private LocalDateTime updatedate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="member")
    private List<MemberRole> roles;
}
