package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FurnitureOrder implements FurnitureOrderInterface {
	HashMap<Furniture, Integer> furniture = null;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
    	furniture = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
    	furniture.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
         return furniture;
    }

    public float getTotalOrderCost() {
    	float sum = 0;
        for(Map.Entry<Furniture,Integer> entry : furniture.entrySet()) {
			sum = entry.getKey().cost()*entry.getValue();
		}
        return sum;
    }

    public int getTypeCount(Furniture type) {
        return furniture.get(type);
    }

    public float getTypeCost(Furniture type) {
        return furniture.get(type)*Furniture.valueOf(type.label()).cost();
    }

    public int getTotalOrderQuantity() {
        return furniture.values().stream().filter(Objects::nonNull).mapToInt(i -> i).sum();
    }
}