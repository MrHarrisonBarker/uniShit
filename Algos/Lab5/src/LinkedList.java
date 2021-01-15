import java.util.List;
import java.util.Scanner;

class LinkedList
{

    Node head;

    static class Node
    {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    //Insert node at the beginning of the list
    public static LinkedList insert_start(LinkedList list, int data)
    {
        // We create the new node 
        Node newNode = new Node(data);

        //Now we link the node to the list 
        newNode.next = list.head;
        list.head = newNode;

        // Return the modified list
        return list;
    }

    //Display the content of the linked list 
    public static void printList(LinkedList list)
    {
        Node tmp = list.head;
        if (tmp != null)
        {
            System.out.println("The content of the list is:");
            // Traverse the list
            while (tmp != null)
            {
                // Print the data at current node
                System.out.print(tmp.data);

                // Move to next node
                tmp = tmp.next;
                if (tmp != null)
                    System.out.print("->");
            }
            System.out.println("");
        } else
            System.out.println("The list is empty");
    }

    public static void printList(LinkedList list, int k)
    {
        int length = listLength(list);
        if (k > listLength(list))
        {
            System.out.println(String.format("The list has only %s elements", length));
            return;
        }

        if (k < 0)
        {
            System.out.println("Error you cannot enter a negative number");
            return;
        }

        Node tmp = list.head;
        if (tmp != null)
        {
            System.out.println("The content of the list is:");
            // Traverse the list
            while (tmp != null && k > 0)
            {
                // Print the data at current node
                System.out.print(tmp.data);

                // Move to next node
                tmp = tmp.next;
                if (tmp != null && k != 1)
                    System.out.print("->");

                k--;
            }
            System.out.println("");
        } else
            System.out.println("The list is empty");
    }

    public static int countList(LinkedList List, int x)
    {
        Node current = List.head;
        if (current == null)
        {
            return 0;
        }
        int occurrences = 0;
        while (true)
        {
            if (current.data == x)
            {
                occurrences++;
            }


            if (current.next != null)
            {
                current = current.next;
            } else
            {
                return occurrences;
            }
        }

    }

    public static boolean searchList(LinkedList list, int x)
    {
        Node current = list.head;
        if (current == null)
        {
            return false;
        }
        while (true)
        {
            if (current.data == x)
            {
                return true;
            }


            if (current.next != null)
            {
                current = current.next;
            } else
            {
                return false;
            }
        }

    }

    //Delete the first element with data part equal to x
    public static LinkedList delete(LinkedList list, int x)
    {
        Node tmp = list.head;
        Node prev;

        if (tmp == null)
        {
            System.out.println("There is nothing to delete");
            return list;
        } else
        {

            //Case 1: x is found in the first node
            if (tmp.data == x)
            {
                list.head = tmp.next; //head points to the second element
                return list;
            } else   //Case 2: X is not in the first position, we must keep searching
            {
                prev = tmp;
                tmp = tmp.next;
                while (tmp != null)
                {
                    if (tmp.data == x)
                    {
                        prev.next = tmp.next;
                        return list;
                    }
                    prev = tmp;
                    tmp = tmp.next;
                }
            }
            System.out.println("Element not found");
            return list;
        }

    }

    public static void insert_end(LinkedList list, int x)
    {
        Node current = list.head;

        if (current == null)
        {
            list.head = new Node(x);
        }

        while (true)
        {
            if (current.next == null)
            {
                current.next = new Node(x);
            } else
            {
                current = current.next;
            }
        }
    }

    public static int listLength(LinkedList list)
    {
        Node current = list.head;
        if (current == null)
        {
            return 0;
        }
        int length = 1;
        while (true)
        {
            if (current.next != null)
            {
                length++;
                current = current.next;
            } else
            {
                return length;
            }
        }
    }


    public static void main(String[] args)
    {
        //create a new list
        LinkedList list = new LinkedList();

        //Create variable to read from keyboard
        Scanner in = new Scanner(System.in);
        int option, x;


        do
        {
            System.out.println("Select your option:");
            System.out.println("0: Quit the programme");
            System.out.println("1: Insert an element to the beginning of the list");
            System.out.println("2: Delete an element to the list");
            System.out.println("3: Print the content of the list");
            System.out.println("4: Print the length of the list");
            System.out.println("5: Print k elements of the list");
            System.out.println("6: Find the occurrences of x in the list");
            System.out.println("7: Search for x in the list");

            option = in.nextInt();
            if (option == 1)
            {
                System.out.println("What number do you want to insert?");
                x = in.nextInt();
                list = insert_start(list, x);
                printList(list);
            }

            if (option == 2)
            {
                System.out.println("What number do you want to delete?");
                x = in.nextInt();
                list = delete(list, x);
                printList(list);
            }

            if (option == 3)
                printList(list);

            if (option == 4)
                System.out.println(String.format("The length of the list is: %s", listLength(list)));

            if (option == 5)
            {
                System.out.println("How many elements do you want to print?");
                x = in.nextInt();
                printList(list, x);
            }

            if (option == 6)
            {
                System.out.println("What data do you want to count?");
                x = in.nextInt();
                System.out.println(String.format("The number of occurrences of %s: %s", x, countList(list, x)));
            }

            if (option == 7)
            {
                System.out.println("What data do you want to search for?");
                x = in.nextInt();
                System.out.println(searchList(list, x));
            }

            if (option == 0)
                System.out.println("Good bye!");


        } while (option != 0);

    }
} 
