package com.github.williamdlm.message_director.pojo;

import com.github.williamdlm.message_director.enums.DataFormat;
import com.github.williamdlm.message_director.exception.FileTypeNotFound;

public class Utils {

    public static DataFormat findType(String resource) {
        resource = resource.trim();
        if (resource.startsWith("{")) {
            return DataFormat.JSON;
        } else if (resource.startsWith("<")) {
            return DataFormat.XML;
        }
        throw new FileTypeNotFound();
    }
}
