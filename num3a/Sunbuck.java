package num3a;

interface Coffee {
  public void prepare();
}

class Americano1 implements Coffee {
  public void prepare() {
    System.out.println("Preparing Americano1");
  }
}

class Americano2 implements Coffee {
  public void prepare() {
    System.out.println("Preparing Americano2");
  }
}

class Latte1 implements Coffee {
  public void prepare() {
    System.out.println("Preparing Latte1");
  }
}

class Latte2 implements Coffee {
  public void prepare() {
    System.out.println("Preparing Latte2");
  }
}

abstract class SunbuckFactory {

  public Coffee getCoffe(String type) {
    Coffee coffe = createCoffee(type);
    coffe.prepare();
    return coffe;
  }

  public abstract Coffee createCoffee(String type);
}

class SunbuckFactory1 extends SunbuckFactory {
  public Coffee createCoffee(String type) {
    if (type.equals("americano")) {
      return new Americano1();
    } else if (type.equals("latte")) {
      return new Latte1();
    } else {
      return null;
    }
  }
}

class SunbuckFactory2 extends SunbuckFactory {
  public Coffee createCoffee(String type) {
    if (type.equals("americano")) {
      return new Americano1();
    } else if (type.equals("latte")) {
      return new Latte1();
    } else {
      return null;
    }
  }
}

public class Sunbuck {
  public static void main(String[] args) {
    SunbuckFactory factory1 = new SunbuckFactory1();
    Coffee coffee1 = factory1.getCoffe("americano");
    System.out.println(coffee1);

    SunbuckFactory factory2 = new SunbuckFactory2();
    Coffee coffee2 = factory2.getCoffe("latte");
    System.out.println(coffee2);

  }
}
