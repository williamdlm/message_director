package com.github.williamdlm.message_director.hl7.common;

import ca.uhn.fhir.context.FhirContext;

public class FhirContextProvider {
    public static FhirContext DSTU3 = findVersion("stu3");
    public static FhirContext R4 = findVersion("r4");
    public static FhirContext R4B = findVersion("r4b");
    public static FhirContext R5 = findVersion("r5");

    public static FhirContext findVersion(String version) {
        FhirContext context = null;
        switch (version.toLowerCase()) {
            case "stu3":
                context = FhirContext.forDstu3();
                break;
            case "r4":
                context = FhirContext.forR4();
                break;
            case "r4b":
                context = FhirContext.forR4B();
                break;
            case "r5":
                context = FhirContext.forR5();
                break;
        }
        return context;
    }


}
