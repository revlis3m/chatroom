import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class ChatRoomImpl extends UnicastRemoteObject implements ChatRoom {
    private Map<String, ChatUser> users;

    public ChatRoomImpl() throws RemoteException {
        users = new HashMap<>();
    }

    @Override
    public synchronized void subscribe(ChatUser user, String pseudo) throws RemoteException {
        users.put(pseudo, user);
        postMessage("System", pseudo + " a rejoint le chat.");
    }

    @Override
    public synchronized void unsubscribe(String pseudo) throws RemoteException {
        users.remove(pseudo);
        postMessage("System", pseudo + " a quitter le chat");
    }

    @Override
    public synchronized void postMessage(String pseudo, String message) throws RemoteException {
        for (ChatUser user : users.values()) {
            user.displayMessage(pseudo + ": " + message);
        }
    }
}
