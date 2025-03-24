package fr.lfi.datacollection.util;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.List;

public class SheetsServiceUtil {
    private static final String APPLICATION_NAME = "FaireMieux";
    private static final String SERVICE_ACCOUNT_KEY_PATH = "/service-account.json";

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        try (InputStream serviceAccountStream = SheetsServiceUtil.class.getResourceAsStream(SERVICE_ACCOUNT_KEY_PATH)) {
            if (serviceAccountStream == null) {
                throw new IOException("File service-account.json not found in project resources.");
            }

            GoogleCredential credential = GoogleCredential.fromStream(serviceAccountStream)
                    .createScoped(List.of("https://www.googleapis.com/auth/spreadsheets"));

            return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                    JacksonFactory.getDefaultInstance(), credential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        }
    }
}
