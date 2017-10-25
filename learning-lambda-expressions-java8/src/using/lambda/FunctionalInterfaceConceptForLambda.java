package using.lambda;

/**
 * Created by empathy on 10/9/17.
 */

/**
 * A functional interface is an interface with one and only one method in it
 * If you try to add another method to it, it is a compilation error, which is exactly what is required for Lambda interface
 * These features are enforced/implemented using the annotation :::  "@FunctionalInterface"
 */


@FunctionalInterface
public interface FunctionalInterfaceConceptForLambda {
    public int performOperation(int a, int b);

    /* below line of code is a compilation error (uncomment to check the error)

        public void anotherMethodInFuntionalInterface();

     */

}
