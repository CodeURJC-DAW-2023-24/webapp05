package Model;

import java.util.Date;

@Entity
public class Comment {

    @Id
    private long id;
    private long writerId;
    private String text;
    private Date date;
}
