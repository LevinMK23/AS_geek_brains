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
        return false;
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
    class crockeryStack {

        int limit;
        Stack<Stack> stacks;

        public crockeryStack(int limit) {
            this.limit = limit;
        }
        // TODO: 18/11/2019

        public String pop(){
            // TODO: 18/11/2019
            return null;
        }

        public void push(String item){
            // TODO: 18/11/2019
        }
    }


}
