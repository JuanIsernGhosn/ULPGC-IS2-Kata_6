 package kata6;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class KATA6 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
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
        
        ArrayList <Person1> person = PersonLoader.read();
        HistogramBuilder<Person1> builder1 = new HistogramBuilder<>(person);
        
        Histogram<String> domains1 = builder1.build(new Attribute<Person1, String>() {
            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Float> pesos = builder1.build(new Attribute<Person1, Float>() {
            @Override
            public Float get(Person1 item) {
                return item.getPeso();
            }
        });
        
        Histogram<Character> genero = builder1.build(new Attribute<Person1, Character>() {
            @Override
            public Character get(Person1 item) {
                return item.getGenero().charAt(0);
            }
        });
        
        new HistogramDisplay(domains1, "DOMINIOS1").execute();
        new HistogramDisplay(pesos, "PESOS").execute();
        new HistogramDisplay(genero, "GENERO").execute();
       
        //System.out.println(mailArray.get(10));
        //Histogram<String> histogram = MailHistogramBuilder.build(mailArray);
        //new HistogramDisplay(histogram).execute();
    }
}
