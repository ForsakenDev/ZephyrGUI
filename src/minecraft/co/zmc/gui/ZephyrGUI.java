package co.zmc.gui;

import java.util.logging.Level;
import java.util.logging.Logger;

import co.zmc.gui.net.PacketHandler;
import co.zmc.gui.proxy.Proxy;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid=Globals.MOD_ID, name="ZephyrGUI", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels={Globals.PACKET_CHANNEL}, packetHandler = PacketHandler.class)
public class ZephyrGUI {
	
	@Instance(value = Globals.MOD_ID)
	public static ZephyrGUI instance;
	
	public static Logger logger;
	
	@SidedProxy(clientSide="co.zmc.gui.proxy.ClientProxy", serverSide="co.zmc.gui.proxy.ServerProxy")
	public static Proxy proxy;
	
	@EventHandler
	public void onPreInit(FMLPreInitializationEvent event) {
		logger = Logger.getLogger(Globals.MOD_ID);
		logger.setParent(FMLLog.getLogger());
	}
    
	@EventHandler
	public void onInit(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}
    
	@EventHandler
	public void onPostInit(FMLPostInitializationEvent event) {		
		logger.log(Level.INFO, "Done loading");
	}
}
