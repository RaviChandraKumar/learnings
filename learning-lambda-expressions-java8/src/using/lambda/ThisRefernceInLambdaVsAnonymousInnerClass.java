package using.lambda;

/**
 * Created by empathy on 10/16/17.
 */
public class ThisRefernceInLambdaVsAnonymousInnerClass {

    private int b = 4444;

    public void performAction(int a, MyLambda ml){
        ml.perform(a);
    }

    private static void performActionStaticMethod(int a, MyLambda p){
        p.perform(a);
    }

    public void callPerformAction(int a){
        performAction(a, x -> {
            //Var b defined inside Lambda -> this value is not what we get when we do this.b
            int b = 200;

            System.out.println("\nUsing this reference inside the lambda expression.\n" +
                    "this reference will be the instace that is making the call to this expression.\n" +
                    "that is the instance of the enclosing class/outer class.\n"+
                    "Hence, we will try to access the other variable b of the enclosing class " +
                    "without having been passed it as a parameter. Value of a + thisReference.b = " + (a+this.b));

        });
    }
    public static void main(String[] args){

        int a = 10;
        int b = 20;

         /*
            Java - 8

            "this" reference inside lambda will be a reference of the enclosing class in which lambda is defined
            so, "this.variable" inside a lambda expression will give the value of the "variable" defined
            in outer class

          */

        ThisRefernceInLambdaVsAnonymousInnerClass thisRefernceInLambdaVsAnonymousInnerClass = new ThisRefernceInLambdaVsAnonymousInnerClass();

        thisRefernceInLambdaVsAnonymousInnerClass.callPerformAction(a);

        /*
            Java - 7

            "this" reference inside AIC will be a reference of the AIC instantiated within the enclosing class
            and not a reference of the eclosing class itself
            so, "this.variable" inside a AIC will give the value of the "variable" defined
            in AIC
            Hence, for Below lines of code will not get an error because "this" is not of static context
            instead its in the context of the AIC which is not static
        */

        performActionStaticMethod(a, new MyLambda() {

            //Var a,b defined inside th AIC
            int a = 100; // this value if "a" will not be used below because we are accessing a without this reference
            int b = 200; // this value of "b" will be used below

            @Override
            public void perform(int a) {

                System.out.println("\nUsing this reference inside the AIC.\n" +
                        "this reference will be the instance of the AIC itself.\n" +
                        "Hence, we will try to access the other variable b using this reference " +
                        "Value of a + thisReference.b = " + (a+this.b) );
            }
        });

    }
}
