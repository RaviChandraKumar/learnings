package using.lambda;

/**
 * Created by empathy on 10/16/17.
 */
public class MethodReferencesForLambdaExpressions {

    public void performAction(int a, MyLambda ml){
        ml.perform(a);
    }

    private static void performActionStaticMethod(int a, MyLambda p){
        p.perform(a);
    }

    private void methodReference(int a){
        System.out.println("Value of passed parameter to methodReference is : " + a);
    }

    private static void methodReferenceStatic(int a){
        System.out.println("Value of passed parameter to methodReferenceStatic is: " + a);
    }

    public static void main(String[] args) {

        //Run the below blocks of code to ee the difference in each one of them

        // instead of explicitly using a Lambda Expression we are using method Reference (::) - JaVA 8
        // this was possible because the signature of the method println() in System.out is same as the
        // method defined in the FunctionalInterface - MyLambda
        performActionStaticMethod(100,System.out::println);

        // instead of explicitly using a  Lambda Expression we are using method Reference (::) - JAVA 8
        // this was possible because the signature of the method
        // methodReferenceStatic() in MethodReferencesForLambdaExpressions is same as the
        // method defined in the FunctionalInterface - MyLambda
        performActionStaticMethod(200, MethodReferencesForLambdaExpressions::methodReferenceStatic);

        //instead of explicitly using a Lambda Expression we are using method Reference (::)  JAVA 8
        // Although this may appear to be calling obj.methodReference
        // But this is not same, because if we did dot operation on the object,
        // the method would be executed then and ther
        // instead of passing it as a parameter
        // therefore obj.methodReference() below will be illegal - compile error
        MethodReferencesForLambdaExpressions obj = new MethodReferencesForLambdaExpressions();
        performActionStaticMethod(300, obj::methodReference);

    }
}
