package plugin.hypixel5zig;

import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.event.LoadEvent;
import eu.the5zig.mod.event.EventHandler;
import eu.the5zig.mod.plugin.Plugin;
import java.util.HashMap;
import plugin.hypixel5zig.modules.*;

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import org.json.JSONObject;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.ResponseHandler;
import org.apache.http.HttpResponse;

@Plugin(name = "Hypixel5zig Beta", version = Main.version)
public class Main{
	public static final String version = "1.1.1";
	@EventHandler(priority = EventHandler.Priority.LOW)
	public void onLoad(LoadEvent event) {
		The5zigAPI.getAPI().registerServerInstance(this, HypixelInstance.class);
		The5zigAPI.getAPI().registerModuleItem(this, "HypixelServer", ServerItem.class, "Hypixel5zig");
		The5zigAPI.getAPI().registerModuleItem(this, "HypixelGame", GameItem.class, "Hypixel5zig");
		The5zigAPI.getAPI().registerModuleItem(this, "HypixelMap", MapItem.class, "Hypixel5zig");
		The5zigAPI.getAPI().registerModuleItem(this, "HypixelKit", KitItem.class, "Hypixel5zig");
		The5zigAPI.getAPI().registerModuleItem(this, "HypixelCageOpen", CageOpenItem.class, "Hypixel5zig");
		The5zigAPI.getAPI().registerModuleItem(this, "HypixelShotHP", ShotHP.class, "Hypixel5zig");

		HttpGet getlatest = new HttpGet("https://api.github.com/repos/SuikaWars/Hypixel5zig-Beta/releases/latest");
		getlatest.setHeader("Accept", "application/json");
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpResponse result = client.execute(getlatest);
			JSONObject json = new JSONObject(EntityUtils.toString(result.getEntity()));
			String[] ver = json.getString("tag_name").replace("v","").split("\\.");
			String[] cver = version.split("\\.");
			int ver_major1 = Integer.parseInt(ver[0]);
			int ver_major2 = Integer.parseInt(ver[1]);
			int ver_minor = Integer.parseInt(ver[2]);
			int cver_major1 = Integer.parseInt(cver[0]);
			int cver_major2 = Integer.parseInt(cver[1]);
			int cver_minor = Integer.parseInt(cver[2]);
			if (version.equals(json.getString("tag_name").replace("v",""))) {
				The5zigAPI.getLogger().info("Hypixel5zig is up to date!");
			}else if((ver_major1 > cver_major1)
				|| ((ver_major1 == cver_major1) && (ver_major2  > cver_major2))
				|| ((ver_major1 == cver_major1) && (ver_major2 == cver_major2) && (ver_minor  > cver_minor)))
			{
				The5zigAPI.getAPI().createOverlay().displayMessageAndSplit("Hypixel5zig Beta\n" + The5zigAPI.getAPI().translate("hypixel5zig.update"));
				The5zigAPI.getLogger().info("Hypixel5zig Beta: " + The5zigAPI.getAPI().translate("hypixel5zig.update"));
			}else{
				The5zigAPI.getAPI().createOverlay().displayMessageAndSplit("Hypixel5zig Beta\n" + The5zigAPI.getAPI().translate("hypixel5zig.higherversion"));
				The5zigAPI.getLogger().info("Hypixel5zig Beta: " + The5zigAPI.getAPI().translate("hypixel5zig.higherversion"));
			}
		} catch (IOException r) {
			The5zigAPI.getLogger().warn("Cannot check for updates", r);
		}
	}
}