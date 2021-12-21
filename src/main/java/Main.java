import org.eclipse.jdt.core.dom.AST;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;



import visitor.VisiterForTutorial;

public class Main {
    public static void main(String[] args)  {
    	String ProjectName = "zxing-zxing-3.4.1";
    	foldersearch("/Users/shuhashimoto/Downloads/" + ProjectName);
    	//filesearch();
    	System.out.println("Finish");
    }
    
    public static void foldersearch(String foldername) {
    	List<String> javatarget = util.FileUtil.findFiles(foldername, ".java");
    	for(int i = 0;i < javatarget.size();i++) {
    		//System.out.println("search " + javatarget.get(i));
    		String sourceTarget = util.FileUtil.readFile(javatarget.get(i).toString());
    		ASTParser parser = ASTParser.newParser(AST.JLS3);
    		parser.setSource(sourceTarget.toCharArray());
    		parser.setKind(ASTParser.K_COMPILATION_UNIT);

    		final CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);
    		compilationUnit.accept(new VisiterForTutorial(compilationUnit, javatarget.get(i).toString()));
    		//System.out.println("Finish");
    	}
    }
    public static void filesearch() {
    	String pathTarget = "/Users/shuhashimoto/Downloads/kGenProg-master/src/main/java/jp/kusumotolab/kgenprog/project/TestSourcePath.java";
    	//String pathTarget = "/Users/shuhashimoto/Downloads/ASTVisitForMap-main/src/main/java/Dummy.java";
    	System.out.println("search " + pathTarget);
        String sourceTarget = util.FileUtil.readFile(pathTarget);
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(sourceTarget.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        final CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);

        compilationUnit.accept(new VisiterForTutorial(compilationUnit));
        
    }
}
