/*
  * ISP - “Clients should not be forced to depend upon interfaces that they do not use.” - Robert C. Martin
  * First Example shows an ideal case of violation of ISP
  * The GrillStation,MiddleStation implement Cook but unwantedly implement
  * unnecessary methods. Therefor the cook interface is a fat/polluted interface//vkt
*/

public class Interface_Seggregation_Principle{
  class Kitchen{
    GrillStation grillStation;
    MiddleStation middleStation;
    FryerStatiion fryerStatiion;

    public Meal cookOrder(Order order) throws Exception{
      if(order.isAppetizerItem){
        return middleStation.cookAppetizer();
      }
      else if(order.isGrillItem){
        return grillStation.grillMeal();
      }
      else if(order.isFryerItem){
        return fryerStation.fryMeal();
      }
      else{
        throw new Exception("No a valid Choice");
      }
    }
  }

  iterface Cook{
    Meal grillMeal();
    Meal cookAppetizer();
    Meal fryMeal();
  }

  class GrillStation implements Cook{
    @Override
    public Meal grillMeal(){ return new Meal();}

    @Override
    public Meal cookAppetizer() {return null;}

    @Override
    public Meal fryMeal() {return null};

  }

  class MiddleStation implements Cook{
    @Override
    public Meal grillMeal(){ return null;}

    @Override
    public Meal cookAppetizer() {return Meal();}

    @Override
    public Meal fryMeal() {return null};
  }
}


/*
  * Better Design, its better to have more seggregated interfaces than a single fat one
*/

public class Interface_Seggregation_Principle{
  class Kitchen{
    GrillStation grillStation;
    MiddleStation middleStation;
    FryerStatiion fryerStatiion;

    public Meal cookOrder(Order order) throws Exception{
      if(order.isAppetizerItem){
        return middleStation.cookAppetizer();
      }
      else if(order.isGrillItem){
        return grillStation.grillMeal();
      }
      else if(order.isFryerItem){
        return fryerStation.fryMeal();
      }
      else{
        throw new Exception("No a valid Choice");
      }
    }
  }


    interface GrillCook{
        Meal grillMeal();
    }
    interface MiddleCook{
      Meal cookAppetizer();
    }
    interface FryCook{
      Meal fryMeal();
    }

  class GrillStation implements GrillCook{
    @Override
    public Meal grillMeal(){ return new Meal();}

  }

  class MiddleStation implements MiddleCook{
    @Override
    public Meal cookAppetizer() {return Meal();}
  }

  class FryStation implements FryCook{
    @Override
    public Meal fryMeal() {return new Meal()};
  }

  class Order{
    boolean isGrillItem;
    boolean isFryerItem;
    boolean isAppetizerItem;
  }

  class Meal{

  }
}
