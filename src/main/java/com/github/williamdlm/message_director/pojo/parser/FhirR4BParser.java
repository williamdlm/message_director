package com.github.williamdlm.message_director.pojo.parser;

import com.github.williamdlm.message_director.pojo.FhirContextProvider;
import org.springframework.stereotype.Component;

@Component
public class FhirR4BParser extends FhirParser {
    public FhirR4BParser() {
        super(FhirContextProvider.R4B);
    }
}
