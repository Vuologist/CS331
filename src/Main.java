public class Main {
    public static void main(String args[]){

        final long startTime = System.currentTimeMillis();
        //EngineMedian engineMedian = new EngineMedian(100);
        //EngineMedian engineMedian = new EngineMedian(1000);
        EngineMedian engineMedian = new EngineMedian(10000);
        //EngineMedian engineMedian = new EngineMedian(100000);
        //EngineMedian engineMedian = new EngineMedian(1000000);
        engineMedian.getMedianOfMedianElement();

        //EngineAlternative engineAlternative = new EngineAlternative(100);
        //EngineAlternative engineAlternative = new EngineAlternative(1000);
        //EngineAlternative engineAlternative = new EngineAlternative(10000);
        //EngineAlternative engineAlternative = new EngineAlternative(100000);
        //EngineAlternative engineAlternative = new EngineAlternative(1000000);
        //engineAlternative.getAlternativeMedian();


        final long endTime = System.currentTimeMillis();
        System.out.println("total execution time: " + (endTime - startTime));
    }
}
