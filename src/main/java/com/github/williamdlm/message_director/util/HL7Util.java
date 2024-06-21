package com.github.williamdlm.message_director.util;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.util.Terser;
import com.github.williamdlm.message_director.enums.DataFormat;
import com.github.williamdlm.message_director.exception.FileTypeNotFoundException;

public class HL7Util {

    public static DataFormat findType(String resource) {
        resource = resource.trim();
        if (resource.startsWith("{")) {
            return DataFormat.JSON;
        } else if (resource.startsWith("<")) {
            return DataFormat.XML;
        }else if(resource.startsWith("MSH")){
            return DataFormat.HL7_PIPE_ENCODING;
        }
        throw new FileTypeNotFoundException();
    }


    public static boolean isHl7v25(Message message) throws HL7Exception {
        Terser terser = new Terser(message);
        String version = terser.get("/MSH-12");
        if(version.equals("2.5"))
            return true;
        return false;
    }
}
