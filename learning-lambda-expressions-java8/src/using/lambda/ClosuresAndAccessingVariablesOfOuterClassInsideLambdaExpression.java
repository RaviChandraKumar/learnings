package using.lambda;

/**
 * Created by empathy on 10/10/17.
 */
public class ClosuresAndAccessingVariablesOfOuterClassInsideLambdaExpression {


    int b = 4444;

    private static void performAction(int a, MyLambda p){

        p.perform(a);
    }

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        /**
         * Java -7
         * Even in case of Anonymous inner class, one CANNOT MODIFY/CHANGE THE VALUE of the
         * variable of enclosing method
         * Here, we see that "b" cannot be modified inside the definition of anonymous inner class.
         * But can definitely use the value of it as is.
         * Which means "b" is essentially a FINAL variable.
         */
         /* Uncomment below lines of code to check for urself

                performAction(a, new MyLambda() {
                    @Override
                    public void perform(int a) {
                        b = 30;
                        System.out.println("Inside anonymous inner class trying to modify outer class variable");
                    }
                });

        */

        /**
         * Java - 8
         * Same in case of Lambda Expressions, one cannot CANNOT MODIFY/CHANGE THE VALUE of the variable of outer class
         * But can definitely use the value of it as is.
         * Here, we see that "b" cannot be modified inside the definition of Lambda.
         * Which means "b" is essentially a FINAL variable.
         */

        /* Uncomment below lines of code to check for urself


                performAction(a, x -> {
                    b = 30;
                    System.out.println("Inside Lambda Expression trying to modify the var of outer class");
                });

        */

        /*
            Java - 8
            CLOSURES - a variable of outer class is always passed by value to Lambda Expression that uses it
            Which is why we will see below that
            once that variable b is passed inside Lambda expression it will receive
            the value of b as 20 only, even if it got changed before the value was used by Lambda
         */

        performAction(a, x -> System.out.println("\nValue of " +
                "(first param passed + other variable which is outside the lambda)" +
                " inside Lambda is " + (a+b)));


        performAction(a, System.out::println);

        /*
            Java - 7

            Although the anonymous inner class(AIC) also behaves in the same way as above while using the value
            of the outer variable, it is not called as CLOSURE. :P

         */

        performAction(a, new MyLambda() {

            //Var a,b defined inside th AIC
            int a = 100;
            int b = 200;

            @Override
            public void perform(int a) {
                System.out.println("\n\nInside anonymous inner class trying to use variable which is outside the AIC.");
                System.out.println("Value of (first param passed + outer variable) is " + (a+b));
            }
        });

         /*
            Java - 8

            "this" reference inside lambda will be a reference of the enclosing class in which lambda is defined
            so, "this.variable" inside a lambda expression will give the value of the "variable" defined
            in outer class
            But Below lines of code will give an error because "this" cannot be referenced in static context

                performAction(a, x -> {
                    System.out.println("Value of (first param passed + outer variable) " +
                            "inside Lambda is " + (this));  // this is illegal bec. cannot reference this in static context
                });

         */

         /*
            Java - 7

            "this" reference inside AIC will be a reference of the AIC instantiated within the enclosing class
            and not a reference of the eclosing class itself
            so, "this.variable" inside a AIC will give the value of the "variable" defined
            in AIC
            Hence, for Below lines of code will not get an error because "this" is not of static context
            instead its in the context of the AIC which is not static
        */

        performAction(a, new MyLambda() {

            //Var a,b defined inside th AIC
            int a = 100;
            int b = 200;

            @Override
            public void perform(int a) {

                System.out.println("\n\nInside anonymous inner class trying to use variable using this reference.");
                System.out.println("Value of (first param passed + inside AIC variable) is " + (a+this.b));
            }
        });

    }
}
