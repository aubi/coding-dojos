package fish.payara.codingdojo.asyncperformance;


import java.io.Serializable;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public record Data(long sourceId, double time, int position, int temperature, String label) implements Serializable {
}
