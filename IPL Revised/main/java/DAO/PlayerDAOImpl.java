package DAO;

import static HUtils.HUtilities.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import POJOs.Player;
import POJOs.Team;

public class PlayerDAOImpl implements PlayerDAOIF {

	@Override
	public String addNewPlayer(Player newPlayer, int teamId) {
		
		String msg = " | Oops Boos ! New Player Insertion Failed Miserably ! ";
		Session SS = getFactory().getCurrentSession();
		Transaction TX = SS.beginTransaction();
		
		try {

			Team selectedTeam = SS.get(Team.class, teamId);
			
			if(selectedTeam != null) {
			selectedTeam.addNewPlayer(newPlayer);
			}
			
			TX.commit();

		} catch (RuntimeException e) {

			if (TX != null)
				TX.rollback();

			throw e;
		}

		return msg;
	}

	
	
}
