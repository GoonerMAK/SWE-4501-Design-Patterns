import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Age_of_Villagers {

    public static void main(String[] args)
    {
        // Creating components
        HouseBuilder houseBuilder = new BuildHouse();
        House brickHouse  = houseBuilder.setType("Brick").build();

        WaterSourceBuilder waterSourceBuilder = new BuildWaterSource();
        WaterSource river  = waterSourceBuilder.setType("River").setCapacity("Wealthy Source").build();

        TreeBuilder treeBuilder = new BuildTree();
        Tree mangoTree  = treeBuilder.setType("Mango").build();

        // Creating the village
        Village village = new Village();
        village.add(brickHouse);
        village.add(river);
        village.add(mangoTree);

        System.out.println(village.getDescription());

    }
}


interface HouseBuilder {
    HouseBuilder setType(String type);
    HouseBuilder setColor(String color);
    House build();
}

class House implements VillageComponent
{
    private String type;
    private String color;

    public House(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder("House: ");

        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(this);
                if (value != null) {
                    description.append(value);
                    description.append(" ");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Access to a field is denied.", e);
            }
        }

        return description.toString();
    }
}


class BuildHouse implements HouseBuilder {
    private String type="";
    private String color="";

    @Override
    public HouseBuilder setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public HouseBuilder setColor(String color) {
        this.color = "(" + color + ")";
        return this;
    }

    @Override
    public House build() {
        return new House(type, color);
    }
}

class MudHouse extends House {
    public MudHouse(String color) {
        super("Mud House", color);
    }
}

class BrickHouse extends House {
    public BrickHouse(String color) {
        super("Brick House", color);
    }
}


interface WaterSourceBuilder {
    WaterSourceBuilder setType(String type);
    WaterSourceBuilder setCapacity(String capacity);
    WaterSource build();
}

class WaterSource implements VillageComponent {
    private String type;
    private String capacity;

    public WaterSource(String type, String capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public String getCapacity() {
        return capacity;
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder("Water Source: ");

        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(this);
                if (value != null) {
                    description.append(value);
                    description.append(" ");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Access to a field is denied.", e);
            }
        }

        return description.toString();
    }
}



class BuildWaterSource implements WaterSourceBuilder {
    private String type;
    private String capacity;

    @Override
    public WaterSourceBuilder setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public WaterSourceBuilder setCapacity(String capacity) {
        this.capacity = "(" + capacity + ")";
        return this;
    }

    @Override
    public WaterSource build() {
        return new WaterSource(type, capacity);
    }
}

class Well extends WaterSource {
    public Well(String capacity) {
        super("Well", capacity);
    }
}

class River extends WaterSource {
    public River(String capacity) {
        super("River", capacity);
    }
}


interface TreeBuilder {
    TreeBuilder setType(String type);
    TreeBuilder setHeight(String height);
    Tree build();
}



class Tree implements VillageComponent {
    private String type;
    private String height;

    public Tree(String type, String height) {
        this.type = type;
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public String getHeight() {
        return height;
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder("Tree: ");

        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(this);
                if (value != null) {
                    description.append(value);
                    description.append(" ");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Access to a field is denied.", e);
            }
        }

        return description.toString();
    }
}

class BuildTree implements TreeBuilder {
    private String type;
    private String height;

    @Override
    public TreeBuilder setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public TreeBuilder setHeight(String height) {
        this.height = "(" + height + ")";
        return this;
    }

    @Override
    public Tree build() {
        return new Tree(type, height);
    }
}

class PineTree extends Tree {
    public PineTree(String height) {
        super("Pine Tree", height);
    }
}

class MangoTree extends Tree {
    public MangoTree(String height) {
        super("Mango Tree", height);
    }
}



interface VillageComponent {
    String getDescription();
}


class Village implements VillageComponent {
    private List<VillageComponent> components = new ArrayList<>();

    public void add(VillageComponent component) {
        components.add(component);
    }

    public void remove(VillageComponent component) {
        components.remove(component);
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder("Village consists of:\n");
        Iterator<VillageComponent> iterator = components.iterator();
        while (iterator.hasNext()) {
            VillageComponent component = iterator.next();
            description.append("- ").append(component.getDescription()).append("\n");
        }
        return description.toString();
    }
}