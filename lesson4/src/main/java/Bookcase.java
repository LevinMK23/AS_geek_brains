
public class Bookcase {

    private int shelvesCount;
    private int shelveCapacity;

    //класс должен работать!!!
    private MyLinkedList<MyLinkedList<String>> bookcase;

    /*
    *  Разработайте структуру данных книжный шкаф
    *  в шкафе есть shelvesCount полок, каждая из которых
    *  может вмещать не более shelveCapacity книг
    *  Механика добавления книги в шкаф:
    *  выбираем номер полки, на полку можно положить книгу либо справа либо слева
    *  от имеющихся там книг
    *  Механика извлечения книги:
    *  можно вытащить любую книгу с любой полки, достаточно передать
    *  в метод номер полки и номер книги
    *  Нумерация полок с 1, нумерация книг с 1
    * */

    //side - либо 'L' либо 'R'
    public void putBook(int shelveNumber, char side, String bookName) {
        // TODO: 21/11/2019
    }

    //Взятая книга удаляется из шкафа!
    public String takeBook(int shelveNumber, int bookNumber) {
        // TODO: 21/11/2019
        return null;
    }

    public void showBookcase() {
        int cnt = 1;
        for (MyLinkedList<String> list : bookcase) {
            System.out.print("Полка № " + cnt + ": ");
            cnt++;
            for (String book : list) {
                System.out.print(book + " ");
            }
            System.out.println();
        }
    }

}
