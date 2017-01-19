package pl.topt;

public class PoissonDistribution {

       public double lambda;
        
       public PoissonDistribution(double lambda) {
           this.lambda = lambda;
       }
      
        public double countTimeDistribution(double x) {
            return ((-1) * Math.log(1 - x) / lambda);
        }

        public int countPacketDistribution(double x) {
            return (int)(((-1) * Math.log(1 - x) / lambda));
        }
        

}
