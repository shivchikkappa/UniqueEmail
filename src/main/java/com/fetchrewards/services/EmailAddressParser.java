package com.fetchrewards.services;

import com.fetchrewards.dto.EmailResponse;

import java.util.List;

public interface EmailAddressParser {

    EmailResponse removeDuplicateEmailAddress(List<String> emailAddress);
}
