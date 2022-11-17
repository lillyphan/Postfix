import java.util.Scanner;

public class Postfix {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int addedInt = 0;
        String userInput = "y";
        boolean error = false;

        do {
            while(!stack.isEmpty()){
                stack.pop();
            }

            System.out.println("enter a problem: ");
            String exp = s.nextLine();

            for (int i = 0; i < exp.length(); i++) {
                switch (exp.charAt(i)) {
                    case '0' -> stack.push(0);
                    case '1' -> stack.push(1);
                    case '2' -> stack.push(2);
                    case '3' -> stack.push(3);
                    case '4' -> stack.push(4);
                    case '5' -> stack.push(5);
                    case '6' -> stack.push(6);
                    case '7' -> stack.push(7);
                    case '8' -> stack.push(8);
                    case '9' -> stack.push(9);
                    case ' ' -> {}
                    default -> {
                        if (!(stack.isEmpty() || stack.top().getChild() == null)) {
                            int x = stack.pop();
                            int y = stack.pop();
                            switch (exp.charAt(i)) {
                                case '+' -> stack.push(x + y);
                                case '-' -> stack.push(x - y);
                                case '*' -> stack.push(x * y);
                                case '/' -> stack.push(x / y);
                                default -> {}
                            }
                        } else {
                            error = true;
                        }
                    }
                }
                if (error){
                    System.out.println("not enough operands");
                    break;
                }
            }
            System.out.println("answer: " + stack.peek());
            System.out.println("type y to solve another expression or n to exit");
            userInput = s.nextLine();
        } while (userInput.equals("y"));

    }

}
