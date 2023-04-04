package num3b;

import java.util.ArrayList;
import java.util.List;

interface Condiment {
  Double getCost();
}

class Milk implements Condiment {
  public Double getCost() {
    return 0.5;
  }
}

class Mocha implements Condiment {
  public Double getCost() {
    return 0.2;
  }
}

class Whip implements Condiment {
  public Double getCost() {
    return 0.1;
  }
}

abstract class Coffee {
  Double cost = 0.0;
  String description;
  List<Condiment> condiments = new ArrayList<Condiment>();

  public Double getCost() {
    return cost;
  }

  public void addCost(Double cost) {
    this.cost += cost;
  }

  public Coffee addCondiment(Condiment condiment) {
    condiments.add(condiment);
    addCost(condiment.getCost());
    return this;
  };

  public String getDescription() {
    return this.description;
  };
}

class Espresso extends Coffee {
  public Espresso() {
    this.description = "Espresso";
    this.cost = 2.01;
  }
}

public class BuilderDemo {

  public static void main(String[] args) {
    Condiment milk = new Milk();
    Condiment mocha = new Mocha();
    Coffee espressoCoffee = new Espresso().addCondiment(mocha).addCondiment(mocha).addCondiment(milk);
    System.out.println(espressoCoffee.getDescription() + " $" + espressoCoffee.getCost());
  }

}
