package using.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by empathy on 10/17/17.
 */
public class NewWayToIterateCollectionUsingForEach {

    public static Integer sum = new Integer(0);

    private static void performActionStaticMethod(int a){
        //sum+=a;
        System.out.println("User defined lambda to find sum of intergers in collection");
        System.out.println("Sum found so far : " + sum);
    }

    public static void main(String[] args) {

        List<Integer> listOfIntegers = Arrays.asList(
                new Integer(10),
                new Integer(20),
                new Integer(30),
                new Integer(40),
                new Integer(50)
        );

        System.out.println("\n Running new forEach of Java 8 using Lamda Expression-MethodReference");
        // Java 8
        // New Way of running forEach item in a collection
        // This does not do the iteration in order
        // And as a result there is an advantage on parallel processing and multi threading
        // how? - because this way it just tells the runtime that i want to iterate over each element of this collection-listOfIntergers,
        // Rest the runtime take care of everything else
        // how to iterate, how many threads to use, parallel or sequential - based on availability

        listOfIntegers.forEach(System.out::println);

        System.out.println("\nAnother example of lambda in forEach of Java 8 using Lamda Expression\n");

        //JAVA 8
        /*
            New Way of running forEach item in a collection
            SAME AS ABOVE, except that here we have explicitly passed a lambda expression
            Note: the lambda expression passed in the forEach() should be of this kind:
                    ------ (oneParam) -> methodDefinition with one parameter
                    of type same/compatible as the type of the elements in the collection

                    so in our example we have listOfIntegers as a coll of Integers
                    so our lambda expression that is passed to forEach should
                    have a definition such that it will accept one and only one parameter
                    which can be autoboxed or auto-unboxed from the type in collection to type in lambda expression

         */
        listOfIntegers.forEach(i -> System.out.println("Next element from listOfIntegers : " + i));

        System.out.println("\nAnother example of lambda in forEach of Java 8 using Explicit Method Reference\n");

        listOfIntegers.forEach(NewWayToIterateCollectionUsingForEach::performActionStaticMethod);

        System.out.println("\n Running for each using JAVA 7");

        // Java 7
        for (Integer ele : listOfIntegers){
            System.out.println(ele);
        }
    }

}
