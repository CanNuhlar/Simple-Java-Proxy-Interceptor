package ProxyServer;

import ProxyServer.Model.EditSub;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import ProxyServer.Model.Config;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;


import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Equ on 4/25/2016.
 */
public class Input {


    public void readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Config config = mapper.readValue(new File("input.json"), Config.class);

        Map < String, String > map = config.getAdd();


        for (Map.Entry < String, String > entry: map.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            System.out.println("key-> " + key + " value-> " + value);
        }

        // System.out.println(populateEdit(config)[4][2]);
        // System.out.println(populateEdit(config)[4][1]);
        // System.out.println(populateEdit(config)[4][0]);

        for (String can: config.getDelete()) {
            //System.out.println(can);
        }
    }

    public String[][] populateEdit(Config config) {
        //Map<String, String> map = new HashMap<String, String>();
        String[][] mapArray = new String[config.getEdit().size()][4];
        int i = 0;
        for (EditSub edit: config.getEdit()) {
            mapArray[i][0] = edit.getAction();
            mapArray[i][1] = edit.getWord();
            mapArray[i][2] = edit.getTarget();
            if (edit.getReplace() != null)
                mapArray[i][3] = edit.getReplace();
            i++;
        }
        return mapArray;
    }
}