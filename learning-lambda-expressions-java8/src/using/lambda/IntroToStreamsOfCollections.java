package using.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by empathy on 10/17/17.
 */
public class IntroToStreamsOfCollections {

    public static void main(String[] args) {

        List<Integer> listOfIntegers = Arrays.asList(
                new Integer(101),
                new Integer(202),
                new Integer(303),
                new Integer(404),
                new Integer(505)
        );

        System.out.println("\nUsing Stream of JAVA 8 to perform operations on a collection. \n");

        listOfIntegers.stream()

                .filter(i -> i%2==0) // filter to remove all odd numbers and retain only even nos.
                                    //  filter uses the lambda expression

                .filter(i -> i != ++i) // Note here although we have done ++i it does not affect/change the values
                                        // of the elements in the stream => the value is passed by value
                                        // and becomes local only to that lambda expression

                .forEach(x -> System.out.println("Elements Remaining in the stream after applying filter are: " + x));

        System.out.println("\nElememts in list after closing the stream: \n");

        listOfIntegers.forEach(System.out::println);

    }
}
