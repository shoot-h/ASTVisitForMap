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
    String rootPath = "";
    ArrayList<String> mapnamestock = new ArrayList<>();//Save Veriable Name(Only Type:Map) 
    ArrayList<String> vernamestock = new ArrayList<>();//Save Veriable Name(ALL)
    Map<String,String> verTypestock = new HashMap<>();//Save Type for each Variable
    int verjudge = 0;
    String verType;
    
    public VisiterForTutorial(CompilationUnit compilationUnit){
        this.compilationUnit = compilationUnit;
    }
    
    public VisiterForTutorial(CompilationUnit compilationUnit,String pathname){
        this.compilationUnit = compilationUnit;
        this.rootPath = pathname;
    }
    
    /*public boolean visit(TypeDeclaration node) {
        //PrintUtil.printTitle("クラス宣言");
        //ITypeBinding typeBinding = node.resolveBinding();// 詳細な情報をITypeBindingインスタンスを使って取得したい
        //ITypeBinding superClass = typeBinding.getSuperclass();// 親クラスの取得
        //ITypeBinding[] interfaces = typeBinding.getInterfaces();// インターフェースの取得
        //String className = typeBinding.getBinaryName();// クラス名の取得
        //int modifiers = typeBinding.getModifiers();// "public static"とかの識別子
        //PrintUtil.printMessage("ClassName", className);
        //PrintUtil.printModifiers("Modifiers", modifiers);
        //PrintUtil.printMessage("SuperClass", superClass.getBinaryName());
        //PrintUtil.printMessage("Interfaces", interfaces);
    	System.out.println(node.getSuperclassType());
    	System.out.println(node.getName());
        return super.visit(node);
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
    	if(node.getType().toString().contains("Map<") && !node.getType().toString().contains("Map<String,")) {
    		System.out.println(node.getType() + " in " + rootPath);
    	}
    	else verjudge = 1;
    	//System.out.println(node.getType());
    	verType = node.getType().toString();
    	return true; // do not continue to avoid usage info
    	
    }

	@Override
	public boolean visit(FieldDeclaration node) {
    	if(node.getType().toString().contains("Map<") && !node.getType().toString().contains("Map<String,")) {
    		System.out.println(node.getType() + "\t\tin " + rootPath);
    	}
		// TODO Auto-generated method stub
		return super.visit(node);
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
