package com.github.williamdlm.message_director.hl7.fhir.validation;

import com.github.williamdlm.message_director.hl7.common.FhirContextProvider;
import org.springframework.stereotype.Component;

@Component
public class FhirStu3InstanceValidation extends FhirInstanceValidation {
    public FhirStu3InstanceValidation() {
        super(FhirContextProvider.DSTU3);
    }
}
