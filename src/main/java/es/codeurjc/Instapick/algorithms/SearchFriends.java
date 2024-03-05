package es.codeurjc.Instapick.algorithms;

import es.codeurjc.Instapick.model.User;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SearchFriends {


    public List<Long> doOperation(List<User> friendsOfUser){ // (Map -> List) Sort friends list
        Map<Long, Integer> bestFriends = get4BestFrieds(friendsOfUser);
        List<Long> keys = bestFriends.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return keys;
    }

    private Map<Long, Integer> get4BestFrieds(List<User> friedns){ // Get the 4 best friends from each of the user's friends
        Map<Long, Integer> reapetedUsers = new HashMap<>();
        for(User userFriends : friedns){
            for (User user : userFriends.getFriends()){ // Check for duplicate users
                if(reapetedUsers.containsKey(user.getId())){
                    reapetedUsers.replace(user.getId(), reapetedUsers.get(user.getId()) + 1); // More chances of appearing in suggestions
                }else {
                    reapetedUsers.put(user.getId(), 1);
                }
            }
        }
        Map<Long, Integer> mapaOrdenado = reapetedUsers.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Entry::getKey,
                        Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        return mapaOrdenado;
    }

}
