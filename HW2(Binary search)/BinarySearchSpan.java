/**
 * Created by Илья Кокорин on 19.02.2017.
 */
public class BinarySearchSpan {
    //r = rightBorder, l = leftBorder, n = a.length, m = middle
    public static int iterativeBinarySearchLeft(int[] a, int x) {
        //PRE: a[i] >= a[i + 1], 0 <= i < n - 1
        int leftBorder = -1;
        int rightBorder = a.length;
        while (rightBorder - leftBorder > 1) {
            //INV: r > l + 1 && r - l > r' - l' && l <= l' < r' <= r && |(r - l) - 2 * (r' - l')| <= 1 &&
            // && |(r - l) - 2 * (r' - l')| <= 1 && (l == -1 || (0 <= l < r && a[l] > x)) &&
            // && (r == n || (l < r < n && a[r] <= x)) && a[i]' = a[i], 0 <= i < n && x' = x
            int middle = (leftBorder + rightBorder) / 2;
            //m = (r + l) / 2 && |(r - m) - (m - l)| <= 1 && (l < m <= r || l <= m < r)
            if (a[middle] <= x) {
                rightBorder = middle;
                //r' = m, l' = l,
                // a[m] <= x -> a[r'] <= x,
                //(l == -1 || (0 <= l < r && a[l] > x)) -> (l' == -1 || (0 <= l' < r && a[l'] > x))
                // m < r -> r' < r
                // l' = l && r' < r -> r - l > r' - l' && l <= l' < r' <= r && x' = x
                // m = (r + l) / 2 -> |(r - l) - 2 * (r' - l')| <= 1
            } else {
                leftBorder = middle;
                //l' = m, r' = r
                // a[m] > x -> a[l'] > x,
                //(r == n || (l < r < n && a[r] <= x)) -> (r' == n || (l < r' < n && a[r'] <= x))
                // m > l -> l' > l
                // l' > l && r' = r -> r - l > r' - l' && l <= l' < r' <= r && x' = x
                // m = (r + l) / 2 -> |(r - l) - 2 * (r' - l')| <= 1
            }
        }
        return rightBorder;
        //POST: R = r, R < n && n > 0 && a[n - 1] <= x &&
        // && (R > 1 && a[R] <= x && a[R - 1] > x || R == 0 && a[R] <= x) ||
        // || (R == n && n > 0 && a[n - 1] > x) || (n == 0 && R == 0) &&
        // && a[i]' = a[i], 0 <= i < n
    }

    public static int recursiveBinarySearchRight(int[] a, int leftBorder, int rightBorder, int x) {
        //PRE: a[i] >= a[i + 1], 0 <= i < n - 1 && -1 <= l < r <= n &&
        // && (l == -1 || (0 <= l < r && a[l] >= x)) &&
        // && (r == n || (l < r < n && a[r] < x)) &&
        // a[i]' = a[i], 0 <= i < n && x' = x
        if (rightBorder - leftBorder == 1) {
            //l == r - 1 && (r == n || (l < r < n && a[r] < x)) && (l == -1 || (0 <= l < r && a[l] >= x)) ->
            // -> (0 <= R < n && a[R] >= x && a[R + 1] < x) || (R == n && a[n - 1] > x) || (R == 0 && a[R] <= x)
            return leftBorder;
        } else {
            int middle = (rightBorder + leftBorder) / 2;
            if (a[middle] >= x) {
                //l' = m, r' = r
                // a[m] >= x -> a[l'] >= x,
                //(r == n || (l < r < n && a[r] <= x)) -> (r' == n || (l < r' < n && a[r'] < x))
                // a[i]' = a[i], 0 <= i < n
                // m > l -> l' > l
                // r - l > r' - l' && l <= l' < r' <= r
                // m = (r + l) / 2 -> |(r - l) - 2 * (r' - l')| <= 1
                return recursiveBinarySearchRight(a, middle, rightBorder, x);
            } else {
                //a[m] < x, r' = m, l' = l ->
                // -> a[r'] < x,
                // (l == -1 || (0 <= l < r && a[l] > x)) -> (l' == -1 || (0 <= l' < r && a[l'] >= x))
                // a[i]' = a[i], 0 <= i < n && x' = x
                // m < r -> r' < r && l <= l' < r' <= r
                // m = (r + l) / 2 -> |(r - l) - 2 * (r' - l')| <= 1
                return recursiveBinarySearchRight(a, leftBorder, middle, x);
            }
        }
        //POST: R = l, 0 <= R < n && n > 0 && a[n - 1] <= x &&
        // && (R < n - 1 && a[R] <= x && a[R + 1] < x || R == n - 1 && a[R] >= x) ||
        // || (R == n && n > 0 && a[n - 1] > x) || (n == 0 && R == 0) &&
        // && a[i]' = a[i], 0 <= i < n
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int[] a = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            a[i - 1] = Integer.parseInt(args[i]);
        }
        int leftBorder = iterativeBinarySearchLeft(a,x);
        int rightBorder = recursiveBinarySearchRight(a, -1, a.length, x);
        System.out.println(leftBorder + " " + Integer.toString(rightBorder - leftBorder + 1));
    }
}
