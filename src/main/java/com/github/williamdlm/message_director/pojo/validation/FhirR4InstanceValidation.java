package com.github.williamdlm.message_director.pojo.validation;

import com.github.williamdlm.message_director.pojo.FhirContextProvider;

public class FhirR4InstanceValidation extends FhirInstanceValidation {
    public FhirR4InstanceValidation() {
        super(FhirContextProvider.R4);
    }
}
