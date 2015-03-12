public class Immut implements Runnable{

    String x;

    public void run(){

        int i = 100000;

	while (i > 0){

            x = "Goodbye";
            i = i-1;

        }
    }

    public static void main(String args[]){

        (new Thread (new Immut())).start();

        x = "Hello";
        int j = 1000;

        while (j > 0){
            System.out.println(x);
            j = j-1;
        }
    }
}