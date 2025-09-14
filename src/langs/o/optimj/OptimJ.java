package langs.o.optimj;

import langs.Language;
import tools.universalcompiler.source.Source;
import tools.universalcompiler.source.files.CharSourceFile;

import java.io.File;

public class OptimJ extends Language<CharSourceFile> {
    public OptimJ() {
        this.extension = "optimj";
    }
    @Override
    public Source getSourceFile(File file) {
        return new CharSourceFile(file);
    }
}
