package main;

import main.HellPets.HellPet;
import main.HellPets.HellPetColor;
import main.HellPets.HellPetType;
import main.PunishmentTools.ExplosivePunishmentTool;
import main.Sinners.Sinner;
import main.Sinners.SinnerType;
import main.Torturers.Torturer;
import main.Torturers.TorturerWithKnife;
import main.Torturers.TorturerWithSpikes;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Collection<Torturer> torturers = new ArrayList<>();
//        torturers.add(new TorturerWithKnife())

        // OVERLAPPING
        EnumSet<SinnerType> sinnerTypes = EnumSet.of(SinnerType.LIAR, SinnerType.MURDERER);
        Sinner sinner = new Sinner("bob", "marley", new Date(), sinnerTypes, 3, 3);
        sinner.Kill();
        sinner.tryToLie();


        TortureDepartment tortureDepartment = new TortureDepartment("boiling room");

        // DYNAMIC
        TorturerWithSpikes torturerWithSpikes = new TorturerWithSpikes("Mifelos", tortureDepartment);
        HellPet hellPet = new HellPet("bonia", HellPetColor.GREEN, torturerWithSpikes, HellPetType.FLYING, null, 100);
        hellPet.becomeJumping(1000);

    }

}
