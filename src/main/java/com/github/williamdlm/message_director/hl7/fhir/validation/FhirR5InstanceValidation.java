package com.github.williamdlm.message_director.hl7.fhir.validation;

import com.github.williamdlm.message_director.hl7.common.FhirContextProvider;
import org.springframework.stereotype.Component;

@Component
public class FhirR5InstanceValidation extends FhirInstanceValidation {
    public FhirR5InstanceValidation() {
        super(FhirContextProvider.R5);
    }
}
