package com.example.springblogproj;


import com.example.springblogproj.entity.Member;
import com.example.springblogproj.entity.MemberRole;
import com.example.springblogproj.repository.MemberRepository;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.web.servlet.oauth2.login.OAuth2LoginSecurityMarker;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest
@Commit
@Log
public class MemberTest {

    @Autowired
    private MemberRepository repo;

    @Test
    public void testInsert(){

        for(int i=0; i<=100; i++){

            Member member = new Member();
            member.setUid("user"+i);
            member.setUname("사용자" +i);
            member.setUpw("비밀번호 "+i);

            MemberRole role = new MemberRole();
            if( i <=80)
                role.setRoleName("BASIC");
            else if(i <=90)
                role.setRoleName("Manager");
            else
                role.setRoleName("Admin");
            member.setRoles(Arrays.asList(role));

            repo.save(member);
        }
    }

}
