import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Yakovenko on 16.12.2017.
 */
public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;


    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        boolean flag = false;
        if (man != person.man) {
            if (spouse != null) {
                spouse.divorce();
                this.divorce();
                flag = true;
            }
            if (person.spouse != null) {
                person.spouse.divorce();
                person.divorce();
                flag = true;
            }

            this.spouse = person;
            person.spouse = this;
        } else {
            flag = true;
        }
        return !flag;
    }


    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed     
     */
    public boolean divorce() {
        if (spouse != null) {
            spouse = null;
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Person Bob = new Person(true, "BOB");
        Person Alice = new Person(false, "ALICE");

        System.out.println(Bob.marry(Alice));

        Person Sam = new Person(true, "SAM");
        System.out.println(Bob.marry(Sam));

        System.out.println(Alice.divorce());

        Person Kanny = new Person(true, "Kanny");
        Kanny.marry(new Person(false, "Lola"));

        System.out.println(Alice.marry(Kanny));
    }
}