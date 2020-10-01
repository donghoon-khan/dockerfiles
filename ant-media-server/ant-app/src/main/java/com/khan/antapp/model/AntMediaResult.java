package com.khan.antapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AntMediaResult {
    
    private Boolean success;
    private String message;
    private String dataId;
    private int errId;

    public Boolean isSuccess() {
        return success;
    }
}
