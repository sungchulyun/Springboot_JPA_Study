package com.example.boot8;


import com.example.boot8.Repository.MemberRepository;
import com.example.boot8.domain.Member;
import com.example.boot8.domain.MemberRole;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
@Log
@Commit
public class MemberTests {

    @Autowired
    private MemberRepository repo;

    @Test
    public void testInsert(){

        for(int i =0; i<=100; i++){

            Member member = new Member();
            member.setUid("user" + i);
            member.setUpw("pw" + i);
            member.setUname("사용자" + i);

            MemberRole role = new MemberRole();
            if(i <= 80) {
                role.setRoleName("BASIC");
            }
            else if (i <= 90){
                role.setRoleName("MANAGER");
            }
            else
                role.setRoleName("ADMIN");
            member.setRoles(Arrays.asList(role));

            repo.save(member);
        }
    }

    @Test
    public void testRead(){

        Optional<Member> result = repo.findById("user85");

        result.ifPresent(member -> log.info("member" + member));

    }
}
