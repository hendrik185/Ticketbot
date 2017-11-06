package nl.oostenenk;

public class Main {

    public static void main(String[] args) {

	    // write your code here
        String http1 = "https://www.ticketswap.nl/event/return-of-headhunterz-2017-official-q-dance-event/regular/f976a154-0d76-458e-880e-77b704974e6b/336883";
        String http2 = "https://www.ticketswap.nl/event/vestival-2017/regular/71e9e617-ec95-44f8-adf4-2dec5959b210/116614";


        Ticketbot ticketbot = new Ticketbot(http2);
        try {
            ticketbot.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
