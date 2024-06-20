package com.github.williamdlm.message_director.exception;

public class InvalidHL7Version extends RuntimeException {
    public InvalidHL7Version() {
        super("Version is invalid");
    }
}
