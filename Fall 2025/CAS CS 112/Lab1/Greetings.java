import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {

        String[] responses = {  "are sweet"
                                ,"are a dweeb"
                                ,"are counting down to legal age"
                                ,"just made legal age"
                                ,"are counting down to 30"
                                ,"are suffering adults"
                                ,"are miserable adults"
                                ,"are speechless!!"};




        Scanner stan = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = stan.next();
        System.out.println("Hello "+name+", Welcome to CS112!!!");//fancy :)
        System.out.println(name+", how old are you? ");
	    int age = stan.nextInt();
	    System.out.println(age+"! WOW!!!");

        String insult = new String();

        if (age>50)
            

        stan.close();
    }
}



