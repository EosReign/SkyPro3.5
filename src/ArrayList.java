import exception.ArrayListNonExistStrokeException;
import exception.ArrayListOutFromArrException;

public class ArrayList implements StringList {
    private String[] arr = new String[10];

    @Override
    public String add(String item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                arr[i] = item;
            }
        }
        return item;
    }

    @Override
    public String add(int index, String item) throws ArrayListOutFromArrException {
        if (index > arr.length) {
            throw new ArrayListOutFromArrException("Такого индекса в коллекции не существует");
        } else {
            if ( arr[index] != null) {
                arr[index] = item;
            } else {
                throw new ArrayListOutFromArrException("На данном индексе уже существует строка");
            }
        }
        return item;
    }

    //    А нафиг нужен этот метод если существует add c индексом, которые делает тоже самое? ( Непроработка пунктика, эх (=_=))
    @Override
    public String set(int index, String item) {
        if (index > arr.length) {
            throw new ArrayListOutFromArrException("Такого индекса в коллекции не существует");
        } else {
            arr[index] = item;
        }
        return item;
    }

    @Override
    public String remove(String item) throws ArrayListNonExistStrokeException {
        int removeCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                arr[i] = null;
                removeCount++;
            }
        }
        if (removeCount == 0) {
            throw new ArrayListNonExistStrokeException("Такой строки не существует");
        }
        return item;
    }

    @Override
    public String remove(int index) throws ArrayListOutFromArrException {
        if (index > arr.length) {
            throw new ArrayListOutFromArrException("Такого индекса в коллекции не существует");
        } else if (arr[index] == null) {
            throw new ArrayListOutFromArrException("Ячейка пустая");
        } else {
            // и как мне возвращать содержимое ячейки если return не позволяет это сделать? null возвращать мне не нужно.
            arr[index] = null;
            return arr[index];
        }
    }

    @Override
    public boolean contains(String item) {
        int isContains = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                isContains++;
            }
        }
        if (isContains == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int indexOf(String item) {
        int answer = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                answer = i;
            }
        }
        return answer;
    }

    @Override
    public int lastIndexOf(String item) {
        int answer = -1;
        for (int i = arr.length; i != 0; i--) {
            if (arr[i] == item) {
                answer = i;
            }
        }
        return answer;
    }

    @Override
    public String get(int index) throws ArrayListNonExistStrokeException{
        if (index > arr.length) {
            throw new ArrayListNonExistStrokeException("Такой ячейки не существует");
        } else if (arr[index] == null) {
            throw new ArrayListNonExistStrokeException("Ячейка пустая");
        } else {
            return arr[index];
        }
    }


    @Override
    public boolean equals(StringList otherList) {
        //А? а с чем сравнивать OtherList?
        return false;
    }

    @Override
    public int size() {
        //Аналогично. Как обращаться к коллекции?
        return -1;
    }


    @Override
    public boolean isEmpty() {
        //Аналогично
        return false;
    }


    @Override
    public void clear() {
        //Аналогично

    }

    @Override
    public String[] toArray() {
        return arr;
    }
}

