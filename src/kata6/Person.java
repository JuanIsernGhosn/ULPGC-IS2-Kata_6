
package kata6;

public class Person {
    private final int id;
    private final String mail;

    public Person(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }
    
    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }
}
