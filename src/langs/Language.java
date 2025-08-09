package langs;


import static langs.Languages.loadAllLangs;

public class Language {
    public static int numOfLoadedLangs=0;
    public String extension;

    public Language(String extension) {
        this.extension=extension;
    }
    protected void loadAll(){
        loadSymbols();
        loadPatterns();
    }
    protected void loadSymbols(){}
    protected void loadPatterns(){}

    public static void getSymbols(Language l){
        l.loadSymbols();
    }
    public static synchronized void getSymbols(){
        Language[] langs = Languages.langs.values().toArray(new Language[0]);
        if(langs.length==0){
            langs = loadAllLangs();
        }
        for (Language lang : langs) {
            lang.loadAll();
            numOfLoadedLangs++;
        }
    }

    public static void main(String[] args){
        Language.getSymbols();
        System.out.println(Languages.langs.get("c"));
    }





}
