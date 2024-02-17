package Model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Chat extends Comment{
    //@Id
    private long id;

    private ArrayList<Long> users;
}
