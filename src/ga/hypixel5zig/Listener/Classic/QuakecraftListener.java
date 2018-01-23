package ga.hypixel5zig.Listener.Classic;

import com.mojang.authlib.GameProfile;
import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.server.IPatternResult;
import eu.the5zig.util.minecraft.ChatColor;
import ga.hypixel5zig.Listener.HypixelListener;
import ga.hypixel5zig.games.Classic.Quakecraft;

public class QuakecraftListener
extends AbstractGameListener<Quakecraft>
{
	public Class<Quakecraft> getGameMode()
	{
		return Quakecraft.class;
	}

	public boolean matchLobby(String lobby)
	{
		return HypixelListener.Game != null && HypixelListener.Game.equals("Quakecraft");
	}
	private boolean start;
	public void onMatch(Quakecraft gameMode, String key, IPatternResult match)
	{
		if (key.equals("starting")) {
			gameMode.setTime(System.currentTimeMillis() + Integer.parseInt(match.get(0)) * 1000);
		}
		if (key.equals("canceled")) {
			gameMode.setTime(-1L);
		}
		if (key.equals("Quakecraft.start") && (gameMode.getState() != GameState.GAME))
		{
			this.start = true;
			gameMode.setState(GameState.GAME);
			gameMode.setTime(System.currentTimeMillis());
		}		
		if (key.startsWith("Quakecraft.team.")) {
			if(match.get(0).equals("RED")){
				gameMode.setTeam("\u00A7cRed");
			}else if(match.get(0).equals("BLUE")){
				gameMode.setTeam("\u00A79Blue");
			}else{
				gameMode.setTeam(match.get(0).substring(0, 1).toUpperCase() + match.get(0).substring(1).toLowerCase());
			}
		}
		if(this.start == true){
			if (key.startsWith("Quakecraft.kill.")) {
				if (The5zigAPI.getAPI().getGameProfile().getName().equals(match.get(0))) {
					gameMode.setKills(gameMode.getKills() + 1);
					gameMode.setKillstreak(gameMode.getKillstreak() + 1);
				} else if (The5zigAPI.getAPI().getGameProfile().getName().equals(match.get(1))) {
					gameMode.setDeaths(gameMode.getDeaths() + 1);
					gameMode.setKillstreak(0);
				}
			}
			if (key.startsWith("coin.")) {
				gameMode.setEarnedCoins(gameMode.getEarnedCoins() + Integer.parseInt(match.get(0)));
			}
			if (key.startsWith("win."))
			{
				gameMode.setState(GameState.FINISHED);
				if(match.get(0).equals("RED") || match.get(0).equals("BLUE")){
					gameMode.setWinner(match.get(0).substring(0, 1).toUpperCase() + match.get(0).substring(1).toLowerCase() + " Team");
				}else{
					gameMode.setWinner(match.get(0));
				}
				gameMode.setWinTime(System.currentTimeMillis());
			}
		}

	}
	public void onTitle(Quakecraft gameMode, String title, String subtitle)
	{
		if(title != null && subtitle != null && ChatColor.stripColor(title).equals("Team Mode") && ChatColor.stripColor(subtitle).startsWith("You're on team ")){
			String team = ChatColor.stripColor(subtitle).replace("You're on team ","");
			if(team.equals("RED!")){
				gameMode.setTeam("\u00A7cRed");
			}else if(team.equals("BLUE!")){
				gameMode.setTeam("\u00A79Blue");
			}else{
				gameMode.setTeam(subtitle.replace("You're on team ",""));
			}
		}
	}
	public void onServerConnect(Quakecraft gameMode)
	{
		gameMode.setWinTime(-1L);
		gameMode.setWinner(null);
		gameMode.setTime(-1L);
		gameMode.setState(GameState.LOBBY);
		gameMode.setTeam(null);
		gameMode.setKills(0);
		gameMode.setEarnedCoins(0);
		gameMode.setKillstreak(0);
		this.start = false;
		The5zigAPI.getLogger().info("[Hypixel5zig] Rejoin is not supported");
	}
	public void onTick(Quakecraft gameMode)
	{
		if ((gameMode.getState() == GameState.LOBBY) && 
			(gameMode.getTime() != -1L) && (gameMode.getTime() - System.currentTimeMillis() < 0L))
		{
			gameMode.setTime(-1L);
		}
	}
}
