package visitor;

import org.eclipse.core.internal.localstore.Bucket;
import org.eclipse.jdt.core.dom.*;

import java.lang.management.CompilationMXBean;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class VisiterForTutorial extends ASTVisitor {
    CompilationUnit compilationUnit = null;
    ArrayList<ExpressionStatement> nodestock = new ArrayList<>();
    ArrayList<VariableDeclarationStatement> verstock = new ArrayList<>();
    ArrayList<String> mapstock = new ArrayList<>();
    ArrayList<String> namestock = new ArrayList<>();
    public VisiterForTutorial(CompilationUnit compilationUnit){
        this.compilationUnit = compilationUnit;
    }
    
    public boolean visit(VariableDeclarationFragment node) {
        namestock.add(node.getName().toString());
        return false; // do not continue to avoid usage info
    }
    
    public boolean visit(VariableDeclarationStatement node) {
    	verstock.add(node);
    	if(node.getType().toString().contains("Map")) {
    		System.out.println(node);
    		return true;
    	}
    	else return false; // do not continue to avoid usage info
    }
    
    public boolean visit(ExpressionStatement node) {
    	nodestock.add(node);
    	Expression map1 = node.getExpression();
    	for(int i = 0;i < namestock.size();i++) {
        	if(map1.toString().contains(namestock.get(i))) {
        		//System.out.println("Line "+compilationUnit.getLineNumber(node.getStartPosition()));
        		System.out.println(map1);
        		System.out.println(map1.structuralPropertiesForType());
        	}
    	}  	
        return true; // do not continue to avoid usage info
    }
}
