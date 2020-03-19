package com.fetchrewards.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class EmailResponse {

    @ApiModelProperty(notes = "Count of unique email address")
    private int uniqueEmailcount;

    public int getUniqueEmailcount() {
        return uniqueEmailcount;
    }

    public void setUniqueEmailcount(int uniqueEmailcount) {
        this.uniqueEmailcount = uniqueEmailcount;
    }
}
