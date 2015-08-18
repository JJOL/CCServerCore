package io.ccserver.ccsc.gameapi;

import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * Created by JJOL on 14/08/2015.
 */
public class VoteManager {

    private boolean votingSession = false;
    private final Set<UUID> voted = new HashSet<>();
    private final Map<String, Integer>  votes = new HashMap<>();

    public void setMapPool(String... maps) {
        for(String map : maps) {
            votes.put(map, 0);
        }
    }

    public int getVotesOf(String map) {
        return votes.get(map);
    }

    public TreeMap<String, Integer> getOrdered() {
        OrderedComparator comparator = new OrderedComparator(votes);
        TreeMap<String, Integer> ordered = new TreeMap<>(comparator);
        ordered.putAll(votes);
        return ordered;
    }

    public Set<String> getTopMaps() {
        return getOrdered().keySet();
    }

    public Collection<Integer> getTopVotes() {
        return getOrdered().values();
    }


    public boolean vote(Player player, String mapName) {
        UUID pId = player.getUniqueId();

        if(!votingSession) {
            return false;
            //TODO LOG WITH BUILT-IN MessageStreamer Cant Vote
        }

        if(voted.contains(pId)) {
            return false;
            //TODO LOG WITH BUILT-IN MessageStreamer Already Voted
        }

        voted.add(pId);
        votes.put(mapName, votes.get(mapName));

        return true;
    }


    public void setVotingSession(boolean votingSession) {
        this.votingSession = votingSession;
    }

    @AllArgsConstructor
    class OrderedComparator implements Comparator<String> {

        private Map<String, Integer> input;

        @Override
        public int compare(String a, String b) {
            return (input.get(a) >= input.get(b)) ? -1 : 1;
        }
    }

}
