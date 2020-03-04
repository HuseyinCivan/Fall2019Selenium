package officeHours;

import java.util.ArrayList;
import java.util.Iterator;

public class SeleniumOH1 {
/*


 */

    public static void main(String[] args) {

        //
        ArrayList<String> keysToSearch=new ArrayList<>();
        keysToSearch.add("fruits");
        keysToSearch.add("veggies");
        keysToSearch.add("berries");

        Iterator<String > iterator= keysToSearch.iterator();
        //
        //
        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }






    }
}
