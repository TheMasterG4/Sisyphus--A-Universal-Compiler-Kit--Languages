package langs.c.c;


import langs.Language;
import tools.universalcompiler.source.Source;
import tools.universalcompiler.source.files.CharSourceFile;

import java.io.File;

public class C extends Language<CharSourceFile> {
    public C() {
        extension = "c";
    }

    @Override
    public Source getSourceFile(File file) {
        return new CharSourceFile(file);
    }

}
