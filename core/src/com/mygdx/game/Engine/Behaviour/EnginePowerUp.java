package com.mygdx.game.Engine.Behaviour;
import com.mygdx.game.Engine.Entity.Player;

public abstract class EnginePowerUp {
    // Private instance variables
    private float x, y; // Position
    private float duration; // Time in seconds the powerup will be active
    private boolean isActive; // Whether the powerup is currently active

    // Constructor
    public void EnginePowerUp(float x, float y, float duration) {
        this.x = x;
        this.y = y;
        this.duration = duration;
        isActive = false;
    }

    // Private method to activate the powerup
    private void activate() {
        isActive = true;
        // TODO: Implement powerup activation logic
    }

    // Private method to deactivate the powerup
    private void deactivate() {
        isActive = false;
        // TODO: Implement powerup deactivation logic
    }

    // Public method to update the powerup state
    public void update(float delta) {
        if (isActive) {
            duration -= delta;
            if (duration <= 0) {
                deactivate();
            }
        }
    }

    // Public method to check for collision with a player object

    public void applyEffect(Player player) {
        // TODO: Implement powerup effect logic
    }
}
