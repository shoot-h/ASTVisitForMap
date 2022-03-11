import org.eclipse.jdt.core.dom.AST;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.regex.*;

import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;



import visitor.VisiterForTutorial;

public class Main {
    public static void main(String[] args)  {
    	int errnum;
    	String ProjectName = "zeppelin-0.10.0";
    	errnum = foldersearch("/Users/shuhashimoto/Downloads/Apatch/" + ProjectName);
    	//filesearch();
    	if(errnum == 0) {
    		System.out.println("\tFinish");
    	}
    	else {
    		System.out.println("\t" + errnum);
    	}
    	
    }
    
    public static int foldersearch(String foldername) {
    	int errnum = 0;
    	List<String> javatarget = util.FileUtil.findFiles(foldername, ".java");
    	for(int i = 0;i < javatarget.size();i++) {
    		//System.out.println("search " + javatarget.get(i));
    		String sourceTarget = util.FileUtil.readFile(javatarget.get(i).toString());
    		boolean isset = false;
    		Pattern pattern;
    		ASTParser parser = ASTParser.newParser(AST.JLS14);
    		parser.setSource(sourceTarget.toCharArray());
    		parser.setKind(ASTParser.K_COMPILATION_UNIT);
    		
    		try {
    		final CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);
    		compilationUnit.accept(new VisiterForTutorial(compilationUnit, javatarget.get(i).toString(), isset));
    		} catch(StringIndexOutOfBoundsException e) {
    			System.out.println("\tCan't search " + javatarget.get(i).toString());
    			if(isset) {
    				pattern = Pattern.compile("(?<=(\n|\r|\r\n)).*Set<.*>");
    			}
    			else {
    				pattern = Pattern.compile("(?<=(\\n|\\r|\\r\\n)).*Map<.*>");
    			}
    			Matcher matcher = pattern.matcher(sourceTarget);
    			while(matcher.find()) {
    				System.out.println("\t" + matcher.group());
    			}
    			errnum++;
    		}
    		
    	}
    	return errnum;
    }
    
    public static void filesearch() {
    	String pathTarget = "/Users/shuhashimoto/Downloads/Apatch/systemds-2.2.1-rc3/src/main/java/org/apache/sysds/runtime/lineage/LineageCacheConfig.java";
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
