import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class ASTMain {
	private static ASTParser astParser = ASTParser.newParser(AST.JLS3);
	public static CompilationUnit getCompilationUnit(String javaFilePath) throws Exception {  
        
        BufferedInputStream bufferedInputStream = new BufferedInputStream(  
                new FileInputStream(javaFilePath));  
        byte[] input = new byte[bufferedInputStream.available()];  
        bufferedInputStream.read(input);  
        bufferedInputStream.close();  
        astParser.setSource(new String(input).toCharArray());  
        /**/  
        CompilationUnit result = (CompilationUnit) (astParser.createAST(null));
          
        return result;  

         
    }
	  public static void main(String args[]) throws FileNotFoundException {
		  String dirPath = "C:\\Users\\yang\\OneDrive\\大二暑假实训\\work\\";
		  	for(int i = 0 ; i < 2 ; i++){
		  		for(int j = 0 ; j < 2 ; j++){
		  			boolean isBug = (j == 0 ? true : false);
				  	String workPath = dirPath + (i == 0 ? "test" : "train") +"\\"+ (isBug ? "is":"no") +"bug";
				  	PrintStream ps=new PrintStream(new FileOutputStream(dirPath + (i == 0 ? "test" : "train") + (isBug ? "is":"no") +"bugout.txt"));
					System.setOut(ps);
					File dir = new File(workPath);
					for(File file : dir.listFiles()){
						if(file.isDirectory()){
							continue;
						}
						System.out.print((isBug ? 1 : 0)+ " \t ");
				    	String File = file.getPath();
				    	try {
				    		CompilationUnit result = getCompilationUnit(File);
				    		DemoVisitor visitor = new DemoVisitor();  
				            result.accept(visitor);  
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	System.out.print('\n');
					}
		  		}
		  	}
			
	    }
	  
	  
	  
	    
}
