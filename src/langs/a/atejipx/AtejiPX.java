package langs.a.atejipx;

import langs.Language;
import tools.universalcompiler.source.Source;
import tools.universalcompiler.source.files.CharSourceFile;

import java.io.File;

public class AtejiPX extends Language<CharSourceFile> {
    public AtejiPX() {
        extension = "apx";
    }
    @Override
    public Source getSourceFile(File file) {
        return new CharSourceFile(file);
    }
}
