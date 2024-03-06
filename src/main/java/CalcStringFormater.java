public class CalcStringFormater {
    public static String rubles(double price){
        switch((int)Math.floor(price)){
            case 1:
                return "рубль";
            case 2, 3, 4:
                return "рубля";
            default:
                return "рублей";
        }
    }

}
