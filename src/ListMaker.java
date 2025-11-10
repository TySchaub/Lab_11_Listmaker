import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {

    private static ArrayList<String> lines = new ArrayList<>();
    static String MENU_PROMPT = "A - Add D - Delete I - Insert P - Print Q - Quit";
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String cmd = "";
        boolean done = false;

        do {
            showList();
            showMenu();
            cmd = SafeInput.getRegExString(in, "Enter Menu Choice: ", "[AaDdIiPpQq]").toUpperCase();

            switch (cmd)
            {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    System.out.println("You chose to print the list.");
                    break;
                case "Q":
                    System.exit(0);
                    break;
            }
        } while (!done);

    }
    private static void showList() {
        if (lines.size() == 0)
        {
            System.out.println(" ");
            System.out.println("The list is empty.");
            return;
        }
        else {
            for (String l : lines)
            {
                System.out.println(" ");
                System.out.println(l);
            }
        }
        System.out.println("\n-----------------------------------------------");
    }

    private static void showMenu()
    {
        System.out.println("-----------------------------------------------");
        System.out.println(MENU_PROMPT);
        System.out.println("-----------------------------------------------");
    }

    private static void addItem()
    {
        String item = SafeInput.getNonZeroLengthString(in, "Enter the line to add: ");
        lines.add(item);
    }

    private static void deleteItem()
    {
        if (lines.size() == 0)
        {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        int lineNum = SafeInput.getInt(in, "Enter the line number to delete (1 to " + lines.size() + "): ");
        if (lineNum < 1 || lineNum > lines.size())
        {
            System.out.println("Invalid line number. Please try again.");
            return;
        }
        lines.remove(lineNum - 1);
        System.out.println("Line " + lineNum + " has been deleted.");
    }

    private static void insertItem()
    {
        if (lines.size() == 0)
        {
            System.out.println("The list is empty. Nothing to insert.");
            return;
        }
        int lineNum = SafeInput.getInt(in, "Enter the line number to insert (1 to " + lines.size() + "): ");
        if (lineNum < 1 || lineNum > lines.size())
        {
            System.out.println("Invalid line number. Please try again.");
            return;
        }
    }
}
