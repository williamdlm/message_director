package com.github.williamdlm.message_director.pojo.parser;

import com.github.williamdlm.message_director.pojo.FhirContextProvider;
import org.springframework.stereotype.Component;

@Component
public class FhirStu3Parser extends FhirParser {
    public FhirStu3Parser() {
        super(FhirContextProvider.DSTU3);
    }
}
