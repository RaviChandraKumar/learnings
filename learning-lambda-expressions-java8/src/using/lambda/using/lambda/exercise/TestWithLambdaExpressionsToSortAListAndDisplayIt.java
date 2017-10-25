package using.lambda.using.lambda.exercise;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by empathy on 10/9/17.
 */
public class TestWithLambdaExpressionsToSortAListAndDisplayIt {

    public static void main(String[] args) {

        List<Person> listOfPerson = createListOfNewPersons();

        /**
         *sort the list of persons based on lastName using anonymous inner class - Java 7
         * Below line of code that is commented is to show how we can use anonymous inner class
         * to create an instance that implements the Comparator interface

                listOfPerson.sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
                    }
                });

        */

        /**
         *
         * sort the list of persons based on lastName using LAMBDA EXPRESSION - Java 8
         *
         * Note here we were able to use Comparator interface for our Lambda expression because it has only one
         * method defined in it which is - compare(Object o1, Object o2)
         * And that method has been overridden by the lambda expression
         * Hence, avoiding the hassle of creating an instance of a class that implements the Comparator interface

         * Also Note, we did not have to specify type of o1 and o2 params
         * and No need to add the keyword "return"
         */

        Comparator<Person> myLambdaExpressionToSortListOfPersons = (o1, o2) ->
                o1.getFirstName().compareToIgnoreCase(o2.getFirstName());

        listOfPerson.sort(myLambdaExpressionToSortListOfPersons);

        /** a shorter way to combine both of above statements and write in a single statement
         * as below - using inline Lambda expressions
         *
         */

        listOfPerson.sort((o1, o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()));

        /**
         * Below is also an implementation of lambda expressions with key things to note as:
         *  1. no need to specify what is the type of the param - "personParam"
         *  2. since its a single argument/param no need of paranthesis
         */

        displayListOfPersons( listOfPerson, personParam -> personParam.getFirstName().startsWith("a"));

    }

    private static void displayListOfPersons(List<Person> listOfPersonAsParam, Predicate<Person> predicate){
        if(!listOfPersonAsParam.isEmpty()){
            System.out.println("List Of Persons after sorting on FirstName and starting with a");
            Iterator<Person> iterateOverListOfPerson = listOfPersonAsParam.listIterator();
            while (iterateOverListOfPerson.hasNext()){
                Person personDetails = iterateOverListOfPerson.next();
                if (predicate.test(personDetails))
                    System.out.println(personDetails.toString());
            }
        }
        else
            System.out.println("Nothing to display. List is empty.");
    }

    private static List<Person> createListOfNewPersons(){

        List<Person> listOfPersons = new ArrayList<Person>();
        listOfPersons.add(new Person("jjk", "jjk", 55));
        listOfPersons.add(1, new Person("ffg","ffg", 44));
        listOfPersons.addAll(Arrays.asList(new Person("bbb","bvfg",33),
                new Person("acc","mko",22)
                )
        );
        listOfPersons.addAll(4,Arrays.asList(new Person("abb","lki",11 ),
                new Person("aaa","nji",00))
        );
        return listOfPersons;
    }



}

