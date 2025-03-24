package fr.lfi.datacollection;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import fr.lfi.datacollection.util.SheetsServiceUtil;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class DataCollector {
    private static final String SPREADSHEET_ID = "1LPpF3pHDLOvFqO64JH8k9_iwRfWeWnGmIMx2roIWOyE";
    private static final String RANGE = "Form_Responses!B2:G";
    private final Sheets sheetsService;

    public DataCollector() throws GeneralSecurityException, IOException {
        this.sheetsService = SheetsServiceUtil.getSheetsService();
    }

    public List<SurveyResponse> collectData() throws IOException {
        List<SurveyResponse> responses = new ArrayList<>();
        ValueRange response = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, RANGE).execute();
        List<List<Object>> values = response.getValues();

        if (values == null || values.isEmpty()) {
            System.out.println("No data found");
            return responses;
        }

        for (List<Object> row : values) {
            responses.add(new SurveyResponse(
                    getValue(row, 1),  // Ressenti aujourd'hui
                    getValue(row, 2),  // Action en tant que maire
                    getValue(row, 4),  // Quartier
                    getValue(row, 5)
            ));
        }

        return responses;
    }

    private String getValue(List<Object> row, int index) {
        return index < row.size() ? row.get(index).toString() : "";
    }
}
