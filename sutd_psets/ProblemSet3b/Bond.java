
/* ATTENTION ------------------------
please put in your own package statement to get it to work in your android studio project 
Easy way is to just copy-and-paste the code below to the android-generated file
do not submit the code with the package statement to vocareum 
ATTENTION --------
*/

public class Bond {

    private double sellingPrice;
    private double faceValue;
    private double interestPayment;
    private double duration;

    private YieldCalculation yieldCalculation;

    private Bond(BondBuilder bondBuilder) {
        this.sellingPrice = bondBuilder.sellingPrice;
        this.faceValue = bondBuilder.faceValue;
        this.interestPayment = bondBuilder.interestPayment;
        this.duration = bondBuilder.duration;
    }

    static class BondBuilder {
        private double sellingPrice;
        private double faceValue;
        private double interestPayment;
        private double duration;

        BondBuilder() {
            this.sellingPrice = 1000;
            this.faceValue = 1000;
            this.interestPayment = 10;
            this.duration = 1;
        };

        public BondBuilder setSellingPrice(double sellingPrice) {
            this.sellingPrice = sellingPrice;
            return this;
        }

        public BondBuilder setFaceValue(double faceValue) {
            this.faceValue = faceValue;
            return this;
        }

        public BondBuilder setInterestPayment(double interestPayment) {
            this.interestPayment = interestPayment;
            return this;
        }

        public BondBuilder setDuration(double duration) {
            this.duration = duration;
            return this;
        }

        public Bond createBond() {
            if (this.duration < 0 || this.faceValue < 0 || this.interestPayment < 0 || this.sellingPrice < 0) {
                throw new IllegalArgumentException("Invalid values");
            } else {
                return new Bond(this);
            }
        }
    }

    public double getSellingPrice() {
        return this.sellingPrice;
    }

    public double getFaceValue() {
        return this.faceValue;
    }

    public double getInterestPayment() {
        return this.interestPayment;
    }

    public double getDuration() {
        return this.duration;
    }

    public void setYieldCalculation(YieldCalculation yieldCalculation) {
        this.yieldCalculation = yieldCalculation;
    }

    public double calculateYTM() {
        if (yieldCalculation == null) {
            throw new IllegalStateException("Yield Calculation strategy not set.");
        }
        return yieldCalculation.yieldToMaturity(this);
    }
}
