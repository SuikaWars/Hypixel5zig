package ga.hypixel5zig.Listener.TNT;

import com.mojang.authlib.GameProfile;
import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.server.IPatternResult;
import ga.hypixel5zig.Listener.HypixelListener;
import ga.hypixel5zig.games.TNT.TNTWizards;

public class TNTWizardsListener
extends AbstractGameListener<TNTWizards>
{
	public Class<TNTWizards> getGameMode()
	{
		return TNTWizards.class;
	}

	public boolean matchLobby(String lobby)
	{
		if(HypixelListener.Game != null && HypixelListener.Game.equals("Wizards")){
			HypixelListener.Game = "TNT Wizards";
			this.rejoin = true;
			The5zigAPI.getLogger().info("[Hypixel5zig] Rejoin is not supported");
		}
		return HypixelListener.Game != null && HypixelListener.Game.equals("TNT Wizards");
	}
	private boolean rejoin;
	public void onMatch(TNTWizards gameMode, String key, IPatternResult match)
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
			if (key.startsWith("coin.")) {
				gameMode.setEarnedCoins(gameMode.getEarnedCoins() + Integer.parseInt(match.get(0)));
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
		if (key.startsWith("win."))
		{
			gameMode.setWinTime(System.currentTimeMillis());
			gameMode.setWinner(match.get(0) + " Team");
			if(!(this.rejoin == true)){
				gameMode.setState(GameState.FINISHED);
			}
		}
	}
	public void onServerConnect(TNTWizards gameMode)
	{
		gameMode.setWinTime(-1L);
		gameMode.setWinner(null);
		gameMode.setTime(-1L);
		gameMode.setState(GameState.LOBBY);
		gameMode.setKills(0);
		gameMode.setDeaths(0);
		gameMode.setAssists(0);
		gameMode.setKit(null);
		gameMode.setTeam(null);
		gameMode.setEarnedCoins(0);
		gameMode.setKillstreak(0);
		this.rejoin = false;
	}
	public void onTick(TNTWizards gameMode)
	{
		if ((gameMode.getState() == GameState.LOBBY) && 
			(gameMode.getTime() != -1L) && (gameMode.getTime() - System.currentTimeMillis() < 0L))
		{
			gameMode.setTime(-1L);
		}
	}
}