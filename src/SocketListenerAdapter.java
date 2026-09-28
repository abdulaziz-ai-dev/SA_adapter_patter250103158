import java.nio.charset.StandardCharsets;

public class SocketListenerAdapter implements ILegacySocketListener {
    private ISimplePacketHandler handler;

    public SocketListenerAdapter(ISimplePacketHandler handler) {
        this.handler = handler;
    }

    public void onDataReceived(byte[] data) {
        if (data != null && handler != null) {
            String textMessage = new String(data, StandardCharsets.UTF_8);
            handler.handlePacket(textMessage);
        }
    }

    public void onConnect() {}

    public void onDisconnect() {}

    public void onError(int errorCode) {}

    public void onPing() {}
}