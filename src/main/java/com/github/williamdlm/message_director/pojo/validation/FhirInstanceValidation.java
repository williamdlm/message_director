package com.github.williamdlm.message_director.pojo.validation;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.ValidationResult;
import org.hl7.fhir.common.hapi.validation.support.CommonCodeSystemsTerminologyService;
import org.hl7.fhir.common.hapi.validation.support.InMemoryTerminologyServerValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.ValidationSupportChain;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.hl7.fhir.instance.model.api.IBaseResource;

public abstract class FhirInstanceValidation {

    private FhirContext context = null;

    public FhirInstanceValidation(FhirContext context) {
        this.context = context;
    }

    ValidationResult validationResult(IBaseResource resource) {
        ValidationSupportChain validationSupportChain = new ValidationSupportChain(
                new DefaultProfileValidationSupport(context),
                new InMemoryTerminologyServerValidationSupport(context),
                new CommonCodeSystemsTerminologyService(context));
        FhirValidator validator = context.newValidator();
        FhirInstanceValidator instanceValidator = new FhirInstanceValidator(validationSupportChain);
        validator.registerValidatorModule(instanceValidator);
        ValidationResult result = validator.validateWithResult(resource);
        return result;

    }


}
