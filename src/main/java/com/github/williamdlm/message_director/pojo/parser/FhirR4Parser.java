package com.github.williamdlm.message_director.pojo.parser;

import com.github.williamdlm.message_director.pojo.FhirContextProvider;
import org.springframework.stereotype.Component;

@Component
public class FhirR4Parser extends FhirParser {

    public FhirR4Parser() {
        super(FhirContextProvider.R4);
    }
}
