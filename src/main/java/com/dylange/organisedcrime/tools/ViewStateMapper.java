package com.dylange.organisedcrime.tools;

import com.dylange.organisedcrime.models.GangExpectedTime;
import com.dylange.organisedcrime.models.GangInfo;
import com.dylange.organisedcrime.models.OrganisedCrimeLocation;
import com.dylange.organisedcrime.ui.LocationViewState;

import java.util.*;

public class ViewStateMapper {
    public static List<LocationViewState> gangInfoMapToLocationListItems(Map<Integer, GangInfo> gangInfoMap) {

        // A mapping of unique locations to a list of collected gang info
        HashMap<OrganisedCrimeLocation, List<GangInfo>> locationToInfoMap = new HashMap<>();

        // Go through the provided input of gang info per world checked, and add it to the above mapping.
        gangInfoMap.forEach((world, gangInfo) -> {
            List<GangInfo> existingInfo = locationToInfoMap.get(gangInfo.getLocation());
            if (existingInfo == null) {
                locationToInfoMap.put(gangInfo.getLocation(), Collections.singletonList(gangInfo));
            } else {
                List<GangInfo> updatedList = new ArrayList<>(existingInfo);
                updatedList.add(gangInfo);
                locationToInfoMap.put(gangInfo.getLocation(), updatedList);
            }
        });

        ArrayList<LocationViewState> viewStates = new ArrayList<>();
        locationToInfoMap.forEach((organisedCrimeLocation, gangInfoForLocation) -> {
            HashMap<Integer, GangExpectedTime> worldToExpectedTime = new HashMap<>();
            gangInfoForLocation.forEach(gangInfo -> worldToExpectedTime.put(gangInfo.getWorld(), gangInfo.getExpectedTime()));

            viewStates.add(
                    new LocationViewState(
                            organisedCrimeLocation.getDescription(),
                            organisedCrimeLocation.getImage(),
                            worldToExpectedTime
                    )
            );
        });

        return viewStates;
    }
}
