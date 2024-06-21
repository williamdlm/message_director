package com.github.williamdlm.message_director.exception;

public class InvalidHL7VersionException extends RuntimeException {
    public InvalidHL7VersionException() {
        super("Version is invalid");
    }
}
