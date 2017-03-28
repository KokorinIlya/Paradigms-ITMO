/**
 * Created by Илья Кокорин on 10.02.2017.
 */
public class SumLongHex {
    public static long convert(String toDecode){
        toDecode = toDecode.toLowerCase();
        long number;
        if (toDecode.length() >= 2 && toDecode.startsWith("0x")){
            number = Long.parseUnsignedLong(toDecode.substring(2), 16);
        } else {
            number = Long.parseLong(toDecode, 10);
        }
        return number;
    }
    public static void main(String[] args){
        long sum = 0;
        boolean nowInt;
        for (int i = 0; i < args.length; i++){
            int leftBorder = -1, rightBorder = -1;
            nowInt = false;
            for (int j = 0; j < args[i].length(); j++){
                if (!Character.isWhitespace(args[i].charAt(j)) && !nowInt){
                    leftBorder = j;
                    nowInt = true;
                }
                if (Character.isWhitespace(args[i].charAt(j)) && nowInt){
                    rightBorder = j;
                    nowInt = false;
                    String toDecode = args[i].substring(leftBorder, rightBorder);
                    long number = convert(toDecode);
                    sum += number;
                }
            }
            if (nowInt){
                String toDecode = args[i].substring(leftBorder);
                long number = convert(toDecode);
                sum += number;
            }
        }
        System.out.println(sum);
    }
}
