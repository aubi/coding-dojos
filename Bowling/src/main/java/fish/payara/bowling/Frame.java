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
        if (this.roll1 == 0 || this.roll2.orElse(0) == 0) {
            return false;
        }
        
        return this.roll1 + this.roll2.orElse(0) == 10;
    }
    
    public boolean isStrike () {
        return this.roll1 == 10;
    }
    
    public Frame addRoll (int roll) {
        if (this.roll2.isEmpty()) {
            return new Frame(this.roll1, Optional.of(roll), this.roll3);
        }
        return new Frame(this.roll1, this.roll2, Optional.of(roll));
    }
    
    public int getTotalPins () {
        return this.roll1 + this.roll2.orElse(0) + this.roll3.orElse(0);
    }
}
