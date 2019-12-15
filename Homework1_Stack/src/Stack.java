import java.util.Scanner;

class Stack_static{
    private int [] stack = new int[Const_define.MAX_SIZE];
    private int peak;
    public Stack_static() {
        peak = -1;
    } // stack constructor
    public void push_element( int element ){
        if ( peak < Const_define.MAX_SIZE) {
            stack[++peak] = element;
        }
        else{
            System.out.println("Push operation denied! Stack overflow!");
        }
    }
    public int  pop_element(){
        return stack[peak--];
    }
    public int get_top(){
        System.out.println("The top element is" + " " + stack[peak]);
        return peak;
    }
    public boolean is_stack_empty()
    {
        if ( peak == -1 ) {
            System.out.println("Stack is empty");
            return Const_define.TRUE;
        }
        else {
            System.out.println("Stack is not empty");
            return Const_define.FALSE;
        }
    }
    public void delete_elements( int n, int m )
    {
        if ( n < 0 || m > peak){
            System.out.println("ERROR! You try delete elements , which don`t exist.");
        }
        else {
            int delta = m - n + 1;
            for( int j = m ; j <= peak; j++){
                stack[j - delta] = stack[j];
            }
            peak = peak - delta;
        }
    }
    public void print_stack() {
        for( int i = peak; i >= 0; i--) {
            System.out.println( peak - i + 1 + " element" + " is " +  stack[i]);
        }
    }
}


class Stack_static_Test_drive{
    public static void main( String [] args ){
        Stack_static stack = new Stack_static();
        int pop_element, n , m;
        Scanner sc = new Scanner(System.in);
        // Pushing 5 elements into stack
        stack.is_stack_empty(); //Check if stack is empty
        for (int i = 1; i < 6; i++){
            stack.push_element(i);
        }
        stack.print_stack(); //Check if stack is empty
        pop_element = stack.pop_element();
        System.out.println("Popped elements is" + " " + pop_element);
        stack.print_stack(); // Stack after delete peak element
        System.out.println("Enter position n :");
        n = sc.nextInt();
        System.out.println("Enter position m :");
        m = sc.nextInt();
        System.out.printf("Delete elements from %d to %d positions inclusive \n", n, m);
        stack.delete_elements(n , m);
        stack.print_stack();
    }
}