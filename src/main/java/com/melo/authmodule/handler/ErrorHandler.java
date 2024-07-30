package com.melo.authmodule.handler;

import com.melo.authmodule.error.ErrorLogRepository;
import com.melo.authmodule.error.ErrorLog;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ErrorHandler {

    @Autowired
    private ErrorLogRepository errorLogRepository;

    public void logError(Exception e) {
        ErrorLog errorLog = new ErrorLog(e.getMessage(), ExceptionUtils.getStackTrace(e));
        errorLogRepository.save(errorLog);
    }
}

