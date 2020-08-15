package com.dylange.organisedcrime.models;

import java.util.ArrayList;
import java.util.Arrays;

public class OrganisedCrimeLocations {

    public static final LocationGroup[] locationGroups = {
        new Arceeus(),
        new Hosidius(),
        new Lovakengj(),
        new Piscarilius(),
        new Shayzien(),
        new Other(),
    };

    public static final OrganisedCrimeLocation[] allLocations;

    static {
        ArrayList<OrganisedCrimeLocation> locationList = new ArrayList<>();
        for (LocationGroup group : locationGroups) {
            locationList.addAll(Arrays.asList(group.getLocations()));
        }
        allLocations = (OrganisedCrimeLocation[])locationList.toArray();
    }

    interface LocationGroup {
        String getIdentifier();

        OrganisedCrimeLocation[] getLocations();
    }

    public static class Arceeus implements LocationGroup {
        @Override
        public String getIdentifier() {
            return "arceeus";
        }

        @Override
        public OrganisedCrimeLocation[] getLocations() {
            return new OrganisedCrimeLocation[]{
                    new OrganisedCrimeLocation(
                            "We've received reports of gang meeting in Arceuus, in a house south-east of the bank.",
                            "The house exactly south-east of the bank, east of the walkway when walking into Arceuus. Ground floor.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Arceuus, west of the bank.",
                            "Just outside the bank to the west.",
                            false
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Arceuus, in the church crypt.",
                            "Inside of the church on the ground floor marked by green on the map.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Arceuus, upstairs in a house south of the church entrance.",
                            "Middle floor of house with teleport tablet lectern. ",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Arceuus, upstairs in the bar.",
                            "The bar in the south-eastern portion of Arceuus, on the middle floor.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in a house at the eastern edge of Arceuus, south of the church.",
                            "A house south-east of the church.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Arceuus, upstairs in the general store.",
                            "The general store is in the south-east part of Arceuus.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Arceuus, upstairs in the bank.",
                            "The bank is in the south-west part of Arceuus.",
                            false
                    ),
            };
        }
    }

    public static class Hosidius implements LocationGroup {
        @Override
        public String getIdentifier() {
            return "hosidius";
        }

        @Override
        public OrganisedCrimeLocation[] getLocations() {
            return new OrganisedCrimeLocation[]{
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Hosidius market square.",
                            "Hosidius market, east of bank",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Hosidius, in the vegetable field south of the food servery.",
                            "The field just south of the mess.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of gang meeting in Hosidius, inside the pub.",
                            "The Golden Field pub in the market square.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Hosidius, outside Farmer Gricoller's house.",
                            "Directly south of the entrance of the Tithe Farm.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Hosidius, by the mine cart entrance in the south-west.",
                            "Directly north of the Hosidius mine cart track found northeast of the Woodcutting Guild.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Hosidius, by the minecart in the north.",
                            "On the border of Port Piscarilius and Hosidius, next to Raeli. Slightly west of the minecart.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Hosidius, in the cabbage patch.",
                            "Just north of the POH portal.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Hosidius, in the cow field.",
                            "Large cow field, south of the flax field.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Hosidius, inside Forthos Ruin.",
                            "South of the northwestern Hosidius Bank. Above ground.",
                            true
                    ),
            };
        }
    }

    public static class Lovakengj implements LocationGroup {
        @Override
        public String getIdentifier() {
            return "lovakengj";
        }

        @Override
        public OrganisedCrimeLocation[] getLocations() {
            return new OrganisedCrimeLocation[]{
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Lovakengj, in the pub.",
                            "The Deeper Lode pub located south-east",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in a house at the south-eastern corner of Lovakengj.",
                            "Moggy's house just east of the general store",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Lovakengj, upstairs in a house south of the church.",
                            "First house south of the church with connected upper floor of the three adjacent houses",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Lovakengj, in a house near the blast mining quarry.",
                            "Downstairs in the house just south-east of the Blast Mine, adjacent to a house with an anvil inside.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Lovakengj, upstairs from the furnace.",
                            "The house just south of the furnace at the middle of Lovagengj.",
                            true
                    ),
            };
        }
    }

    public static class Piscarilius implements LocationGroup {
        @Override
        public String getIdentifier() {
            return "piscarilius";
        }

        @Override
        public OrganisedCrimeLocation[] getLocations() {
            return new OrganisedCrimeLocation[]{
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Port Piscarilius, in the bar on the pier.",
                            "Far east in Piscarilius, in the largest building.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Port Piscarilius, just behind the bar on the pier.",
                            "Far east in Piscarilius, south of the largest building.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Port Piscarilius, upstairs in a bunkhouse south-west of the bank.",
                            "Top floor in mess hall.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Port Piscarilius, upstairs in a cabin west of the fish merchant.",
                            "Upstairs in the house west of the general store.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting at the west side of Port Piscarilius, in one of their cabins on the pier.",
                            "In the south-western building over the water in the cove.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Port Piscarilius, upstairs in a house due south of the bank.",
                            "The middle floor of the house directly south of the bank, upstairs, water and stove icon.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting at the north-west corner of Port Piscarilius, in a shack by the mountains.",
                            "The western most shack in Piscarilius, up a small wooden ramp.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting at the south-west corner of Port Piscarilius, in one of their cabins on the pier.",
                            "The south west corner, on the docks, not the main land.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Port Piscarilius, south of the platforms on the rocky shore.",
                            "The Piscarilius mine just outside the city.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in Port Piscarilius, in the general store.",
                            "Far south of the bank.",
                            true
                    ),
            };
        }
    }

    public static class Shayzien implements LocationGroup {
        @Override
        public String getIdentifier() {
            return "shayzien";
        }

        @Override
        public OrganisedCrimeLocation[] getLocations() {
            return new OrganisedCrimeLocation[]{
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang infiltrating our own city! They're meeting in a storage tent north-east of the bank.",
                            "Directly north of the north-east corner of the bank.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang infiltrating our own city! They're meeting in a storage tent south-west of the bank.",
                            "Directly south of the south-west corner of the bank.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang infiltrating our own city! They're meeting in the south-west corner of the graveyard.",
                            "South-west of Shayzien.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang infiltrating our own city! They're meeting upstairs in a large tent at the north.",
                            "The tent with the armour and weapon shop.",
                            true
                    ),
            };
        }
    }

    public static class Other implements LocationGroup {
        @Override
        public String getIdentifier() {
            return "other";
        }

        @Override
        public OrganisedCrimeLocation[] getLocations() {
            return new OrganisedCrimeLocation[]{
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting at the statue of King Rada outside Kourend Castle.",
                            "East of the statue in Kourend Castle. ",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in the barbarian camp.",
                            "The barbarian camp south the Woodcutting Guild.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in the castle, possibly in one of the lesser used north-eastern rooms.",
                            "The Kourend Castle in one of the north-eastern rooms.",
                            true
                    ),
                    new OrganisedCrimeLocation(
                            "We've received reports of a gang meeting in a house in Lands End.",
                            "The house north of the bank in Land's End.",
                            false
                    ),
            };
        }
    }
}
