

public class ContainerWithMostWater {
//private static final Logger LOGGER = LoggerFactory.getLogger(ContainerWithMostWater.class);
    public static int maxArea(int[] height){
   //     LOGGER.info("{} called",Integer.MAX_VALUE);
        int maxContainerArea = 0 ;
        for(int i = 0;i< height.length -1;i++){
            for(int j = i+1;j<height.length;j++){
                int firstNum = height[i];
                int secondNum = height[j];
                int lenOfContainer = j - i;
                int breadthOfContainer = Math.min(firstNum,secondNum);
                int areaOfContainer = lenOfContainer * breadthOfContainer;
                maxContainerArea = Math.max(maxContainerArea,areaOfContainer);
            }

        }
        return maxContainerArea;
    }

    public static void main(String[] args) {
       int maxConArea =  maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println("maxConArea = " + maxConArea);
    }
}
