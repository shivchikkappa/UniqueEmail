package com.fetchrewards.services.impl;

import com.fetchrewards.dto.EmailResponse;
import com.fetchrewards.services.EmailAddressParser;
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("EmailAddress")
public class EmailAddressParserImpl implements EmailAddressParser {

    private static final Logger LOG = LoggerFactory.getLogger(EmailAddressParserImpl.class);

    @Override
    public EmailResponse removeDuplicateEmailAddress(List<String> emailAddress) {

        final Stopwatch timer = Stopwatch.createStarted();

        try {

            //remove the @ and + symbold from the email address
            List<String> emailsParsed = new ArrayList<>();
            for (String email : emailAddress) {
                emailsParsed.add(email.split("@")[0].split("\\+")[0]);
            }

            HashMap<String, Integer> emailAddressMap = new HashMap<>();
            for (String email : emailsParsed) {
                String emailKey = email.toLowerCase().replace(".", "");
                if (emailAddressMap.containsKey(emailKey)) {
                    emailAddressMap.put(emailKey, emailAddressMap.get(emailKey) + 1);
                } else {
                    emailAddressMap.put(emailKey, 1);
                }
            }

            EmailResponse emailResponse = new EmailResponse();
            emailResponse.setUniqueEmailcount(emailAddressMap.keySet().size());

            return emailResponse;
        } finally {
            LOG.info("Time taken to find unique email address={}", timer.elapsed(TimeUnit.MILLISECONDS));
        }


    }
}
