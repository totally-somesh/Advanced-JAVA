package DAO;

import POJOs.Player;

public interface PlayerDAOIF {
	
	public String addNewPlayer(Player newPlayer, int teamId);
}
