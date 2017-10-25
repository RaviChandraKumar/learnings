package old.style;

/**
 * Created by empathy on 10/9/17.
 */
public class HelloGreeting implements Greeting{

    @Override
    public void perform(){
        System.out.println("Hello there, welcome!");
    }
}
