package org.zerok.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.Identity;

@Getter
@Setter
@Entity
@Table(name ="tb1_pdsfiles")
@EqualsAndHashCode(of="fno")

public class PDSFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long fno;

    private String pdsfile;
}
