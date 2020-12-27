package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Utilities {

    private static ConfigData data;

    public static String getActualDate () {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        return dateFormat.format(date).replace(":", "");
    }

    public static ConfigData getConfigData () {
        if (data != null) {
            return data;
        }
        File test_data = new File("src/test/resources/config_data.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            data =  mapper.readValue(test_data, ConfigData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
