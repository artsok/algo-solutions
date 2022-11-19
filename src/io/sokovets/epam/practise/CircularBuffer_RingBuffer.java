package io.sokovets.epam.practise;

//https://www.baeldung.com/java-ring-buffer

/**
 * Ring Buffer (or Circular Buffer) is a bounded circular data structure that is used for buffering data between two or more threads.
 * As we keep writing to a ring buffer, it wraps around as it reaches the end.
 * <p>
 * The first thing we need to know is the capacity – the fixed maximum size of the buffer.
 * Next, we'll use two monotonically increasing sequences:
 * <p>
 * Write Sequence: starting at -1, increments by 1 as we insert an element
 * Read Sequence: starting at 0, increments by 1 as we consume an element
 * <p>
 * A ring buffer is an efficient FIFO buffer.
 */
public class CircularBuffer_RingBuffer<E> {

    private final static int DEFAULT_CAPACITY = 3;
    private int capacity;

    //In the offer method, a write to the volatile field writeSequence guarantees that the writes to the buffer
    // happen before updating the sequence.
    // At the same time, the volatile visibility guarantee ensures that the consumer will always see the latest value of writeSequence.
    private volatile int writeSequence, readSequence;
    private final E[] data;


    //First, let's define a constructor that initializes the buffer with a predefined capacity:
    public CircularBuffer_RingBuffer(int capacity) { //Закидываем объем
        this.capacity = (capacity < 1) ? DEFAULT_CAPACITY : capacity;
        this.data = (E[]) new Object[this.capacity];
        this.readSequence = 0;
        this.writeSequence = -1;

    }


    /**
     * Next, we'll implement the offer operation that inserts an element into the buffer at the next
     * available slot and returns true on success. It returns false if the buffer can't find an empty slot,
     * that is, we can't overwrite unread values.
     * <p>
     * So, we're incrementing the write sequence and computing the index in the array for the next available slot.
     * Then, we're writing the data to the buffer and storing the updated write sequence.
     *
     * @param element
     * @return
     * @Test public void givenCircularBuffer_whenAnElementIsEnqueued_thenSizeIsOne() {
     * CircularBuffer buffer = new CircularBuffer<>(defaultCapacity);
     * <p>
     * assertTrue(buffer.offer("Square"));
     * assertEquals(1, buffer.size());
     * }
     */
    public boolean offer(E element) {
        //Есть место куда добавлять?
        if (isNotFull()) {
            //Куда записываем следующий элемент
            int nextWriteSeq = writeSequence + 1;

            //Определяем в какую ячейку будем вставлять элемент
            data[nextWriteSeq % capacity] = element;

            //Как вставили увеличи writeSequence
            writeSequence++;
            return true;
        }

        return false;
    }


    /**
     * Finally, we'll implement the poll operation that retrieves and removes the next unread element.
     * The poll operation doesn't remove the element but increments the read sequence.
     *
     * Here, we're reading the data at the current read sequence by computing the index in the array.
     * Then, we're incrementing the sequence and returning the value, if the buffer is not empty.
     *
     * @return
     */
    public E poll() {
        if (isNotEmpty()) {
            E nextValue = data[readSequence % capacity];
            readSequence++;
            return nextValue;
        }
        return null;
    }

    //Тесты:
    /** @Test
    public void givenCircularBuffer_whenAnElementIsDequeued_thenElementMatchesEnqueuedElement() {
        CircularBuffer buffer = new CircularBuffer<>(defaultCapacity);
        buffer.offer("Triangle");
        String shape = buffer.poll();

        assertEquals("Triangle", shape);
    } **/

    //Размер нашего кольца
    public int size() {
        return (writeSequence - readSequence) + 1;
    }

    //Если у нас все заполнено
    public boolean isFull() {
        return size() >= capacity;
    }

    //Если у нас
    public boolean isEmpty() {
        return writeSequence < readSequence;
    }

    //Если еще не доконца заполнен
    private boolean isNotFull() {
        return !isFull();
    }


    //Проверяем есть ли у нас данные
    private boolean isNotEmpty() {
        return !isEmpty();
    }
}
