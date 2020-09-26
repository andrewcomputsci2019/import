package SanviB;

/*
    Specs.java
    This file contains the Specs class definition.
*/

import java.util.Random;

class Specs {

    void GenerateIP(){
        String IPAddress;
        Random IpGeneration = new Random();
        int IPSection1 = IpGeneration.nextInt(254);
        int IPSection2 = IpGeneration.nextInt(254);

        IPAddress = "192.168" + IPSection1 + "." + IPSection2 ;
        System.out.println((IPAddress));
    }
    //-- Data for all possible specs
    private static String[][] GraphicsCards = {
            { "HD Graphics 4000", "Intel(R)" },
            { "BTX 2160 Super", "GTX" },
            { "Gigabyte GeForce GT", "GEForce" },
            { "11265-05-20G Pulse RX", "Sapphire" },
            { "GTX 1070 Ti GAMING", "GeForce" },
            { "AMD Radeon RX 5500XT", "Asus" },
    };

    //-- Non-static members
    private String GraphicsCardManufacturer;
    private String GraphicsCardName;
    private long CreationTime;
    private String ProfileName;
    private String BIOS;

    Specs(String Name) {
        ProfileName = Name;

        // Random selection of graphics card
        Random Rand = new Random();
        String[] GraphicsCardInfo = GraphicsCards[Rand.nextInt(GraphicsCards.length)];

        GraphicsCardName = GraphicsCardInfo[0];
        GraphicsCardManufacturer = GraphicsCardInfo[1];

        // Random generation of other variables
        BIOS = Rand.nextInt(10) + "." + Rand.nextInt(50) + "." + Rand.nextInt(10);

        // Grab system info
        CreationTime = System.currentTimeMillis();
    }

    double ComputeUptimeInSeconds() {
        return (System.currentTimeMillis() - CreationTime) / 1000.0;
    }
}
