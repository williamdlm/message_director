package com.github.williamdlm.message_director.hl7.fhir.parser;

import com.github.williamdlm.message_director.hl7.common.FhirContextProvider;
import org.springframework.stereotype.Component;

@Component
public class FhirR4BParser extends FhirParser {
    public FhirR4BParser() {
        super(FhirContextProvider.R4B);
    }
}
