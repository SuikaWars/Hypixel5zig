package ga.hypixel5zig.Listener.TNT;

import com.mojang.authlib.GameProfile;
import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.server.IPatternResult;
import ga.hypixel5zig.Listener.HypixelListener;
import ga.hypixel5zig.games.TNT.BowSpleef;

public class BowSpleefListener
extends AbstractGameListener<BowSpleef>
{
	public Class<BowSpleef> getGameMode()
	{
		return BowSpleef.class;
	}

	public boolean matchLobby(String lobby)
	{
		return HypixelListener.Game != null && HypixelListener.Game.equals("Bow Spleef");
	}
	public void onMatch(BowSpleef gameMode, String key, IPatternResult match)
	{
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
		if (key.equals("TNT.1st"))
		{
			gameMode.setWinner(match.get(0));
			gameMode.setWinTime(System.currentTimeMillis());
			gameMode.setState(GameState.FINISHED);	
		}
		if (key.startsWith("coin.")) {
			gameMode.setEarnedCoins(gameMode.getEarnedCoins() + Integer.parseInt(match.get(0)));
		}
	}
	public void onServerConnect(BowSpleef gameMode)
	{
		gameMode.setWinTime(-1L);
		gameMode.setWinner(null);
		gameMode.setTime(-1L);
		gameMode.setState(GameState.LOBBY);
		gameMode.setEarnedCoins(0);
	}
	public void onTick(BowSpleef gameMode)
	{
		if ((gameMode.getState() == GameState.LOBBY) && 
			(gameMode.getTime() != -1L) && (gameMode.getTime() - System.currentTimeMillis() < 0L))
		{
			gameMode.setTime(-1L);
		}
	}
}
