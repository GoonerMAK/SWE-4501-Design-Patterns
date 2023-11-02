public class ServerOperations {
    public static void main(String[] args)
    {
        Operations operations = new ProxyServer();

        System.out.println(operations.getRequest());
        System.out.println(operations.postRequest());
        operations.alterAccessGranted();
        System.out.println(operations.putRequest());
        System.out.println(operations.deleteRequest());

    }
}

interface Operations
{
    String getRequest();
    String postRequest();
    String putRequest();
    String deleteRequest();
    boolean alterAccessGranted();
}


class Respond implements Operations
{
    @Override
    public String getRequest() {
        return "Response to GET Request";
    }

    @Override
    public String postRequest() {
        return "Response to POST Request";
    }

    @Override
    public String putRequest() {
        return "Response to PUT Request";
    }

    @Override
    public String deleteRequest() {
        return "Response to DELETE Request";
    }

    @Override
    public boolean alterAccessGranted() {
        return true;
    }
}


class ProxyServer implements Operations
{
    Respond respond;
    private boolean accessGranted;

    public ProxyServer() {
        this.respond = new Respond();
        this.accessGranted = true;
    }

    private boolean checkAccess() {
        return accessGranted;
    }

    @Override
    public String getRequest() {
        if (checkAccess()) {
            return respond.getRequest() + ": GET Request Responded";
        } else {
            return "Access Denied";
        }
    }

    @Override
    public String postRequest() {
        if (checkAccess()) {
            return respond.getRequest() + ": POST Request Responded";
        } else {
            return "Access Denied";
        }
    }

    @Override
    public String putRequest() {
        if (checkAccess()) {
            return respond.getRequest() + ": PUT Request Responded";
        } else {
            return "Access Denied";
        }
    }

    @Override
    public String deleteRequest() {
        if (checkAccess()) {
            return respond.getRequest() + ": DELETE Request Responded";
        } else {
            return "Access Denied";
        }
    }

    @Override
    public boolean alterAccessGranted() {
        accessGranted = !accessGranted;
        return  accessGranted;
    }
}