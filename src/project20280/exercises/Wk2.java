package project20280.exercises;

public class Wk2 {
    /* Q2 */
    /* PSEUDO CODE

    Var:
        stack1: enqueue
        stack2: dequeue

    enqueue(e):
        Push e onto stack1

    dequeue():
        If stack2 is empty:
            pop element from stack1
            push element to stack2
        Pop and return the top element from stack2
   */

    public class StackQueue<E> implements Queue<E> {
        private Stack<E> stack1; // For enqueue
        private Stack<E> stack2; // For dequeue

        public void enqueue(E e) {
            stack1.push(e);
        }

        public E dequeue() {
            if(stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop();
        }
    }

    /* Q3 */
    /* PSEUDO CODE

    Var:
        A: given stack
        B: stack1 - enqueue
        C: stack2 - dequeue

    reverseStack(A):
        While A is not empty:
            pop element from A
            push element to B

        While B is not empty:
            pop element from B
            push element to C

        While C is not empty:
            pop element from C
            push element to A
   */

    /* Q4 */

    public class BaseConverter {
        static String convertToBinary(long dec_num, int base) {
            if (dec_num == 0) {
                return "0";
            }

            Stack<Long> stack = new LinkedStack<>();

            // Repeated Division
            while (dec_num > 0) {
                stack.push(dec_num % base);
                dec_num /= base;
            }

            // Pop from stack to build the string in correct order
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            return sb.toString();
        }
    }
}
