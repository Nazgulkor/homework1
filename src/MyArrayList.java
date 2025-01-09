import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T> {
    private Object[] elements;
    private int size;

    // Стандартная начальная вместимость
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Создает пустой список с начальной вместимостью 10.
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления
     */
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Добавляет элемент в заданную позицию списка.
     *
     * @param index   позиция для вставки элемента
     * @param element элемент для добавления
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Получает элемент из заданной позиции списка.
     *
     * @param index позиция элемента для получения
     * @return элемент, находящийся в указанной позиции
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        return (T) elements[index];
    }

    /**
     * Удаляет элемент из заданной позиции списка.
     *
     * @param index позиция элемента для удаления
     * @return удаленный элемент
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removedElement;
    }

    /**
     * Очищает список, удаляя все элементы.
     */
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    /**
     * Сортирует список
     *
     * @param comparator компаратор для определения порядка сортировки
     */
    @SuppressWarnings("unchecked")
    public void sort(Comparator<T> comparator) {
        T[] array = (T[]) Arrays.copyOf(elements, size);
        quickSort(array, 0, size - 1, comparator);
        System.arraycopy(array, 0, elements, 0, size);
    }

    /**
     * Обеспечивает достаточную вместимость внутреннего массива.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    /**
     * Алгоритм QuickSort для сортировки массива.
     *
     * @param array      массив для сортировки
     * @param low        начальный индекс
     * @param high       конечный индекс
     * @param comparator компаратор для определения порядка сортировки
     */
    private void quickSort(T[] array, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, comparator);
            quickSort(array, low, pivotIndex - 1, comparator);
            quickSort(array, pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Разделяет массив для алгоритма QuickSort.
     *
     * @param array      массив для разделения
     * @param low        начальный индекс
     * @param high       конечный индекс
     * @param comparator компаратор для определения порядка сортировки
     * @return индекс опорного элемента
     */
    private int partition(T[] array, int low, int high, Comparator<T> comparator) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    /**
     * Меняет местами два элемента в массиве.
     *
     * @param array массив, в котором нужно поменять элементы
     * @param i     индекс первого элемента
     * @param j     индекс второго элемента
     */
    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Возвращает размер списка.
     *
     * @return количество элементов в списке
     */
    public int size() {
        return size;
    }
}
