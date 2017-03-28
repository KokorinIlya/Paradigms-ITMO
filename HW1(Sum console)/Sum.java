/**
 * Created by Илья Кокорин on 10.02.2017.
 */
public class Sum {
    public static void main(String[] args){
        int sum = 0;
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
                    int number = Integer.parseInt(args[i].substring(leftBorder, rightBorder));
                    sum += number;
                }
            }
            if (nowInt){
                int number = Integer.parseInt(args[i].substring(leftBorder));
                sum += number;
            }
        }
        System.out.println(sum);
    }
}
