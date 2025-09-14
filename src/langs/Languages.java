package langs;


import langs.a.ada.Ada;
import langs.a.atejipx.AtejiPX;
import langs.c.c.C;
import langs.j.java.Java;
import langs.p.python.Python;

import java.util.HashMap;
import java.util.Map;

public class Languages {
    public static Map<String, Language> langs = new HashMap<>();


    static Language[] loadAllLangs(String[] s){
        /// Format: file extension , Language Object
        /// KEEP ALPHABETICAL!!!!!
        for(String lang : s){
            if(langs.get(lang) != null) continue;
            switch (lang){
                case "ada"->langs.put(lang,new Ada());

                case "apx"->langs.put(lang,new AtejiPX());
                case "c"->langs.put(lang,new C());
                case "java"->langs.put(lang,new Java());
                case "py"->langs.put(lang,new Python());

            }
        }

        return langs.values().toArray(new Language[0]);
    }



}
