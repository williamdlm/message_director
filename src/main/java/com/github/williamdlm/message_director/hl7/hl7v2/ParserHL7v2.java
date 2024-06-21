package com.github.williamdlm.message_director.hl7.hl7v2;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
import ca.uhn.hl7v2.parser.PipeParser;
import com.github.williamdlm.message_director.enums.DataFormat;
import com.github.williamdlm.message_director.exception.FileTypeNotFoundException;
import com.github.williamdlm.message_director.exception.InvalidHL7VersionException;
import com.github.williamdlm.message_director.util.HL7Util;

public class ParserHL7v2 {

    public static Message toParser(String resource) throws HL7Exception {
        HapiContext context = new DefaultHapiContext();
        CanonicalModelClassFactory mcf = new CanonicalModelClassFactory("2.5");
        context.setModelClassFactory(mcf);


        Message message = null;
        if (HL7Util.findType(resource).equals(DataFormat.HL7_PIPE_ENCODING)) {
            PipeParser pipeParser = context.getPipeParser();
            message = pipeParser.parse(resource);
            if (!HL7Util.isHl7v25(message)) {
                throw new InvalidHL7VersionException();
            }
            return message;
        }
        throw new FileTypeNotFoundException();
    }
}
