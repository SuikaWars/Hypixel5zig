package ga.hypixel5zig.Listener;

import com.mojang.authlib.GameProfile;
import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.server.IPatternResult;
import ga.hypixel5zig.games.TNT.TNTGames;

public class TNTGamesListener
extends AbstractGameListener<TNTGames>
{
	public Class<TNTGames> getGameMode()
	{
		return TNTGames.class;
	}

	public boolean matchLobby(String lobby)
	{		
		if(HypixelListener.Game != null && HypixelListener.Game.equals("Wizards")){
			HypixelListener.Game = "The TNT Games";
			this.rejoin = true;
			The5zigAPI.getLogger().info("[Hypixel5zig] Rejoin is not supported");
		}
		return lobby.startsWith("tntlobby") || (HypixelListener.Game != null && HypixelListener.Game.equals("The TNT Games"));
	}
	private boolean rejoin;
	public void onMatch(TNTGames gameMode, String key, IPatternResult match)
	{
		if(!(this.rejoin == true)){
			if (key.equals("starting")) {
				gameMode.setTime(System.currentTimeMillis() + Integer.parseInt(match.get(0)) * 1000);
			}
			if (key.equals("canceled")) {
				gameMode.setTime(-1L);
			}
			if (key.equals("TNT.start"))
			{
				gameMode.setState(GameState.GAME);
				gameMode.setTime(System.currentTimeMillis());
			}
			if (key.startsWith("win."))
			{
				if(gameMode.getTeam() != null){
					gameMode.setWinner(match.get(0) + "Team");
				}else{
					gameMode.setWinner(match.get(0));
				}
				gameMode.setState(GameState.FINISHED);	
			}
			if (key.equals("TNT.1st") && gameMode.getWinner() == null)
			{
				gameMode.setWinner(match.get(0));
				gameMode.setState(GameState.FINISHED);	
			}
			if (key.startsWith("coin.")) {
				gameMode.setEarnedCoins(gameMode.getEarnedCoins() + Integer.parseInt(match.get(0)));
			}
			if (key.startsWith("PVPRun.kill.")) {
				if (The5zigAPI.getAPI().getGameProfile().getName().equals(match.get(1))) {
					gameMode.setKills(gameMode.getKills() + 1);
				}
			}
			if (key.startsWith("Wizards.kill.")) {
				gameMode.setKills(gameMode.getKills() + 1);
				gameMode.setKillstreak(gameMode.getKillstreak() + 1);
			}
			if (key.equals("Wizards.assist")) {
				gameMode.setAssists(gameMode.getAssists() + 1);
			}
			if (key.startsWith("Wizards.death.")) {
				gameMode.setDeaths(gameMode.getDeaths() + 1);
				gameMode.setKillstreak(0);
			}
			if (key.startsWith("Wizards.kit.")) {
				gameMode.setKit(match.get(0));
			}
			if (key.startsWith("Wizards.team.")) {
				if(match.get(0).equals("Red")){
					gameMode.setTeam("\u00A7cRed");
				}else if(match.get(0).equals("Blue")){
					gameMode.setTeam("\u00A79Blue");
				}else{
					gameMode.setTeam(match.get(0));
				}
			}
		}
	}
	public void onServerConnect(TNTGames gameMode)
	{
		gameMode.setWinner(null);
		gameMode.setTime(-1L);
		gameMode.setState(GameState.LOBBY);
		gameMode.setEarnedCoins(0);
	}
	public void onTick(TNTGames gameMode)
	{
		if ((gameMode.getState() == GameState.LOBBY) && 
			(gameMode.getTime() != -1L) && (gameMode.getTime() - System.currentTimeMillis() < 0L))
		{
			gameMode.setTime(-1L);
		}
	}
}
