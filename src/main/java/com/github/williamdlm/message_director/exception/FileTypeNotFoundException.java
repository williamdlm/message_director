package com.github.williamdlm.message_director.exception;

public class FileTypeNotFoundException extends RuntimeException {
    public FileTypeNotFoundException(){
        super("File type not found");
    }
}
