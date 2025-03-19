package fish.payara.codingdojo.async.resources.model;

import java.io.Serializable;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public record Data(long sourceId, double time, int position, int temperature, String label) implements Serializable {
}
