package fish.payara.bowling;

import java.util.Optional;

public record Frame (int roll1, Optional<Integer> roll2, Optional<Integer> roll3) {
    public int getTotal () {
        int total = this.roll1;
        if (this.roll2.isPresent()) {
            total += this.roll2.get();
            if (this.roll3.isPresent()) {
                total += this.roll3.get();
            }
        }
        return total;
    }
    
    public boolean isSpare () {
        if (this.roll1 == 0 || (this.roll2.isPresent() && this.roll2.get() == 0)) {
            return false;
        }
        
        return this.roll1 + this.roll2.get() == 10;
    }
    
    public boolean isStrike () {
        return this.roll1 == 10;
    }
}
