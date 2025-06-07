import java.util.List;
import java.util.ArrayList;

class Flattener {

    <T> List<T> flatten(List<T> list) {
        List<T> flattenedList = new ArrayList<>();
        for (T element: list) {
            if (element instanceof List) {
                List<T> flattenedElement = flatten((List<T>) element);
                flattenedList.addAll(flattenedElement);
            } else if (element != null) {
                flattenedList.add(element);
            }
        }
        return flattenedList;
    }
}