package com.github.williamdlm.message_director.pojo.parser;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import org.hl7.fhir.instance.model.api.IBaseResource;

public abstract class FhirParser {
    private FhirContext context;
    private IParser parser;

    public FhirParser(FhirContext context) {
        this.context = context;
    }

    public IBaseResource toParser(String input, String formatType) {
        if (formatType.equalsIgnoreCase("xml"))
            parser = context.newXmlParser();

        if (formatType.equalsIgnoreCase("json"))
            parser = context.newJsonParser();

        return parser.parseResource(input);
    }


}
