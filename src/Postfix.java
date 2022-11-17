import java.util.Scanner;

public class Postfix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        String userInput = "y";
        do {
            while(!stack.isEmpty()){
                stack.pop();
            }
            System.out.println("enter a problem: ");
            String exp = s.nextLine();
            String[] elements = exp.split(" ", -1);
            for (String e: elements){
                try {
                    stack.push(Integer.parseInt(e));
                }
                catch (NumberFormatException n) {
                    if (!(stack.isEmpty() || stack.top().getChild() == null)) {
                        int x = stack.pop();
                        int y = stack.pop();
                        switch (e) {
                            case "+" -> stack.push(x + y);
                            case "-" -> stack.push(x - y);
                            case "*", "x" -> stack.push(x * y);
                            case "/" -> stack.push(x / y);
                            default -> {}
                        }
                    } else {
                        System.out.println("Not enough operands/operators");
                        break;
                    }
                }
            }
            System.out.println("answer: " + stack.peek());
            System.out.println("type y to solve another expression or n to exit");
            userInput = s.nextLine();
        } while (userInput.equals("y"));

    }

}
