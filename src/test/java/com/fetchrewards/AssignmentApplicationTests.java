package com.fetchrewards;

import com.fetchrewards.dto.EmailResponse;
import com.fetchrewards.services.EmailAddressParser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AssignmentApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private EmailAddressParser emailAddressParser;

    @Test
    public void testUniqueEmailCount(){

        List<String> emailAddress = new ArrayList<>();
        emailAddress.add("test.email@gmail.com");
        emailAddress.add("test.email+spam@gmail.com");
        emailAddress.add("TesteMail@gmail.com");

        EmailResponse emailResponse = emailAddressParser.removeDuplicateEmailAddress(emailAddress);
        Assert.assertEquals(1,emailResponse.getUniqueEmailcount());
    }

}
