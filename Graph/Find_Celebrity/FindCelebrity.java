package com.problem_solving.Graph.Find_Celebrity;

public class FindCelebrity {

    private int numOfPeople;

    public int findCelebrity(int n) {
        numOfPeople = n;
        int celebCandiate = 0;

        for(int i=0; i<n; i++){
            if(knows(celebCandiate, i)){
                celebCandiate = i;
            }
        }

        if(isCelebrity(celebCandiate)){
            return celebCandiate;
        }

        return -1;

    }

    public boolean isCelebrity(int i){

        for(int j=0; j<numOfPeople; j++){
            if(i==j){
                continue;
            }
            if(knows(i,j) || !knows(j,i)){
                return false;
            }
        }

        return true;

    }

    // know func template
    public static boolean knows(int celebK, int i) {
        return true;
    }

}
