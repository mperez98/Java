public class Link {
    int data;
    Link next;

    // Constructor
    public Link(int data) {
        this.data = data;
        this.next = null;
    }

    public String toString() {
        return data.toString();
    }
}
