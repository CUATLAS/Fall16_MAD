package com.example.aileen.coffeeconstraint;

public class CoffeeShop {
    private String coffeeShop;
    private String coffeeShopURL;

    private void setCoffeeInfo(Integer coffeeCrowd){
        switch (coffeeCrowd){
            case 0: //popular
                coffeeShop="Starbucks";
                coffeeShopURL="https://www.starbucks.com";
                break;
            case 1: //cycling
                coffeeShop="Amante";
                coffeeShopURL="http://www.amantecoffee.com";
                break;
            case 2: //hipster
                coffeeShop="Ozo";
                coffeeShopURL="https://ozocoffee.com";
                break;
            case 3: //tea
                coffeeShop="Pekoe";
                coffeeShopURL="http://www.pekoesiphouse.com";
                break;
            case 4: //hippie
                coffeeShop="Trident";
                coffeeShopURL="http://www.tridentcafe.com";
                break;
            default:
                coffeeShop="none";
                coffeeShopURL="https://www.google.com/search?q=boulder+coffee+shops&ie=utf-8&oe=utf-8";
        }
    }

    public void setCoffeeShop(Integer coffeeCrowd){

        setCoffeeInfo(coffeeCrowd);
    }

    public void setCoffeeShopURL(Integer coffeeCrowd){

        setCoffeeInfo(coffeeCrowd);
    }

    public String getCoffeeShop(){

        return coffeeShop;
    }

    public String getCoffeeShopURL(){

        return coffeeShopURL;
    }
}
