package entity;

import javax.persistence.*;

//Student Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
//will mark a particular class as an entity bean, so it must have a no-argument constructor
@Table(name = "scores") //This is for the actual name of the database table name we are mapping to the class.
public class Hangman {

    //Database Mapping
    @Id //This will map the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This is used with auto increment for your primary key.
    @Column(name = "id") //This is mapping the primary key to the id column in your database.
    private int id;

    @Column(name = "name") //This will map the firstName field to the column named first_name in your student table.
    private String name;

    @Column(name = "word") //This will map the email field to the column named email in your student table.
    private String word;

    @Column(name = "score") //This will map the email field to the column named email in your student table.
    private int score;

    //Constructors
    public Hangman() {

    }

    public Hangman(String name, String word, int score) {
        this.name = name;
        this.word = word;
        this.score = score;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //To string method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name ='" + name + '\'' +
                ", word='" + word + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
