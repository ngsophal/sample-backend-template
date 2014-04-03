package com.sma.backend.server;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

public class SkipNullObjectMapper extends ObjectMapper {

    //@SuppressWarnings("deprecation")
	public void init() {
        getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
        //getSerializationConfig().withSerializationInclusion(Inclusion.NON_NULL);
        //ignore unknown properties
       // getDeserializationConfig().set(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        getDeserializationConfig().without(Feature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}
