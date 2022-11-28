import java.util.Scanner;

public class Postfix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        String userInput = "y";
        do { //do while loop to prompt the user at least once
            while(!stack.isEmpty()){ //empty out stack before entering a new equation
                stack.pop();
            }
            System.out.println("enter a problem: "); //prompt user for an equation
            String exp = s.nextLine();
            String[] elements = exp.split(" ", -1); //split up string into it's parts (numbers + operators)
            for (String e: elements){ //loops through all parts
                try { //try to push element as an integer
                    stack.push(Integer.parseInt(e));
                }
                catch (NumberFormatException n) { //if it doesn't work, it is not an integer
                    if (!(stack.isEmpty() || stack.top().getChild() == null)) { //if the stack isn't empty or doesn't only have one element
                        int x = stack.pop(); //pop top two elements
                        int y = stack.pop();
                        switch (e) { //detect which operator current element is
                            case "+" -> stack.push(x + y);
                            case "-" -> stack.push(x - y);
                            case "*", "x" -> stack.push(x * y);
                            case "/" -> stack.push(x / y);
                            default -> {}
                        }
                    } else { //if the stack is empty or only has one element w/ operator, there is an error with the user input
                        System.out.println("Not enough operands/operators");
                        break;
                    }
                }
            }
            System.out.println("answer: " + stack.peek()); //answer is at top of stack and is returned to user
            System.out.println("type y to solve another expression or n to exit"); //update do while condition
            userInput = s.nextLine();
        } while (userInput.equals("y")); //while user prompts yes, program will continue to run

    }

}
