package com.github.williamdlm.message_director.hl7.fhir.validation;

import com.github.williamdlm.message_director.hl7.common.FhirContextProvider;
import org.springframework.stereotype.Component;

@Component
public class FhirR4BInstanceValidation extends FhirInstanceValidation {
    public FhirR4BInstanceValidation() {
        super(FhirContextProvider.R4B);
    }
}
