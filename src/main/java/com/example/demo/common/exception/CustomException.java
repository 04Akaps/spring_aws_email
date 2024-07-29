package com.example.demo.common.exception;



import com.example.demo.common.code.CodeInterface;
import lombok.Getter;

import java.io.Serial;

@Getter
public class CustomException extends RuntimeException {

    // @Serial
    // private static final long serialVersionUID = 8576565958644441148L;
    private final CodeInterface codeInterface;
    private boolean isAlert = true;

    public CustomException(CodeInterface codeInterface) {
        super(codeInterface.getMessage());
        this.codeInterface = codeInterface;
    }

    public CustomException(CodeInterface codeInterface, boolean isAlert) {
        this(codeInterface);
        this.isAlert = isAlert;
    }

    public CustomException(CodeInterface codeInterface, String additionalMessage) {
        super(codeInterface.getMessage() + additionalMessage);
        this.codeInterface = codeInterface;
    }

    public CustomException(CodeInterface codeInterface, String additionalMessage, boolean isAlert) {
        this(codeInterface, additionalMessage);
        this.isAlert = isAlert;
    }
}
