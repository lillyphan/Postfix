import java.io.*;

public class testDriver {
    public static void main(String[] args) throws FileNotFoundException {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("tests.txt"));
            String line = reader.readLine();

            while(line != null){

                Stack<Integer> stack = new Stack<>();
                String[] elements = line.split(" ", -1);

                while (!stack.isEmpty()) {
                    stack.pop();
                }

                for (String e : elements) {
                    try {
                        stack.push(Integer.parseInt(e));
                    } catch (NumberFormatException n) {
                        if (!(stack.isEmpty() || stack.top().getChild() == null)) {
                            int x = stack.pop();
                            int y = stack.pop();
                            switch (e) {
                                case "+" -> stack.push(x + y);
                                case "-" -> stack.push(x - y);
                                case "*", "x" -> stack.push(x * y);
                                case "/" -> stack.push(x / y);
                                default -> {
                                }
                            }
                        } else {
                            break;
                        }
                    }
                }
                System.out.println(stack.peek());

                line = reader.readLine();

                try(PrintWriter output = new PrintWriter(new FileWriter("log.txt",true)))
                {
                    output.printf("%s\r\n", stack.peek());
                }
                catch (Exception e) {}

            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
