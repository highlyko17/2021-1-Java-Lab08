package edu.handong.csee.java.hw2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import edu.handong.csee.java.hw2.converters.*;

public class IntegratedConverter {
	
	private double fromValue;

	/**
		*main method
	*/
public static void main(String[] args) {

    IntegratedConverter myConverter = new IntegratedConverter();

    myConverter.run(args);

}

private void run(String[] args) {

    fromValue = Double.parseDouble(args[0]);
    String originalMeasure = Util.getUppercaseString(args[1]);
    String targetMeasure = Util.getUppercaseString(args[2]);

    if(!targetMeasure.equals("ALL")) {

        String converterName = "edu.handong.csee.java.hw2.converters." + originalMeasure + "To" + targetMeasure + "Converter";

        // You will learn about the try-catch block and Exception in L19
        try {

            // Advanced Java feature: Reflection (it lets us use classes with their String class names.)
            // (JC does not teach this topic as it is advanced one but you can study by yourself!!)
            // https://www.oracle.com/technical-resources/articles/java/javareflection.html
            Class<?> converterClass = (Class<?>) Class.forName(converterName);
            Constructor<?> constructor = (Constructor<?>) converterClass.getConstructor();
            Convertible myConverter = (Convertible) constructor.newInstance();
            myConverter.setFromValue(fromValue);
            myConverter.convert();
            System.out.println(fromValue +" " + originalMeasure + " is " + myConverter.getConvertedValue() + " " + targetMeasure + "!");
							System.out.println();

        } catch(ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            System.out.println("The converter (" + converterName + ") for " + originalMeasure + " to " + targetMeasure + " does not exist!!");
							System.out.println();
        }

    } else {

        AllConverter myAllConverter = new AllConverter();
        // When your method returns `this' in methods of AllConverter, you can call them in this way (method chaining).
        // Think/understand how and why this work. Study and search for Method chaining
        // https://stackoverflow.com/questions/21180269/how-to-achieve-method-chaining-in-java
        // https://www.geeksforgeeks.org/method-chaining-in-java-with-examples/#:~:text=Method%20Chaining%20is%20the%20practice,with%20a%20(dot.).
        myAllConverter.setFromValue(fromValue).setOriginalMeasure(originalMeasure).convertAndPrintOut();
    }
}

}
