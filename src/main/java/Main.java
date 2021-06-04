import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import visitor.VisiterForTutorial;

public class Main {
    public static void main(String[] args)  {
        String pathTarget = "C:\\Users\\shoot\\Desktop\\tutorialJDT-main\\src\\main\\java\\Dummy.java";
        String sourceTarget = util.FileUtil.readFile(pathTarget);
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(sourceTarget.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        final CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);

        compilationUnit.accept(new VisiterForTutorial(compilationUnit));
    }
}
