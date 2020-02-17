/**
 * @author wb
 * @date 2020/2/7 - 20:40
 *剑指offer---16. 数值的整数次方
 */
public class SwordMeansOffer_16_Power {

    public double Power(double base, int exponent) {
        if (exponent < 0) {
            exponent = -exponent;
            base = 1 / base;
        }
        double res = 1;
        for (int i = 0; i < exponent; i++) {
            res *= base;
        }
        return res;
    }
}
