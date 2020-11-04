import java.util.List;

public class GenericMethodExample {
    public <T> void addElementToList(T element, List<T> list) {
        list.add(element);
    }
}
