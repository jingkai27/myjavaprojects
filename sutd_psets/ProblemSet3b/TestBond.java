/* ATTENTION ------------------------
please put in your own package statement to get it to work in your android studio project 
Easy way is to just copy-and-paste the code below to the android-generated file
do not submit the code with the package statement to vocareum 
ATTENTION --------
*/

public class TestBond {

    public static void main(String[] args) {
        Bond.BondBuilder bondBuilder = new Bond.BondBuilder();
        Bond bond1 = bondBuilder.createBond();
        bond1.setYieldCalculation(new WithCouponYield());
        System.out.println("r1: " + bond1.calculateYTM());

        Bond bond2 = bondBuilder
                .setDuration(1)
                .setFaceValue(1000)
                .setSellingPrice(900)
                .setInterestPayment(0).createBond();
        bond2.setYieldCalculation(new ZeroCouponYield());
        System.out.println("r2: " + bond2.calculateYTM());

        Bond bond3 = bondBuilder
                .setDuration(4)
                .setFaceValue(1000)
                .setSellingPrice(900)
                .setInterestPayment(10).createBond();
        bond3.setYieldCalculation(new WithCouponYield());
        System.out.println("r3: " + bond3.calculateYTM());

        Bond bond4 = bondBuilder
                .setDuration(1)
                .setFaceValue(1000)
                .setSellingPrice(1000)
                .setInterestPayment(0).createBond();
        bond4.setYieldCalculation(new ZeroCouponYield());
        System.out.println("r4: " + bond4.calculateYTM());

    }

}
