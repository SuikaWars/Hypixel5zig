package plugin.hypixel5zig.Listener;

import com.mojang.authlib.GameProfile;
import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.server.IPatternResult;
import plugin.hypixel5zig.games.SpeedUHC;

public class SpeedUHCListener
extends AbstractGameListener<SpeedUHC>
{
	public Class<SpeedUHC> getGameMode()
	{
		return SpeedUHC.class;
	}

	public boolean matchLobby(String lobby)
	{
		return lobby.startsWith("speeduhclobby") || (HypixelListener.Game != null && HypixelListener.Game.equals("Speed UHC"));
	}

	public void onMatch(SpeedUHC gameMode, String key, IPatternResult match)
	{
		if (key.equals("starting")) {
			gameMode.setTime(System.currentTimeMillis() + Integer.parseInt(match.get(0)) * 1000);
		}
		if (key.equals("SpeedUHC.start"))
		{
			gameMode.setState(GameState.GAME);
			gameMode.setTime(System.currentTimeMillis());
		}
		if (key.startsWith("kill.")) {
			if (The5zigAPI.getAPI().getGameProfile().getName().equals(match.get(1))) {
				gameMode.setKills(gameMode.getKills() + 1);
			} else if (The5zigAPI.getAPI().getGameProfile().getName().equals(match.get(0))) {
      	//died 
			}
		}
		if (key.startsWith("win."))
		{
			gameMode.setWinner(match.get(0));
			gameMode.setWinTime(System.currentTimeMillis());
			gameMode.setState(GameState.FINISHED);
		}
		if (key.startsWith("kit."))
		{
			gameMode.setKit(match.get(0));
		}
		if (key.equals("cageopen"))
		{
			gameMode.setCageOpenTime(System.currentTimeMillis() + Integer.parseInt(match.get(0)) * 1000);
			gameMode.setState(GameState.STARTING);
		}
	}
	public void onServerConnect(SpeedUHC gameMode)
	{
		gameMode.setKit(null);
		gameMode.setWinTime(-1L);
		gameMode.setWinner(null);
		gameMode.setTime(-1L);
		gameMode.setState(GameState.LOBBY);
		gameMode.setKills(0);
	}
	public void onTick(SpeedUHC gameMode)
	{
		if ((gameMode.getState() == GameState.LOBBY) && 
			(gameMode.getTime() != -1L) && (gameMode.getTime() - System.currentTimeMillis() < 0L))
		{
			gameMode.setTime(-1L);
		}
		if ((gameMode.getCageOpenTime() != -1L) && (gameMode.getCageOpenTime() - System.currentTimeMillis() < 0L))
		{
			gameMode.setCageOpenTime(-1L);
		}
	}
}
