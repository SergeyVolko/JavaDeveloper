# Документация по алгоритмам сортировки

Этот файл содержит подробное описание классов, реализующих алгоритмы сортировки, используемые в проекте. Ссылки на общую документацию и описание классов приведены ниже.

- [Назад к главному README](../../../../../../README.md)
- [SortingVisualizerApp](../README.md#sortingvisualizerapp)
- [Utility](../README.md#utility)
- [SortAlgorithm](#sortalgorithm)
- [algorithms.BubbleSort](#bubblesort)
- [InsertionSort](#insertionsort)
- [QuickSort](#quicksort)

## `algorithms.BubbleSort`

### Описание

`algorithms.BubbleSort` — это реализация пузырьковой сортировки. Этот алгоритм сортировки работает путём многократного прохода через массив, сравнения соседних элементов и обмена их местами, если они находятся в неправильном порядке. Проходы повторяются до тех пор, пока массив не будет отсортирован.

### Методы

- **`boolean sortStep(Rectangle[] bars, boolean stepByStep)`**: Выполняет один шаг алгоритма сортировки. Если `stepByStep` равно `true`, метод выполняется пошагово.
- **`void reset()`**: Сбрасывает состояние алгоритма, устанавливая начальные параметры для новой сортировки.
- **`int getOperationCount()`**: Возвращает количество операций, выполненных во время сортировки.
- **`void resetOperationCount()`**: Сбрасывает счётчик операций.
- **`String getName()`**: Возвращает название алгоритма ("Bubble Sort").
- **`String toString()`**: Возвращает название алгоритма ("Bubble Sort").

### Как это работает

В методе `sortStep` происходит проверка и обмен элементов массива, если текущий элемент больше следующего. Подсветка активных элементов производится с помощью `Utility.highlightBars`.

## `InsertionSort`

### Описание

`InsertionSort` — это реализация сортировки вставками. Этот алгоритм сортировки работает путём последовательного добавления элементов в отсортированную часть массива. На каждом шаге элемент вставляется в правильное место среди уже отсортированных элементов.

### Методы

- **`boolean sortStep(Rectangle[] bars, boolean isStepByStep)`**: Выполняет один шаг алгоритма сортировки. Если `isStepByStep` равно `true`, метод выполняется пошагово.
- **`void reset()`**: Сбрасывает состояние алгоритма, устанавливая начальные параметры для новой сортировки.
- **`int getOperationCount()`**: Возвращает количество операций, выполненных во время сортировки.
- **`void resetOperationCount()`**: Сбрасывает счётчик операций.
- **`String getName()`**: Возвращает название алгоритма ("Insertion Sort").
- **`String toString()`**: Возвращает название алгоритма ("Insertion Sort").

### Как это работает

Метод `sortStep` выполняет сравнение и обмен элементов с предыдущими элементами в отсортированной части массива. Подсветка активных элементов производится с помощью `Utility.highlightBars`.

## `QuickSort`

### Описание

`QuickSort` — это реализация быстрой сортировки. Этот алгоритм сортировки работает по принципу "разделяй и властвуй". Он выбирает опорный элемент и перемещает элементы так, чтобы элементы меньшие опорного были слева, а большие — справа. Затем рекурсивно сортирует обе части массива.

### Методы

- **`boolean sortStep(Rectangle[] bars, boolean stepByStep)`**: Выполняет один шаг алгоритма сортировки. Если `stepByStep` равно `true`, метод выполняется пошагово.
- **`void reset()`**: Сбрасывает состояние алгоритма, устанавливая начальные параметры для новой сортировки.
- **`int getOperationCount()`**: Возвращает количество операций, выполненных во время сортировки.
- **`void resetOperationCount()`**: Сбрасывает счётчик операций.
- **`String getName()`**: Возвращает название алгоритма ("Quick Sort").
- **`String toString()`**: Возвращает название алгоритма ("Quick Sort").

### Как это работает

Метод `sortStep` использует стек для отслеживания индексов разделения и вызывает метод `partition` для разделения массива. Подсветка активных элементов производится с помощью `Utility.highlightBars`.

## `SortAlgorithm`

### Описание

`SortAlgorithm` — это интерфейс для всех алгоритмов сортировки. Каждый алгоритм должен реализовать методы, определенные в этом интерфейсе.

### Методы

- **`boolean sortStep(Rectangle[] bars, boolean stepByStep)`**: Выполняет один шаг алгоритма сортировки.
- **`void reset()`**: Сбрасывает состояние алгоритма.
- **`int getOperationCount()`**: Возвращает количество операций, выполненных во время сортировки.
- **`void resetOperationCount()`**: Сбрасывает счётчик операций.
- **`String getName()`**: Возвращает название алгоритма.
