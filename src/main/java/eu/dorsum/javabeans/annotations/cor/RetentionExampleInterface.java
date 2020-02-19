package eu.dorsum.javabeans.annotations.cor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RetentionExampleInterface {
	     
    String name();
    String desc();
    
}