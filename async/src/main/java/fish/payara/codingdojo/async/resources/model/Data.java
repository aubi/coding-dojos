package fish.payara.codingdojo.async.resources.model;

/**
 *
 * @author Petr Aubrecht <aubrecht@asoftware.cz>
 */
public record Data(long sourceId, long time, int position, int temperature, String label) {
}
