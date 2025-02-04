public class digitAfterOnesPlace {
    
    public static int count (int input){
        input = Math.abs(input);
        int digitCount = 3;
        while (input >= 10){
            input = input / 10;
            digitCount++;
        }
        return digitCount;
    }
    
}
