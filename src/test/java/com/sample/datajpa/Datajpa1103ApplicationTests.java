package com.sample.datajpa;

import com.sample.datajpa.repository.UserRepository;
import com.sample.datajpa.to.UserAdminsInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Datajpa1103ApplicationTests {

    public static final UserAdminsInfo UA_INFO = new UserAdminsInfo("mark", 1, "comment");

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveAdminInfo() {
        Assert.assertEquals(1,
                userRepository.saveAdminInfo("user@gmail.com", "mark", 1, "comment"));
    }

    @Test
    public void saveAdminInfoBind() {
        Assert.assertEquals(1,
                userRepository.saveAdminInfoBind(UA_INFO));
    }

    @Test
    public void saveAdminInfoMixBindBug() {
        Assert.assertEquals(1,
                userRepository.saveAdminInfoMixBind("user@gmail.com", UA_INFO));
    }
}
