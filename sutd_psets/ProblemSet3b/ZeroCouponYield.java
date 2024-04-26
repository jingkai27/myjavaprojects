
/* ATTENTION ------------------------
please put in your own package statement to get it to work in your android studio project 
Easy way is to just copy-and-paste the code below to the android-generated file
do not submit the code with the package statement to vocareum 
ATTENTION --------
*/

public class ZeroCouponYield implements YieldCalculation {
    @Override
    public double yieldToMaturity(Bond bond) {
        System.out.println(bond.getFaceValue());
        System.out.println(bond.getInterestPayment());
        return Math.pow(bond.getFaceValue() / bond.getSellingPrice(), 1.0 / bond.getDuration()) - 1;
    }
}
