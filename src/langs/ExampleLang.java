package langs;

import langs.j.java.Example;
import tools.universalcompiler.source.files.CharSourceFile;
import tools.universalcompiler.source.Source;

import java.io.File;

public class ExampleLang extends Language<CharSourceFile>{
    public ExampleLang(){
        extension="example";
        this.solvers = new Example[]{new Example()};
    }
    @Override
    public Source getSourceFile(File file) {
        return new CharSourceFile(file);
    }
}
