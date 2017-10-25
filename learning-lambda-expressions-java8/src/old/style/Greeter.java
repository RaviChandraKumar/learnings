package old.style;

/**
 * Created by empathy on 10/9/17.
 */
public class Greeter {

    public void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main(String[] args){

        //Although we want to just pass a action/verb we have to go thru interface/class/nouns and then the methods of those nouns.

        Greeter greeterInstance = new Greeter();

        Greeting greeting = new HelloGreeting();
        greeterInstance.greet(greeting);

        greeting = new MorningGreeting();
        greeterInstance.greet(greeting);

        // so insteead of going thru creating a noun and then its methods and then its instance and then passing them
        // can we just pass a verb/action as a variable - which performs some action => a block of code in a variable
        // That is what we can achieve using LAMBDA in java 8
        // see package using.lambda to see how the same above requirement is achieved using lambda in a much simpler way
        // think of it as a macro in C Programming(Procedural Paradigm)

        // Note below as a special case of implementing an interface(i.e. inline implementation) - as a anonymous inner class
        // Although this may look similar to Lambda expression in the Greeter class of using.lambda package, it is not!!!



    }
}
