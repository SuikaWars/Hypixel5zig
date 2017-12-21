package ga.hypixel5zig.Listener.Arcade;

import com.mojang.authlib.GameProfile;
import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.server.IPatternResult;
import eu.the5zig.util.minecraft.ChatColor;
import ga.hypixel5zig.Listener.HypixelListener;
import ga.hypixel5zig.games.Arcade.MiniWalls;

public class MiniWallsListener
extends AbstractGameListener<MiniWalls>
{
	public Class<MiniWalls> getGameMode()
	{
		return MiniWalls.class;
	}

	public boolean matchLobby(String lobby)
	{
		return HypixelListener.Game != null && HypixelListener.Game.equals("Mini Walls");
	}
	public void onMatch(MiniWalls gameMode, String key, IPatternResult match)
	{
		if (key.equals("starting")) {
			gameMode.setTime(System.currentTimeMillis() + Integer.parseInt(match.get(0)) * 1000);
		}

		if (key.equals("canceled")) {
			gameMode.setTime(-1L);
		}
		if (key.startsWith("win."))
		{
			gameMode.setWinner(match.get(0) + " Team");
			gameMode.setWinTime(System.currentTimeMillis());
			gameMode.setState(GameState.FINISHED);	
		}
		if (key.startsWith("MiniWalls.kill.")) {
			gameMode.setKills(gameMode.getKills() + 1);
		}
		if (key.startsWith("MiniWalls.death.")) {
			gameMode.setDeaths(gameMode.getDeaths() + 1);
		}
		if (key.startsWith("MiniWalls.team.")) {
			if(match.get(0).equals("Red")){
				gameMode.setTeam("\u00A7cRed");
			}else if(match.get(0).equals("Blue")){
				gameMode.setTeam("\u00A7bBlue");
			}else if(match.get(0).equals("Green")){
				gameMode.setTeam("\u00A7aGreen");
			}else if(match.get(0).equals("Yellow")){
				gameMode.setTeam("\u00A7eYellow");
			}else{
				gameMode.setTeam(match.get(0));
			}
		}
		if (key.equals("coin")) {
			gameMode.setEarnedCoins(gameMode.getEarnedCoins() + Integer.parseInt(match.get(0)));
		}
	}
	public void onTitle(MiniWalls gameMode)
	{
		gameMode.setWinTime(-1L);
		gameMode.setWinner(null);
		gameMode.setTime(-1L);
		gameMode.setState(GameState.LOBBY);
		gameMode.setKills(0);
		gameMode.setDeaths(0);
		gameMode.setTeam(null);
		gameMode.setEarnedCoins(0);
	}
	public void onTitle(MiniWalls gameMode, String title, String subtitle)
	{
		if(title != null && ChatColor.stripColor(title).startsWith("YOU ARE ")){
			The5zigAPI.getLogger().info("1");
			String team = ChatColor.stripColor(title).replace("YOU ARE ","");
			if(team.equals("RED")){
				gameMode.setTeam("\u00A7cRed");
			}else if(team.equals("BLUE")){
				gameMode.setTeam("\u00A7bRed");
			}else if(team.equals("GREEN")){
				gameMode.setTeam("\u00A7aGreen");
			}else if(team.equals("YELLOW")){
				gameMode.setTeam("\u00A7eYellow");
			}else{
				gameMode.setTeam(title.replace("YOU ARE ",""));
			}
		}
		if(subtitle != null && ChatColor.stripColor(subtitle).equals("The Walls have fallen!")){
			gameMode.setState(GameState.GAME);
			gameMode.setTime(System.currentTimeMillis());
		}
	}
	public void onTick(MiniWalls gameMode)
	{
		if ((gameMode.getState() == GameState.LOBBY) && 
			(gameMode.getTime() != -1L) && (gameMode.getTime() - System.currentTimeMillis() < 0L))
		{
			gameMode.setTime(-1L);
		}
	}
}
