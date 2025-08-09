package langs;


import langs.a.atejipx.AtejiPX;
import langs.c.c.C;

import java.util.HashMap;
import java.util.Map;

public class Languages {
    public static Map<String, Language> langs = new HashMap<>();

    static Language[] loadAllLangs(){
        /// Format: file extension , Language Object
        /// KEEP ALPHABETICAL!!!!!
        langs.put("apx",new AtejiPX());
        langs.put("c",new C());



        return langs.values().toArray(new Language[0]);
    }



}
