package visitor;

import org.eclipse.core.internal.localstore.Bucket;
import org.eclipse.jdt.core.dom.*;

import java.lang.management.CompilationMXBean;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VisiterForTutorial extends ASTVisitor {
    CompilationUnit compilationUnit = null;
    ArrayList<String> mapnamestock = new ArrayList<>();//Save Veriable Name(Only Type:Map) 
    ArrayList<String> vernamestock = new ArrayList<>();//Save Veriable Name(ALL)
    Map<String,String> verTypestock = new HashMap<>();//Save Type for each Variable
    int verjudge = 0;
    String verType;
    public VisiterForTutorial(CompilationUnit compilationUnit){
        this.compilationUnit = compilationUnit;
    }
    
    /*public boolean visit(VariableDeclarationFragment node) {
    	if(verjudge == 2) {
    		mapnamestock.add(node.getName().toString());
    		//System.out.println(node.getName());
    	}
        if(verjudge != 0) {
        	verTypestock.put(node.getName().toString(), verType);
        	vernamestock.add(node.getName().toString());
        }
        
        verjudge = 0;
        return false; // do not continue to avoid usage info
    }*/
    
    public boolean visit(VariableDeclarationStatement node) {
    	if(node.getType().toString().contains("Map")) {
    		System.out.println(node.getType());
    		verjudge = 2;
    	}
    	else verjudge = 1;
    	//System.out.println(node.getType());
    	verType = node.getType().toString();
    	return true; // do not continue to avoid usage info
    	
    }
    
    	//((MethodInvocation)map1).arguments().get(0);

    /*public boolean visit(MethodInvocation node) {
    	for(int i = 0;i < mapnamestock.size();i++) {
    		
    		if(node.getExpression() != null) {
    			//System.out.println("Line" + compilationUnit.getLineNumber(node.getStartPosition()));
    			//System.out.println(node.getExpression());
        	if(node.getExpression().toString().equals(mapnamestock.get(i))) {
            	//System.out.println(node.arguments().get(0).toString());
            	for(int j = 0;j < vernamestock.size();j++) {
                	if(node.arguments().size() != 0 && node.arguments().get(0).toString().equals(vernamestock.get(j))) {
                    	//System.out.println("Line" + compilationUnit.getLineNumber(node.getStartPosition())
                    	//		+ " use " + verTypestock.get(node.arguments().get(0).toString()));
                	}
            	}
        	}
        	}
    	}

    	return true;
    }*/
    
    
}
