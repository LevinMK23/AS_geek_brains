package Stack;

import java.util.LinkedList;

public class StackTasks {

    /*
    * Для решения задач используйте свой стек
    */



        /*
        * Правильная скобочная последовательность,
        * это последовательность,
        * которая может быть получена по следующим правилам:
        * Пусть s = "()" - правильная последовательность
        * Тогда s1 = "(" + s + ")" - тоже правильная
        * Если s2, s3 - правильные последовательности,
        * то s2 + s3 - тоже правильная
        * Проще говоря - такая последовательность,
        *  где на каждую открытую скобку есть своя закрытая
        * ()(()) true
        * (())((())) true
        * ( false
        * (() false
        * Stack solution
        * if "(" push
        * else pop
        * if empty stack - true
        * else false
        * */
    public boolean trueBracketSequences(String sequence){
        // TODO: 18/11/2019
        Stack<Character> stack = new Stack<Character>();
        char [] c = sequence.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] =='(') stack.push('(');
            else {
                if (stack.size() == 0) return false;
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

    /*
    * Помытая посуда укладывается в стопки до достижения
    * лимита, если лимит достигнут, нужно завести новую стопку.
    * Достать тарелку можно только с последней стопки.
    * Реализуйте структуру данных для хранения и извлечения тарелок
    * лимит = 2
    * пуш:
    * а б конец стопки
    * в г конец стопки
    * д
    * поп:
    * д
    * г в
    * б а
    * */
    static class CrockeryStack {
        //size - counterOfStacks
        int limit, counter, size;
        Stack<Stack<String>> stacks;



        public CrockeryStack(int limit) {
            this.limit = limit;
            counter = 0;
            size = 0;
            stacks = new Stack<Stack<String>>();
        }
        // TODO: 18/11/2019

        public String pop(){
            // TODO: 18/11/2019
            String item = null;
            if (stacks.size() == 0) return null;
            if (stacks.top().size() == 0) {
                stacks.pop();
                if (stacks.size() == 0) return null;
                item = stacks.top().top();
                stacks.top().pop();
            }
            else {
                item = stacks.top().top();
                stacks.top().pop();
            }
            return item;
        }

        public void push(String item){
            // TODO: 18/11/2019
            if (stacks.size() == 0) {
                stacks.push(new Stack<String>());
                size++;
            }
            if (stacks.top().size() < limit) {
                stacks.top().push(item);
            }
            else {
                stacks.push(new Stack<String>());
                size++;
                stacks.top().push(item);
            }
        }

        public void show() {
            for (Stack<String> s : stacks) {
                s.show();
                s.top();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new StackTasks()
                .trueBracketSequences("())((()())())"));
//        CrockeryStack stack = new CrockeryStack(3);
//        for (int i = 0; i < 7; i++) {
//            stack.push("crockery " + (i + 1));
//        }
//        stack.show();
//        for (int i = 0; i < 7; i++) {
//            System.out.print(stack.pop() + " ");
//        }

    }
}
