package ga.hypixel5zig.Listener.Classic;

import com.mojang.authlib.GameProfile;
import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.server.IPatternResult;
import eu.the5zig.util.minecraft.ChatColor;
import ga.hypixel5zig.Listener.HypixelListener;
import ga.hypixel5zig.games.Classic.Paintball;

public class PaintballListener
extends AbstractGameListener<Paintball>
{
	public Class<Paintball> getGameMode()
	{
		return Paintball.class;
	}

	public boolean matchLobby(String lobby)
	{
		return HypixelListener.Game != null && HypixelListener.Game.equals("Paintball");
	}

	public void onMatch(Paintball gameMode, String key, IPatternResult match)
	{
		if (key.equals("starting")) {
			gameMode.setTime(System.currentTimeMillis() + Integer.parseInt(match.get(0)) * 1000);
		}
		if (key.equals("canceled")) {
			gameMode.setTime(-1L);
		}
		if (key.equals("Paintball.start") && (gameMode.getState() != GameState.GAME))
		{
			gameMode.setState(GameState.GAME);
			gameMode.setTime(System.currentTimeMillis());
		}
		if (key.equals("Paintball.kill")) {
			gameMode.setKills(gameMode.getKills() + 1);
			gameMode.setKillstreak(gameMode.getKillstreak() + 1);
		}
		if (key.equals("Paintball.death")) {
			gameMode.setDeaths(gameMode.getDeaths() + 1);
			gameMode.setKillstreak(0);
		}
		if (key.equals("Paintball.nuke")) {
			if (The5zigAPI.getAPI().getGameProfile().getName().equals(match.get(0))) {
				gameMode.setDeaths(gameMode.getDeaths() + 1);
			} else if (The5zigAPI.getAPI().getGameProfile().getName().equals(match.get(1))) {
				gameMode.setKills(gameMode.getKills() + 1);
			}
		}
		if (key.startsWith("coin.")) {
			gameMode.setEarnedCoins(gameMode.getEarnedCoins() + Integer.parseInt(match.get(0)));
		}
		if (key.startsWith("win."))
		{
			gameMode.setState(GameState.FINISHED);
			gameMode.setWinner(match.get(0) + " Team");
		}
		if (key.startsWith("Paintball.team.")) {
			if(match.get(0).equals("RED")){
				gameMode.setTeam("\u00A7cRed");
			}else if(match.get(0).equals("BLUE")){
				gameMode.setTeam("\u00A79Blue");
			}else if(match.get(0).equals("GREEN")){
				gameMode.setTeam("\u00A7aGreen");
			}else if(match.get(0).equals("AQUA")){
				gameMode.setTeam("\u00A7bAqua");
			}else if(match.get(0).equals("PURPLE")){
				gameMode.setTeam("\u00A7dPurple");
			}else if(match.get(0).equals("ORANGE")){
				gameMode.setTeam("\u00A76Orange");
			}else if(match.get(0).equals("WHITE")){
				gameMode.setTeam("\u00A7fWhite");
			}else{
				gameMode.setTeam(match.get(0).substring(0, 1).toUpperCase() + match.get(0).substring(1).toLowerCase());
			}
		}
	}
	public void onServerConnect(Paintball gameMode)
	{
		gameMode.setWinner(null);
		gameMode.setTime(-1L);
		gameMode.setState(GameState.LOBBY);
		gameMode.setTeam(null);
		gameMode.setKills(0);
		gameMode.setEarnedCoins(0);
		gameMode.setKillstreak(0);
	}
	public void onTick(Paintball gameMode)
	{
		if ((gameMode.getState() == GameState.LOBBY) && 
			(gameMode.getTime() != -1L) && (gameMode.getTime() - System.currentTimeMillis() < 0L))
		{
			gameMode.setTime(-1L);
		}
	}
}
