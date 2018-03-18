package edu.kit.informatik.competition;

import edu.kit.informatik.core.Core;
import edu.kit.informatik.ioc.Ioc;

import java.util.ArrayList;
import java.util.List;

public class MedalTableHandler {
    private List<MedalTable> medalTable = new ArrayList<>();

    /**
     * Creates a list for al competitions showing all won medals by each country
     * @return The medal list
     */
    public String listMedals() {
        List<Ioc> iocList = Core.getIocHandler().getIocList();
        List<Competition> competitions = Core.getCompetitionHandler().getCompetitions();

        for (Ioc ioc: iocList) {
            int gold = 0;
            int silver = 0;
            int bronze = 0;

            for (Competition competition: competitions) {

                if (competition.getCountry().equals(ioc.getCountry())) {
                    gold += competition.getGold();
                    silver += competition.getSilver();
                    bronze += competition.getBronze();
                }
            }

            medalTable.add(new MedalTable(ioc.getId(), ioc.getCode(), ioc.getCountry(), gold, silver, bronze));
        }

        medalTable.sort((MedalTable o1, MedalTable o2) -> {
            if (o1.getGold().equals(o2.getGold()))
                if (o1.getSilver().equals(o2.getSilver())) {
                    if (o1.getBronze().equals(o2.getBronze())) {
                        return o1.getIocId().compareTo(o2.getIocId());
                    } else {
                        return o2.getBronze().compareTo(o1.getBronze());
                    }
                } else {
                    return o2.getSilver().compareTo(o1.getSilver());
                }
            else {
                return o2.getGold().compareTo(o1.getGold());
            }
        });

        StringBuilder output = new StringBuilder();
        int index = 0; //The placing of a country

        for (MedalTable item: medalTable) {
            index++;
            output.append(String.format("(%d %s %s %s %d %d %d %d)\n", index, item.getIocId(), item.getIoc(),
                    item.getCountry(), item.getGold(), item.getSilver(), item.getBronze(), item.getMedals()));
        }

        if (output.length() >= 1)
            output.setLength(output.length() - 1); //Remove last linebreak

        if (output.length() == 0)
            output.append("Error, no competitions to create a medal table registered yet.");

        return output.toString();
    }


    /**
     * Reset the list
     */
    public void reset() {
        medalTable = new ArrayList<>();
    }
}
