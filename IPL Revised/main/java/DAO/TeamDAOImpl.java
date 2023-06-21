package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static HUtils.HUtilities.getFactory;

import POJOs.Team;

public class TeamDAOImpl implements TeamDAOIF {

	@Override
	public String addNewTeam(Team newTeam) {

		String msg = " | Oops Boos ! Team Insertion Failed Miserably ! ";

		Session SS = getFactory().getCurrentSession();

		Transaction TX = SS.beginTransaction();

		try {

			SS.persist(newTeam);

			TX.commit();

			msg = " | Congrats Boss ! New Team Added Succesfully ! ";
		} catch (RuntimeException e) {

			if (TX != null)
				TX.rollback();

			throw e;
		}

		return msg;
	}// end of addNewTeam Method

	@Override
	public List<Team> getAllTeams() {

		List<Team> teamList = null;
		
		Session SS = getFactory().getCurrentSession();
		String JPQL = "select new POJOs.Team(id,abbrevation) from Team";
		Transaction TX = SS.beginTransaction();

		try {

			teamList = SS.createQuery(JPQL, Team.class).getResultList();
			
			TX.commit();

		} catch (RuntimeException e) {

			if (TX != null)
				TX.rollback();

			throw e;
		}

		return teamList;
	}// end of getAllTeams Method

	@Override
	public Team getTeamDetails(int teamId) {
		
		Team selectedTeam = null;
		Session SS = getFactory().getCurrentSession();
		
		Transaction TX = SS.beginTransaction();

		try {

			selectedTeam = SS.get(Team.class, teamId);
			
			TX.commit();

		} catch (RuntimeException e) {

			if (TX != null)
				TX.rollback();

			throw e;
		}
		
		return selectedTeam;
	}
	
	
}//end of Team DAO Impl class 
