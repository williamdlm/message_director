package com.github.williamdlm.message_director.pojo.parser;

import com.github.williamdlm.message_director.pojo.FhirContextProvider;
import org.springframework.stereotype.Component;

@Component
public class FhirR5Parser extends FhirParser {
    public FhirR5Parser() {
        super(FhirContextProvider.R5);
    }
}
