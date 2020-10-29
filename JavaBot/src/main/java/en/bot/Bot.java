package en.bot;


public class Bot {

    public static void main(String[] args) {
        // Checks if there were any parameters passed in.
        if(args.length == 0) {
            // We need at least one -- our token!
            System.out.println("Please provide a token!");
            return;
        }
        String token = args[0]; // 0 based indexing.
    }
}

}
