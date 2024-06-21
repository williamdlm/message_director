package com.github.williamdlm.message_director.hl7.fhir.parser;

import com.github.williamdlm.message_director.hl7.common.FhirContextProvider;
import org.springframework.stereotype.Component;

@Component
public class FhirR5Parser extends FhirParser {
    public FhirR5Parser() {
        super(FhirContextProvider.R5);
    }
}
