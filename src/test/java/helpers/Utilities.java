package helpers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Utilities {

    public static String getActualDate () {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        return dateFormat.format(date).replace(":", "");
    }

    public static String getValueFromJsonConfig (String input, String filename) {
        String value = "";
        File file = new File("src/test/resources/" + filename);
        ObjectNode node = null;
        try {
            node = new XmlMapper().readValue(file, ObjectNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (node.findValue(input) != null) {
            value = node.findValue(input).textValue();
        } else {
            System.out.println("Config file doesn't contain such parameter");
            System.exit(0);
        }

        return value;
    }
}
