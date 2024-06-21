package com.github.williamdlm.message_director.hl7.fhir.parser;

import com.github.williamdlm.message_director.hl7.common.FhirContextProvider;
import org.springframework.stereotype.Component;

@Component
public class FhirStu3Parser extends FhirParser {
    public FhirStu3Parser() {
        super(FhirContextProvider.DSTU3);
    }
}
