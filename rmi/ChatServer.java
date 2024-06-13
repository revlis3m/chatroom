import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ChatRoom chatRoom = new ChatRoomImpl();
            Registry registry = LocateRegistry.createRegistry(2000);
            Naming.rebind("ChatRoom", chatRoom);
            System.out.println("Le serveur de chat est pret");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
