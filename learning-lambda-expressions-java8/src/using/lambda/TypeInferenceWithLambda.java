package using.lambda;

/**
 * Created by empathy on 10/9/17.
 */
public class TypeInferenceWithLambda {

    public static void main(String args[]){

        /**
         *
         * Lambda expression with no params
         */

        JustDisplayLambda stringDisplayLambda = () -> System.out.println("Hello there, welcome to Lambda Type Inference!");
        stringDisplayLambda.perform();

        /**
         * Lambda expression with a single param, and the param type explicitly declared in it(RHS)
         */
        JustDisplayGivenStringLambda displayGivenStringLambda = (String s) -> System.out.println("Hello " + s);
        displayGivenStringLambda.perform("Ravi!! Passed My Name as Param to the Lambda expression.");

        /**
         * Lambda expression with a single param without the param type being declared in the expression on the RHS, Then how?
         *
         * Although the lambda expression is not mentioning the type of its param in its definition on the RHS,
         * it infers the type of the param and the return type from the interface on its LHS
         * So, "(s)" on RHS below will be string because the interface "JustDisplayGivenStringLambda" on the LHS
         * has the parameter String in its one and only method perform(String s)
         * And we know that an interface for a Lambda expression can have only one method declared in it
         */

        JustDisplayGivenStringLambda displayGivenStringLambdaWithoutExplicitlyMentioningTypeOfParam =
                (s) -> System.out.println("Hello " + s);

        displayGivenStringLambdaWithoutExplicitlyMentioningTypeOfParam.perform("Ravi!! Passed My Name as Param to the Lambda expression" +
                " that did mention the type of the parameter to be passed to it. " +
                "Rather it inferred the type of the param from the method declaration in its interface.");

        /**
         *  Lambda expression with Parameters - same explanation as previous cases except that in this case
         *  the interface in defined in a new file rather than in the same file
         */

        FunctionalInterfaceConceptForLambda findSumLambdaWithParamTypes = (int a, int b) -> a+b;
        findSumLambdaWithParamTypes.performOperation(1,2);

        FunctionalInterfaceConceptForLambda findSumLambdaWithOutParamTypesAndReturnTypesInfo = (a, b) -> a+b;
        findSumLambdaWithOutParamTypesAndReturnTypesInfo.performOperation(12,4);

        /**
         * If u look closely below it appears as though we are passing a function definition as a parameter/variable,
         * which is nothing but a Lambda expression
         */

        FunctionalInterfaceConceptForLambda divideSafely = (int a, int b) -> {
            return (b == 0) ? 0 : (a / b);
        } ;
        divideSafely.performOperation(10, 0);

    }

    @FunctionalInterface
    interface JustDisplayLambda {
        void perform();
    }

    @FunctionalInterface
    interface JustDisplayGivenStringLambda {
        void perform(String s);
    }
}
