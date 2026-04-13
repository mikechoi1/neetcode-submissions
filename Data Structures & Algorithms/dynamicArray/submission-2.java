class DynamicArray {
    public int[] dynamicArray;
    public int size;

    public DynamicArray(int capacity) {
        assert capacity > 0;
        this.dynamicArray = new int[capacity];
        this.size = 0;
    }

    public int get(int i) {
        return this.dynamicArray[i];
    }

    public void set(int i, int n) {
        this.dynamicArray[i] = n;
    }

    public void pushback(int n) {
        //System.out.println(printArray());
        if (this.size >= this.dynamicArray.length) {
            resize();
        }
        this.dynamicArray[this.size++] = n;
    }

    public int popback() {
        return this.dynamicArray[--this.size];

    }
    
    public String printArray() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.dynamicArray.length; i++) {
            sb.append(this.dynamicArray[i] + ", ");
        }
        sb.append("]" + this.size);
        return sb.toString();
    }

    private void resize() {
        int[] newArray = new int[this.dynamicArray.length * 2];
        for (int i = 0; i < this.dynamicArray.length; i++) {
            newArray[i] = this.dynamicArray[i];
        }
        this.dynamicArray = newArray;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.dynamicArray.length;
    }
}
