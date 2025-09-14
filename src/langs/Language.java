package langs;


import tools.universalcompiler.source.Source;
import tools.universalcompiler.symbols.Context;
import tools.universalcompiler.symbols.Token;
import tools.universalcompiler.translation.patterns.AbstractPattern;
import tools.universalcompiler.translation.solver.AbstractSolvingMethod;
import util.TwoKeyHashMap;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static langs.Languages.loadAllLangs;
import static langs.LineStyle.INFINITE_PER;

public abstract class Language<T extends Source>{
    public static int numOfLoadedLangs=0;
    public TwoKeyHashMap<String, Context, Token> symbols;
    public Set<String> operators;
    public Set<String> keywords;
    public AbstractSolvingMethod[] solvers;
    public String name;
    public String extension;
    public LineStyle style = INFINITE_PER;



    public Language(){
        operators = new TreeSet<>();
        keywords = new TreeSet<>();
        symbols = new TwoKeyHashMap<>();
    }
    public static void getSymbols(String[] s){
        loadAllLangs(s);
        numOfLoadedLangs = Languages.langs.size();
    }
    public static void getSymbols(String s){
        getSymbols(new String[]{s});
    }
    public void sort(AbstractPattern[] arr){
        if(arr==null || arr.length==0 ) return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].priority < arr[j + 1].priority) {
                    AbstractPattern temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }



    protected void add(String symbol, Context c1, Context c2, Token token){
        symbols.put(symbol,c1, token);
        symbols.put(symbol,c2, token);
    }
    protected void add(String symbol, Context c, Token token){
        symbols.put(symbol,c,token);
    }
    protected void add(String symbol, Context[] contexts, Token token){
        for (Context context : contexts) {
            symbols.put(symbol, context, token);
        }
    }
    protected void set(Set<String> keywords, Set<String> operators, Set<Context> keywordContext,Set<Context> opContext, Set<Token> keyTokens, Set<Token> opTokens){
        this.keywords = keywords;
        this.operators = operators;
        String[] s = keywords.toArray(new String[0]);
        String[] o = operators.toArray(new String[0]);
        Context[] s1 = keywordContext.toArray(new Context[0]);
        Context[] o1 = opContext.toArray(new Context[0]);
        Token[] s2 = keyTokens.toArray(new Token[0]);
        Token[] o2 = opTokens.toArray(new Token[0]);
        for(int l=0;l<s.length;l++){
            add(s[l],s1[l],s2[l]);
        }
        for(int l=0;l<o.length;l++){
            add(o[l],o1[l],o2[l]);
        }
    }
    protected void set(Set<AbstractSolvingMethod> solvers){
        this.solvers = solvers.toArray(new AbstractSolvingMethod[0]);
    }
    protected void set(List<AbstractSolvingMethod> solvers){
        this.solvers = solvers.toArray(new AbstractSolvingMethod[0]);
    }


    public abstract tools.universalcompiler.source.Source getSourceFile(File file);
}
