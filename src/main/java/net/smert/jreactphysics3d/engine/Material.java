package net.smert.jreactphysics3d.engine;

import net.smert.jreactphysics3d.configuration.Defaults;

/**
 * This class contains the material properties of a rigid body that will be use for the dynamics simulation like the
 * friction coefficient or the bounciness of the rigid body.
 *
 * @author Jason Sorensen <sorensenj@smert.net>
 */
public class Material {

    // Bounciness during collisions (between 0 and 1) where 1 is for a very bouncy body
    private float bounciness;

    // Friction coefficient (positive value)
    private float frictionCoefficient;

    // Constructor
    public Material() {
        bounciness = Defaults.DEFAULT_BOUNCINESS;
        frictionCoefficient = Defaults.DEFAULT_FRICTION_COEFFICIENT;
    }

    // Copy-constructor
    public Material(Material material) {
        set(material);
    }

    // Return the bounciness
    public float getBounciness() {
        return bounciness;
    }

    // Set the bounciness.
    // The bounciness should be a value between 0 and 1. The value 1 is used for a
    // very bouncy body and zero is used for a body that is not bouncy at all.
    public void setBounciness(float bounciness) {
        assert (bounciness >= 0.0f && bounciness <= 1.0f);
        this.bounciness = bounciness;
    }

    // Return the friction coefficient
    public float getFrictionCoefficient() {
        return frictionCoefficient;
    }

    // Set the friction coefficient.
    // The friction coefficient has to be a positive value. The value zero is used for no
    // friction at all.
    public void setFrictionCoefficient(float frictionCoefficient) {
        assert (frictionCoefficient >= 0.0f);
        this.frictionCoefficient = frictionCoefficient;
    }

    public final void set(Material material) {
        bounciness = material.bounciness;
        frictionCoefficient = material.frictionCoefficient;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Float.floatToIntBits(this.bounciness);
        hash = 71 * hash + Float.floatToIntBits(this.frictionCoefficient);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Material other = (Material) obj;
        if (Float.floatToIntBits(this.bounciness) != Float.floatToIntBits(other.bounciness)) {
            return false;
        }
        return Float.floatToIntBits(this.frictionCoefficient) == Float.floatToIntBits(other.frictionCoefficient);
    }

}
