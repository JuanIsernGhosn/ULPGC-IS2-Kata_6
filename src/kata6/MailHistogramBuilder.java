package kata6;

import java.util.ArrayList;

public class MailHistogramBuilder {
    public static Histogram<String> build (ArrayList<String> mailList){
        Histogram<String> histo = new Histogram<>();
        for (String mail : mailList) {
            histo.increment(new Mail(mail).getDominio());
        }
        return histo;
    }
    
}