package com.github.williamdlm.message_director.pojo.hl7v2;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
import ca.uhn.hl7v2.parser.PipeParser;
import com.github.williamdlm.message_director.enums.DataFormat;
import com.github.williamdlm.message_director.exception.FileTypeNotFound;
import com.github.williamdlm.message_director.pojo.Utils;

public class ParserHL7v2 {

    public static Message toParser(String resource) throws HL7Exception {
        HapiContext context = new DefaultHapiContext();
        CanonicalModelClassFactory mcf = new CanonicalModelClassFactory("2.5");
        context.setModelClassFactory(mcf);

        Message message = null;
        if (Utils.findType(resource).equals(DataFormat.HL7_PIPE_ENCODING)) {
            PipeParser pipeParser = context.getPipeParser();
            message = pipeParser.parse(resource);
            return message;
        }
        throw new FileTypeNotFound();
    }
}
