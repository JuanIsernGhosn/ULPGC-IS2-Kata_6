package kata6;

import java.io.IOException;
import java.util.ArrayList;

public class KATA6 {

    public static void main(String[] args) throws IOException {
        String name = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\KATA6\\DATA\\emails.txt";
        ArrayList <Person> mailArray = MailListReader.read(name);
        System.out.println(mailArray.size());
        
        HistogramBuilder<Person> builder = new HistogramBuilder<>(mailArray);
        Histogram<String> domains = builder.build(new Attribute<Person, String>() {
            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {
            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });
        
        new HistogramDisplay(domains, "DOMINIOS").execute();
        new HistogramDisplay(letters, "CARACTER").execute();
        //System.out.println(mailArray.get(10));
        //Histogram<String> histogram = MailHistogramBuilder.build(mailArray);
        //new HistogramDisplay(histogram).execute();
    }
}
