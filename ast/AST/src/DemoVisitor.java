
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AssertStatement;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BlockComment;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MemberRef;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.MethodRefParameter;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeParameter;
import org.eclipse.jdt.core.dom.VariableDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;  
  
public class DemoVisitor extends ASTVisitor {  


    //FormalParameter and MethodDeclaration
    @Override  
    public boolean visit(MethodDeclaration node) {  
    	if(node.isConstructor()){
    		System.out.print(node.getName() + " ");
    	} else {
    		System.out.print(node.getName() + " ");
    	}
    	for(Object obj : node.parameters()){
    		SingleVariableDeclaration s = (SingleVariableDeclaration)obj;
    		System.out.print(s.getType() + " ");
    	}
        
        return true;  
    }  
    //BasicType and ReferenceType
    @Override  
    public boolean visit(FieldDeclaration node) {
    	Type type = node.getType();
    	if(type instanceof PrimitiveType){
    		System.out.print(type + " ");
    	} else {
    		System.out.print(type + " ");
    	}
        return true;  
    }
    //PackageDeclaration
    @Override
    public boolean visit(PackageDeclaration node) {
    	System.out.print(node.getName() + " ");
    	return true;
    }
    //InterfaceDeclaration and Class
    @Override  
    public boolean visit(TypeDeclaration node) {  
    	//System.out.print(":\t"+ node.getTypes());
    	if(node.isInterface()){
    		System.out.print(node.getName() + " ");  
    	} else {
    		System.out.print(node.getName() + " ");
    	}
        return true;  
    }
    //CatchClause
    public boolean visit(CatchClause node){
    	System.out.print(node.getException().getType() + " ");
    	return true;
    }
    //MethodInvocation
    public boolean visit(MethodInvocation node){
    	System.out.print(node.getName() + " ");
    	return true;
    }
    //SuperMethodInvocation
    public boolean visit(SuperMethodInvocation node){
    	System.out.print(node.getName() + " ");
    	return true;
    }
  //ConstructorDeclaration
    public boolean visit(ConstructorDeclaration node){
    	System.out.print(node.getClass() + " ");
    	return true;
    }
	
	//IfStatement
    public boolean visit(IfStatement node){
    	System.out.print("IfStatement" + " ");
    	return true;
    }
    //WhileStatement
    public boolean visit(WhileStatement node){
    	System.out.print("WhileStatemet" + " ");
    	return true;
    }
    //DoStatement
    public boolean visit(DoStatement node){
    	System.out.print("DoStatement" + " ");
    	return true;
    }
    //ForStatement
    public boolean visit(ForStatement node){
    	System.out.print("ForStatement" + " ");
    	return true;
    }
    //AssertStatement
    public boolean visit(AssertStatement node){
    	System.out.print("AssertStatement" + " ");
    	return true;
    }
  //BreakStatement
    public boolean visit(BreakStatement node){
    	System.out.print("BreakStatement" + " ");
    	return true;
    }
  //ContinueStatement
    public boolean visit(ContinueStatement node){
    	System.out.print("ContinueStatement" + " ");
    	return true;
    }
    
  //ReturnStatement
    public boolean visit(ReturnStatement node){
    	System.out.print("ReturnStatement" + " ");
    	return true;
    }
  //ThrowStatement
    public boolean visit(ThrowStatement node){
    	System.out.print("ThrowStatement" + " ");
    	return true;
    }

  //SynchronizedStatement
    public boolean visit(SynchronizedStatement node){
    	System.out.print("SynchronizedsStatement" + " ");
    	return true;
    }
    
  //TryStatement
    public boolean visit(TryStatement node){
    	System.out.print("TryStatement" + " ");
    	return true;
    }
    
  //SwitchStatement
    public boolean visit(SwitchStatement node){
    	System.out.print("SwitchStatement" + " ");
    	return true;
    }
    
  //BlockStatement
    public boolean visit(Block node){
    	System.out.print("Block" + " ");
    	return true;
    }
    
  //ExpressionStatement
    public boolean visit(ExpressionStatement node){
    	System.out.print("ExpressionStatement" + " ");
    	return true;
    }
    
  //SwitchCase
    public boolean visit(SwitchCase node){
    	System.out.print("SwitchCase" + " ");
    	return true;
    }
    
}  