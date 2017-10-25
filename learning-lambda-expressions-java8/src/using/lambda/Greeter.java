package using.lambda;

import old.style.Greeting;

/**
 * Created by empathy on 10/9/17.
 */
public class Greeter {

    public void greet(Greeting greeting){

        greeting.perform();
    }

    public static void main(String[] args){

        /**
         * KEY  POINTS TO NOTE ABOUT THE RHS:
         *
         *  1. No need to specify the return type of the lambda experssion because java 8 figures it out by itself
         *  2. No need to specify the access modifier (private, protected, public on RHS) because it need not be restricted to class
         *  3. single line code for lambda function. Hence, we omit {}
         *
         *  KEY  POINTS TO NOTE ABOUT THE LHS:
         *
         *  4.  "LAMBDA AS INTERFACE TYPE"
         *      Type of variable to which Lambda expression is assigned is always an interface that has exactly one method in it
         *      which has the same signature as the lambda expression on th RHS
         *      That is, interface Greeting has exactly one method in it, and that method's signature is  - (no args) and no return type
         *      which is what even our Lambda expression has on the RHS
         *
         *      If the Greeting interface has any of the following then below statements is a compilation error:
         *          - more than one method in Greeting interface
         *          - different signature of that method in interface in comparison to the signature of the Lambda expression being
         *          assigned to the interface
         *
         *    What are the differences you notice below from the main() in old style:
         *    D.1. we had stmt: Greeting greeting = new HelloGreeting();
         *    D.2. we had stmt: greeting = new MorningGreeting();
         *
         *    Which basically means that we had to define 2 classes in order to define two different actions performed by
         *    the method "perform()" - HelloGreeting and MorningGreeting
         *    But with Lambda expressions we could avoid creating those 2 classes and instead have the actions directly implemented
         *
         *    Secondly, we had to instantiate the two classes to actually perform/execute the methods corresponding to each implementation.
         *    But with Lambda, we could just use a single Lambda variable to create as well as call. which means No need to explicitly
         *    instantiate.
         *
          */


        Greeting helloGreetingLambda = () -> System.out.println("Hello there, welcome to Lambda tutorial! assigning Lambda expression to variable.");

        Greeting goodMorningLambda = () -> {
                                    System.out.println("Good Morning ");
                                    System.out.println("Two lines in my lambda expression and then assigned to a variable of a Lambda interface.");
                                };

        helloGreetingLambda.perform();
        goodMorningLambda.perform();

        /*
            note from above 4 lines and below 2 lines of code we have:

             Greeting is an interface and
             "helloGreetingLambda" and "goodMorningLambda" are acting as instances of the implementations of the interface.
             Which is why goodMorningLambda.perform() call gives output as per implementation of the lambda expression of goodMorningLambda
                    and helloGreetingLambda.perform() call gives "hello there, welcome to Lambda tutorial".

            Passing Lambda expression as a param to a method - below 2 lines
            And also we are able to pass each of them as a parameter to Greeter.greeter(Greeting instanceOfGreeting)
         */

        Greeter greeter = new Greeter();

        greeter.greet(helloGreetingLambda);
        greeter.greet(goodMorningLambda);

        /**
         *  Lambda expression with Parameters - discussed more in detail in class "TypeInferenceWithLambda"
         */

        FunctionalInterfaceConceptForLambda findSumLambdaWithParamTypes = (int a, int b) -> a+b;

        FunctionalInterfaceConceptForLambda findSumLambdaWithOutParamTypes = (a, b) -> a+b;

        FunctionalInterfaceConceptForLambda divideSafely = (int a, int b) -> {
            return (b == 0) ? 0 : (a / b);
        } ;

        /**
         * Lambda expression inline - possible only while passing it as a parameter to a method
         */

        greeter.greet(() -> System.out.println("Hello there, welcome to Lambda tutorial! This is example of inline Lambda."));

    }

}

