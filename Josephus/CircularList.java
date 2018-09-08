public class CircularList {
    public Link head;

    // Constructor
    public CircularList() {
        this.head = null;
    }
    // Insert an element (value) in the list
    public void insert (int data) {
        if (this.head == null) {
            this.head = new Link(data);
            this.head.next = this.head
        } else {
            Link newLink = new Link(data);
            Link current = this.head;
            while (current.next != this.head) {
                current = current.next;
            }
            current.next = newLink;
            newLink.next = this.head;
        }
    }

    // Find the link with the given key (value)
    public Link find (int data) {
        Link current = this.head;
        if (current == null) {
            return null;
        }

        while (current.data != data) {
            if (current.next == this.head) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    // Delete a link with a given key (value)
    public void delete (int data) {
        if (this.head.data == data) {
            Link current = this.head;
            while (current.next != this.head) {
                current = current.next;
            }
            current.next = this.head.next;
            this.head = this.head.next;
        } else {
            Link current = this.head;
            Link previous = null;
            while (current.next != this.head) {
                previous = current;
                current = current.next;
                if (current.data == data) {
                    previous.next = current.next;
                    current = current.next;
                }
            }
        }
    }

    /* Delete the nth link starting from the Link start
    Return the next link from the deleted link
     */
    public Link[] delete_after (int start, int n) {
        int count = 1;
        Link start_link = this.find(start);
        if (start_link == null) {
            return null;
        }
        Link current = start_link;
        while (count < n) {
            current = current.next;
            count ++;
        }
        Link copy = current;
        Link newStart = current.next;
        this.delete(current.data);
        Link output[] = new Link[]{newStart, copy};
        return output;
    }

    public String toString() {
        if (this.head == null) {
            return "";
        }
        String output_str = "";
        int place_count = 0;
        Link current = this.head;

        while (current != null) {
            if (place_count < 10) {
                output_str += String.valueOf(current.data) + " ";
                place_count ++;
            }
            else if (place_count == 10) {
                output_str += "\n" + String.valueOf(current.data) + " ";
                place_count = 0;
                place_count ++;
            }
            if (current.next == this.head) {
                break;
            } else {
                current = current.next;
            }
        }
        return output_str;
    }
}
