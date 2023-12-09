// Handler Interface
interface CallHandler {
    void handleCall(String callType);
}

// Base Handler
abstract class BaseCallHandler implements CallHandler {
    private BaseCallHandler nextHandler;

    public BaseCallHandler(BaseCallHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleCall(String callType) {
        if (nextHandler != null) {
            nextHandler.handleCall(callType);
        } else {
            System.out.println("No handler available for this call.");
        }
    }
}

// Concrete Handlers
class LevelOneHandler extends BaseCallHandler {
    public LevelOneHandler(BaseCallHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleCall(String callType) {
        if ("simple_issue".equals(callType)) {
            System.out.println("Level 1 Handler: Handling a simple issue.");
        } else {
            super.handleCall(callType);
        }
    }
}

class LevelTwoHandler extends BaseCallHandler {
    public LevelTwoHandler(BaseCallHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleCall(String callType) {
        if ("complex_issue".equals(callType)) {
            System.out.println("Level 2 Handler: Handling a complex issue.");
        } else {
            super.handleCall(callType);
        }
    }
}

class LevelThreeHandler extends BaseCallHandler {
    public LevelThreeHandler(BaseCallHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleCall(String callType) {
        if ("escalated_issue".equals(callType)) {
            System.out.println("Level 3 Handler: Handling an escalated issue.");
        } else {
            super.handleCall(callType);
        }
    }
}

// Client code
public class CallCenterExample {
    public static void main(String[] args) {
        // Creating the chain of handlers
        BaseCallHandler levelThreeHandler = new LevelThreeHandler(null);
        BaseCallHandler levelTwoHandler = new LevelTwoHandler(levelThreeHandler);
        BaseCallHandler levelOneHandler = new LevelOneHandler(levelTwoHandler);

        // Simulating different types of calls
        BaseCallHandler mainCallCenter = levelOneHandler;
        mainCallCenter.handleCall("simple_issue");
        mainCallCenter.handleCall("complex_issue");
        mainCallCenter.handleCall("escalated_issue");
        mainCallCenter.handleCall("unknown_issue");
    }
}
