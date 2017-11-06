package nl.oostenenk;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

import static javafx.beans.binding.Bindings.select;


/**
 * Created by hendr on 19-7-2017.
 */
public class Ticketbot {

    private String eventHttp;

    //Testing only
    private String testEventHttp = "https://www.ticketswap.nl/event/return-of-headhunterz-2017-official-q-dance-event/regular/f976a154-0d76-458e-880e-77b704974e6b/336883";

    public Ticketbot(String eventHttp) {
        this.eventHttp = eventHttp;


    }

    /**
     * Generates jsoup document to execute cssQueries
     * @param href
     * @return jsoup document
     */
    private Document getDocument(String href){
        Document document = null;
        Elements ticketsCounter = null;
        try {
            document = Jsoup.connect(href).get();


        } catch (IOException e) {
            e.printStackTrace();
        }

        //for finding the html tags etc.
        //System.out.println(document);

        return document;
    }

    public void run() throws Exception {
        Document doc = getDocument(eventHttp);

        if(doc == null){
            System.out.println("error: Document build failed");
            throw new Exception("Jsoup document build failed");
        }
        String ticketCounter = doc.select(".counter-available").select(".counter-value").text();
        System.out.println("Tickets Available: " + ticketCounter);

        //end if no tickets have been found
        if(Integer.parseInt(ticketCounter) == 0 ) return;

        //check listings
        Elements listings = doc.select(".listings");


    }

}
