package Classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotes {


    private ArrayList<Quote> quotes;

    public Quotes() {
        quotes = new ArrayList<>();
    }


    public Quotes(ArrayList<Quote> quotes) {
        this.quotes = quotes;
    }

    public ArrayList<Quote> getList() {
        return quotes;
    }

    public ArrayList<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(ArrayList<Quote> quotes) {
        this.quotes = quotes;
    }

    public void add(Quote quote) {
        this.quotes.add(quote);
    }


    public boolean downloadQuotes() throws JsonProcessingException {

        JSONGetter jsonGetter = new JSONGetter();
        JSONGetter.url = "https://the-dune-api.herokuapp.com/quotes/5";
        jsonGetter.run();
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.quotes = mapper.reader().forType(new TypeReference<ArrayList<Quote>>() {
            }).readValue(jsonGetter.jsonIn);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {

        String result = "Quotes (" + (new Date()).toLocaleString() + ") " + System.lineSeparator();
        for (Quote quote : quotes) {
            result += quote + System.lineSeparator();
        }
        return result;
    }

}
