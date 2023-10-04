import java.util.ArrayList;
import java.util.List;

// Mediator Interface
interface AuctionMediator {
    void searchForItem(String description, String clientName);
    void buyItem(String itemId, String clientName);
    void notifyPrice(String itemId, double price);
}

// Concrete Mediator for eBay
class EbayAuctionMediator implements AuctionMediator {
    private List<Client> clients = new ArrayList<>();
    private double ebayItemPrice = 0.0;

    @Override
    public void searchForItem(String description, String clientName) {
        System.out.println(clientName + " is searching for an item on eBay: " + description);
    }

    @Override
    public void buyItem(String itemId, String clientName) {
        System.out.println(clientName + " is buying item " + itemId + " on eBay for $" + ebayItemPrice);
    }

    @Override
    public void notifyPrice(String itemId, double price) {
        ebayItemPrice = price;
    }

    public void addClient(Client client) {
        clients.add(client);
    }
}

// Concrete Mediator for Amazon
class AmazonAuctionMediator implements AuctionMediator {
    private List<Client> clients = new ArrayList<>();
    private double amazonItemPrice = 0.0;

    @Override
    public void searchForItem(String description, String clientName) {
        System.out.println(clientName + " is searching for an item on Amazon: " + description);
    }

    @Override
    public void buyItem(String itemId, String clientName) {
        System.out.println(clientName + " is buying item " + itemId + " on Amazon for $" + amazonItemPrice);
    }

    @Override
    public void notifyPrice(String itemId, double price) {
        amazonItemPrice = price;
    }

    public void addClient(Client client) {
        clients.add(client);
    }
}

// Client class
class Client {
    private String name;
    private AuctionMediator mediator;

    public Client(String name, AuctionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void searchAndBuy(String description, String itemId) {
        mediator.searchForItem(description, name);
        mediator.buyItem(itemId, name);
    }
}

public class Main {
    public static void main(String[] args) {
        EbayAuctionMediator ebayMediator = new EbayAuctionMediator();
        AmazonAuctionMediator amazonMediator = new AmazonAuctionMediator();

        Client client1 = new Client("Client 1", ebayMediator);
        Client client2 = new Client("Client 2", amazonMediator);

        ebayMediator.addClient(client1);
        amazonMediator.addClient(client2);

        // Simulate item prices being notified to the mediators
        ebayMediator.notifyPrice("1234", 50.0);
        amazonMediator.notifyPrice("5678", 45.0);

        client1.searchAndBuy("Smartphone", "1234");
        client2.searchAndBuy("Laptop", "5678");
    }
}
