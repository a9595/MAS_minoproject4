package main.Torturers;

import main.TortureDepartment;

/**
 * Created by tieorange on 28/04/16.
 */

// Multi-inheritance
public class TorturerExploder extends TorturerWithSpikes implements IExploder {
    private int explosionPower;

    public TorturerExploder(String name, TortureDepartment tortureDepartment, Integer explosionPower) {
        super(name, tortureDepartment);
        setExplosionPower(explosionPower);
    }

    @Override
    public int getExplosionPower() {
        return explosionPower;
    }

    @Override
    public void setExplosionPower(Integer explosionPower) {
        if (explosionPower != null) {
            this.explosionPower = explosionPower;
        } else throw new IllegalArgumentException("explosionPower is NULL");
    }

    @Override
    public void makeExplosion() {
        System.out.println("Explosion... baaabaahhhh-booooom");
    }
}
