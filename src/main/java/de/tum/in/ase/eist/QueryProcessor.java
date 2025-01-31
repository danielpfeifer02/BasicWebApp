package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;

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
            if (index == 0 || index == queryList.length-1) {return "failure";}
            int first = Integer.parseInt(queryList[index-1]);
            int second = Integer.parseInt(queryList[index+1]);
            return Integer.valueOf(first+second).toString();
        } else if (query.contains("largest")) {
            int index = 0;
            for(int j=0; j<queryList.length; j++) {
                if (queryList[j].equals("largest:")) {
                    index = j;
                    break;
                }
            }
            int[] vals = new int[queryList.length-index];
            for (int i=0; i<vals.length; i++){
                Integer.parseInt(queryList[index+i].replace(",", ""));
            }
            return Integer.valueOf(Arrays.stream(vals).max().orElse(0)).toString();
        } else if (query.contains("square") && query.contains("cube")) {
            int index = 0;
            for(int j=0; j<queryList.length; j++) {
                if (queryList[j].equals("cube:")) {
                    index = j+1;
                    break;
                }
            }
            int[] vals = new int[queryList.length-index];
            for (int i=0; i<vals.length; i++){
                Integer.parseInt(queryList[index+i].replace(",", ""));
            }
            return Integer.valueOf(Arrays.stream(vals).filter(x -> isCube(x) && isSquare(x)).findFirst().orElse(0)).toString();
        } else if (query.contains("multiplied by")) {
            int index = 0;
            for(int j=0; j<queryList.length; j++) {
                if (queryList[j].equals("multiplied")) {
                    index = j;
                    break;
                }
            }
            if (index == 0 || index == queryList.length-2) {return "failure";}
            int first = Integer.parseInt(queryList[index-1]);
            int second = Integer.parseInt(queryList[index+2]);
            return Integer.valueOf(first*second).toString();
        } else { // TODO extend the programm here
            return "";
        }
    }

    public boolean isSquare(int i){
        for(int j=0; j<Math.sqrt(i)+1; j++){
            if(j*j==i) return true;
        }
        return false;
    }

    public boolean isCube(int i){
        for(int j=0; j<Math.sqrt(i); j++){
            if(j*j*j==i) return true;
        }
        return false;
    }
}
