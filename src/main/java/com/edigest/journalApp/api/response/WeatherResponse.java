package com.edigest.journalApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse{
   
    private Current current;

    @Getter
    @Setter
    public class Current{
        @JsonProperty("last_updated_epoch")
        public int lastUpdatedEpoch;
        @JsonProperty("last_updated")
        public String lastUpdated;
        @JsonProperty("temp_c")
        public double tempC;
        @JsonProperty("temp_f")
        public double tempF;
       
        public int humidity;
       
    }
}




