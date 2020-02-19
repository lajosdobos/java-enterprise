package eu.dorsum.javabeans.annotations.cor;

import java.lang.reflect.Method;

public class RetentionExample {

//    @RetentionExampleInterface(name = "test1", desc = "testing annotations")
    @RetentionExampleInterfaceTwo(name = "test1", desc = "testing annotations")
    public void myTestMethod(){
    	
    	try {
    		Class<? extends RetentionExample> clazz = this.getClass();
    		Method method = clazz.getMethod("myTestMethod");
//    		RetentionExampleInterface retentionExampleInterface = method.getAnnotation(RetentionExampleInterface.class);
    		RetentionExampleInterfaceTwo retentionExampleInterface = method.getAnnotation(RetentionExampleInterfaceTwo.class);
    		System.out.println("desc: " + retentionExampleInterface.desc());
    		System.out.println("name: " + retentionExampleInterface.name());
    	} catch (SecurityException | NoSuchMethodException e) {
    		System.err.println(e);
        } 
    }
    
    public static void main(String[] args) {
		RetentionExample retentionExample = new RetentionExample();
		retentionExample.myTestMethod();
	}
    
}
