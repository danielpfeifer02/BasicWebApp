package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        String[] queryList = query.split(" ");
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "dan";
        } else if (query.contains("plus")) {
            int index = 0;
            for(int j=0; j<queryList.length; j++) {
                if (queryList[j].equals("plus")) {
                    index = j;
                    break;
                }
            }
            int first = Integer.parseInt(queryList[index-1]);
            int second = Integer.parseInt(queryList[index+1]);
            return Integer.valueOf(first+second).toString();
        } else if (query.contains("")) {
            return "";
        } else if (query.contains("")) {
            return "";
        } else if (query.contains("")) {
            return "";
        } else if (query.contains("")) {
            return "";
        } else if (query.contains("")) {
            return "";
        } else { // TODO extend the programm here
            return "";
        }
    }
}
