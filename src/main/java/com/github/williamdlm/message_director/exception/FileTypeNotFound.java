package com.github.williamdlm.message_director.exception;

public class FileTypeNotFound extends RuntimeException {
    public FileTypeNotFound(){
        super("File type not found");
    }
}
