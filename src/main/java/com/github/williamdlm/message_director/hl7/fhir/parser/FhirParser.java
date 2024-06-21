package com.github.williamdlm.message_director.hl7.fhir.parser;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import com.github.williamdlm.message_director.enums.DataFormat;
import com.github.williamdlm.message_director.pojo.Utils;
import org.hl7.fhir.instance.model.api.IBaseResource;

public abstract class FhirParser {
    private FhirContext context;
    private IParser parser;

    public FhirParser(FhirContext context) {
        this.context = context;
    }

    public IBaseResource toParser(String input) {
        if (Utils.findType(input).equals(DataFormat.XML))
            parser = context.newXmlParser();

        if (Utils.findType(input).equals(DataFormat.JSON))
            parser = context.newJsonParser();

        return parser.parseResource(input);
    }


}
