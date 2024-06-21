package com.github.williamdlm.message_director.controller;

import ca.uhn.fhir.parser.DataFormatException;
import ca.uhn.fhir.validation.ValidationResult;
import ca.uhn.hl7v2.model.Message;
import com.github.williamdlm.message_director.hl7.fhir.parser.FhirR4BParser;
import com.github.williamdlm.message_director.hl7.fhir.parser.FhirR4Parser;
import com.github.williamdlm.message_director.hl7.fhir.parser.FhirR5Parser;
import com.github.williamdlm.message_director.hl7.fhir.parser.FhirStu3Parser;
import com.github.williamdlm.message_director.hl7.fhir.validation.FhirR4BInstanceValidation;
import com.github.williamdlm.message_director.hl7.fhir.validation.FhirR4InstanceValidation;
import com.github.williamdlm.message_director.hl7.fhir.validation.FhirR5InstanceValidation;
import com.github.williamdlm.message_director.hl7.fhir.validation.FhirStu3InstanceValidation;
import com.github.williamdlm.message_director.hl7.hl7v2.ParserHL7v2;
import lombok.RequiredArgsConstructor;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final FhirR4Parser fhirR4Parser;
    private final FhirStu3Parser fhirStu3Parser;
    private final FhirR4BParser fhirR4BParser;
    private final FhirR5Parser fhirR5Parser;

    private final FhirStu3InstanceValidation fhirStu3InstanceValidation;
    private final FhirR4InstanceValidation fhirR4InstanceValidation;
    private final FhirR4BInstanceValidation fhirR4BInstanceValidation;
    private final FhirR5InstanceValidation fhirR5InstanceValidation;

    @GetMapping
    String status() {
        return "Is working";
    }

    @PostMapping("/validateSTU3")
    String isValidSTU3(@RequestBody String message) {
        try {
            IBaseResource iBaseResource = fhirStu3Parser.toParser(message);
            //validation
            ValidationResult validationResult = fhirStu3InstanceValidation.validationResult(iBaseResource);
            return validationResult.toString();
        } catch (DataFormatException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/validateR4")
    String isValidR4(@RequestBody String message) {
        try {
            //parser
            IBaseResource iBaseResource = fhirR4Parser.toParser(message);
            //validation
            ValidationResult validationResult = fhirR4InstanceValidation.validationResult(iBaseResource);
            return validationResult.toString();

        } catch (DataFormatException e) {
            return e.getMessage();
        }
        // return "It's work";
    }

    @PostMapping("/validateR4B")
    String isValidR4B(@RequestBody String message) {
        try {
            IBaseResource iBaseResource = fhirR4BParser.toParser(message);
            //validation
            ValidationResult validationResult = fhirR4BInstanceValidation.validationResult(iBaseResource);
            return validationResult.toString();
        } catch (DataFormatException e) {
            return e.getMessage();
        }
    }


    @PostMapping("/validateR5")
    String isValidR5(@RequestBody String message) {
        try {
            IBaseResource iBaseResource = fhirR5Parser.toParser(message);
            //validation
            ValidationResult validationResult = fhirR5InstanceValidation.validationResult(iBaseResource);
            return validationResult.toString();
        } catch (DataFormatException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/validateV2")
    String isValidHl7V2(@RequestBody String message) {
        try {
            String newMessage = message.replace("\n", "\r\n");
            Message parsedMessage = ParserHL7v2.toParser(newMessage);
            return "It's work";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
