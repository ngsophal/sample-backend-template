package com.sma.backend.server;



import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SkipNullObjectMapper extends ObjectMapper {

    //@SuppressWarnings("deprecation")
	public void init() {
	    
        
        getSerializationConfig().withSerializationInclusion(Include.NON_NULL);
        //ignore unknown properties
       // getDeserializationConfig().set(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        getDeserializationConfig().without(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}
