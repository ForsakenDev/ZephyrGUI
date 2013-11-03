package co.zmc.gui.net;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import co.zmc.gui.Globals;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		if (packet.channel.equals(Globals.PACKET_CHANNEL)) {
			if (packet.data != null) {
				InputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				
				try {
					String command = reader.readLine();
					String object = reader.readLine();
					ArrayList<String> args = new ArrayList<String>();
					
					String line;
					while ((line = reader.readLine()) != null) {
						args.add(line);
					}
					
					NetCommandHandler.handleCommand(command, object, args);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
