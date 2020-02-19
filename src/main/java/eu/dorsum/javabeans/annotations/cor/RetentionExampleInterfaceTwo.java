package eu.dorsum.javabeans.annotations.cor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RetentionExampleInterfaceTwo {
	     
    String name() default "default-name";
    String desc() default "default-desc";
    
}