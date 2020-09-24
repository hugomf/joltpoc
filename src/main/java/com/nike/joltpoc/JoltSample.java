package com.nike.joltpoc;

import java.util.List;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

public class JoltSample {

    public void transform() {

        // final List<Object> specs = JsonUtils.classpathToList("/join/spec.json");
        // final Object inputJSON = JsonUtils.classpathToObject("/join/input.json");

        // final List<Object> specs = JsonUtils.classpathToList("/filter/spec.json");
        // final Object inputJSON = JsonUtils.classpathToObject("/filter/input.json");

        // final List<Object> specs = JsonUtils.classpathToList("/ttrace-outbound/spec.json");
        // final Object inputJSON = JsonUtils.classpathToObject("/ttrace-outbound/input.json");

        final List<Object> specs = JsonUtils.classpathToList("/ttrace-inbound/spec.json");
        final Object inputJSON = JsonUtils.classpathToObject("/ttrace-inbound/input.json");


        final Chainr chainr = Chainr.fromSpec(specs);
        final Object transformedOutput = chainr.transform(inputJSON);

        if (transformedOutput!= null) {
            System.out.println(transformedOutput.getClass());
            System.out.printf("Input json:\n %s\n", JsonUtils.toPrettyJsonString(inputJSON));
            System.out.printf("Transformed: json:\n %s\n", JsonUtils.toPrettyJsonString(transformedOutput));
        } else {
            System.out.println("No output generated");
        }
    }

}