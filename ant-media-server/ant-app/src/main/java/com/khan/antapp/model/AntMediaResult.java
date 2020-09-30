package com.khan.antapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AntMediaResult {
    
    private boolean success;
    private String message;
    private String dataId;
    private int errId;

    public boolean isSuccess() {
        return success;
    }
}
