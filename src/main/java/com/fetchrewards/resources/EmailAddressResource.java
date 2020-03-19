package com.fetchrewards.resources;

import com.fetchrewards.dto.EmailRequest;
import com.fetchrewards.dto.EmailResponse;
import com.fetchrewards.services.EmailAddressParser;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="FetchRewards assessement API", description="Rest API for FetchRewards assessement")
public class EmailAddressResource {

    @Autowired
    private MeterRegistry meterRegistry;

    @Autowired
    private EmailAddressParser emailAddressParser;

    @ApiOperation(value = "Unique email API", response = EmailResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful"),
        @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping(value = "/uniqueEmails", produces = "application/json")
    @ResponseBody
    public ResponseEntity parseEmailAddress(@RequestBody EmailRequest emailRequestList) {

        meterRegistry.counter("parseEmailAddress").increment();

        EmailResponse uniqueEmailAddress = emailAddressParser.removeDuplicateEmailAddress(emailRequestList.getEmailAddress());

        return new ResponseEntity<>(uniqueEmailAddress, HttpStatus.OK);
    }
}
