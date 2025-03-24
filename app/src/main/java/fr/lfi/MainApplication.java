package fr.lfi;

import fr.lfi.datacollection.DataCollector;
import fr.lfi.datacollection.SurveyResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;

import java.util.List;


public class MainApplication {
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        DataCollector collector = new DataCollector();
        List<SurveyResponse> responses = collector.collectData();
    }
}
