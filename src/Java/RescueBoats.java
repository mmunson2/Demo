import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/********************************************************************************
 * You are given an array people where people[i] is the weight of the ith person,
 * and an infinite number of boats where each boat can carry a maximum weight of limit.
 * 
 * Each boat carries at most two people at the same time, provided the sum of
 * the weight of those people is at most limit.
 * 
 * Return the minimum number of boats to carry every given person.
 * 
 * Notes:
 * - My goal should be to pair two people that meet the limit exactly. If I can't find that, then check for
 * two people who meet limit - 1, and so on.
 * 
 * - Sorting the people array will probably help.
 * 
 * - 
 * 
 * 
 * 
 ********************************************************************************/

class RescueBoats {

    public static int boatCount(int[] peopleRaw, int limit) {

        ArrayList<Integer> people = new ArrayList<Integer>();

        for(int i = 0; i < peopleRaw.length; i++) {
            people.add(peopleRaw[i]);
        }

        Collections.sort(people, Collections.reverseOrder());

        int boatCount = 0;
        int j = people.size() - 1;
        for(int i = 0; i < people.size(); i++) {
            // Case 1: We saved everyone as i overlaps j, stop looping!
            if(i > j) {
                break;
            }
            // Case 2: We're down to one person, give them a boat and stop looping!
            else if(i == j) {
                boatCount++;
                break;
            }
            // Case 3: The current heaviest person can be paired with the lightest. Give them a boat
            // and move the j pointer back!
            else if(people.get(i) + people.get(j) <= limit) {
                boatCount++;
                j--;
            }
            // Case 4: The current heaviest person can't fit with the lightest person. Give them a boat
            // but don't move the j counter.
            else {
                boatCount++;
            }
        }
        

        return boatCount;
    }

    public static void main(String[] args) {
        int[] people = {3, 5, 3, 4};
        int limit = 5;

        int result = boatCount(people, limit);

        System.out.println("Finished with boat count of: " + result);
    }
}