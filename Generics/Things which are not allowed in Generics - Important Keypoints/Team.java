import java.util.LinkedList;
import java.util.List;

public class Team<L, M> {
    L leader;

    List<M> members = new LinkedList<>();

    M[] membersArray;

    private static String str;


}

/* Wrong way of using Generic Formal Types & Wildcards

public class Team<L, M, ? extends Object> { // cannot use wildcard in generic class formal parameter
    L leader= new L(); // cannot instantiate object

    List<M> members = new LinkedList<>();

    M[] membersArray = new M[10]; // cannot create Array of Formal Types

    private static L value; // cannot create static field of formal type

    private static String str;


}

 */
