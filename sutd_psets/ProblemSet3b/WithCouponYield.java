
/* ATTENTION ------------------------
please put in your own package statement to get it to work in your android studio project 
Easy way is to just copy-and-paste the code below to the android-generated file
do not submit the code with the package statement to vocareum 
ATTENTION --------
*/

public class WithCouponYield implements YieldCalculation {
    @Override
    public double yieldToMaturity(Bond bond) {
        double sellingPrice = bond.getSellingPrice();
        double interestPayment = bond.getInterestPayment();
        double faceValue = bond.getFaceValue();
        double duration = bond.getDuration();

        double r_up = 1.0;
        double r_down = 0.0000000001;
        double delta = r_up - r_down;
        while (delta > 0.00001) {
            double r_middle = (r_up + r_down) / 2;
            double r_down_func = r_function(sellingPrice, interestPayment, faceValue, duration, r_down);
            double r_middle_func = r_function(sellingPrice, interestPayment, faceValue, duration, r_middle);
            double r_up_func = r_function(sellingPrice, interestPayment, faceValue, duration, r_up);
            if (r_middle_func > 0 && r_up_func > 0) {
                r_up = r_middle;
            }

            if (r_middle_func < 0 && r_up_func < 0) {
                r_up = r_middle;
            }

            if (r_middle_func > 0 && r_down_func > 0) {
                r_down = r_middle;
            }

            if (r_middle_func < 0 && r_down_func < 0) {
                r_down = r_middle;
            }

            delta = r_up - r_down;
        }

        double r = 1 / 2 * (r_up + r_down);
        return r;

    }

    public double r_function(double sP, double iP, double fV, double dudu, double r) {
        double frac1 = (1 - Math.pow(1 / (1 + r), dudu)) / r;
        double frac2 = (fV / Math.pow(1 + r, dudu));
        return sP - iP * frac1 - frac2;
    }

}
