package com.example.springblogproj.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb1_member_roles")
@EqualsAndHashCode(of = "info")
@ToString

public class MemberRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long info;

    private String roleName;

}
