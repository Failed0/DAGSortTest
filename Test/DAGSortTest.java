import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;



public class DAGSortTest {

    /**
     * The list which will be filled every time with different Test Data
     */
    private int[] trialObject = null;

    /**
     * Checking if the Algorithm can handle a void / null List.
     */
    @Test
    public void testNull() {
        assertThrows(NullPointerException.class, () -> DAGSort.sortDAG(null), "Null test not PASSED!!");
    }

    /**
     * Checking if the Algorithm can Handle an Empty List.
     */
    @Test
    public void testEmpty() {
        boolean result = false;
        int[][] testData = new int[][]{};

        try {
             trialObject = DAGSort.sortDAG(testData);
        } catch (Exception e) {}

        assert trialObject != null;
        if (trialObject.length == testData.length) {
            result = true;
        }
        assertTrue(result);

    }


    /**
     * Checking if the Algorithm can handle an input which is out of Bond / Throws InvalidNodeException.
     */
    @Test
    public void testInvalidInput(){
        int [][] testData = new int[][]{{1,2},{2},{3}};

        assertThrows(
                InvalidNodeException.class,
                () -> DAGSort.sortDAG(testData),
                "The Algorithm should take in input which ranges from 0 - (length-1)");
    }

    /**
     * Checking if the Algorithm can handle an input with negative elements / throws InvalidNode Exception.
     */
    @Test
    public void testForNegativeValues(){

        int[][] testData = new int[][]{{1},{4,6},{-5},{5}};

        assertThrows(
                InvalidNodeException.class,
                () -> DAGSort.sortDAG(testData),
                "The Algorithm is taking in -ve number which is not allowed");
    }

    /**
     * Checking if the Algorithm can handle the case when a single element is present in the list.
     */
    @Test
    public void testSingleElementInput(){
        int [][] testData = new int[][] {{0}};

        assertThrows(
                CycleDetectedException.class,
                () -> DAGSort.sortDAG(testData),
                "The Algorithm should not accept 1 element"
        );
    }

    /**
     * Checking if the algorithm can handle the case of a cyclic list / CycleDetected Exception.
     */
    @Test
    public void testCyclicInput(){
        int [][] testData = new int[][] {{0,1},{1},{1}};

        assertThrows(
                CycleDetectedException.class,
                () -> DAGSort.sortDAG(testData),
                "The Algorithm is accepting cyclic Algorithms, which should not be accepted"
        );
    }

    /**
     * The Main test which actually check if the Algorithm actually works perfectly fine with an actual test Data
     */
    @Test
    public void testForCorrectAlgorithm() {

        boolean result = false;
        int[][] testData = new int[][]{{}, {}, {3}, {1}, {0, 1}, {0, 2}};
        int[][] actualCombinations = new int[13][];

        actualCombinations[0] = new int[]{4, 5, 0, 2, 3, 1};
        actualCombinations[1] = new int[]{4, 5, 2, 0, 3, 1};
        actualCombinations[2] = new int[]{4, 5, 2, 3, 0, 1};
        actualCombinations[3] = new int[]{4, 5, 2, 3, 1, 0};
        actualCombinations[4] = new int[]{5, 2, 3, 4, 0, 1};
        actualCombinations[5] = new int[]{5, 2, 3, 4, 1, 0};
        actualCombinations[6] = new int[]{5, 2, 4, 0, 3, 1};
        actualCombinations[7] = new int[]{5, 2, 4, 3, 0, 1};
        actualCombinations[8] = new int[]{5, 2, 4, 3, 1, 0};
        actualCombinations[9] = new int[]{5, 4, 0, 2, 3, 1};
        actualCombinations[10] = new int[]{5, 4, 2, 0, 3, 1};
        actualCombinations[11] = new int[]{5, 4, 2, 3, 0, 1};
        actualCombinations[12] = new int[]{5, 4, 2, 3, 1, 0};

        try {
            trialObject = DAGSort.sortDAG(testData);
        } catch (Exception e) {}

        for (int[] ExpectedOutputs : actualCombinations) {
            if (Arrays.equals(ExpectedOutputs,trialObject)) {
                result = true;
                break;
            }
        }
        assertTrue(result,"The Algorithm is not producing the correct data as it supposed to do");
    }

    /**
     * Checking if the algorithm is handling the Case with 1 node pointing to all the other nodes properly
     */
    @Test
    public void testManyNodes(){

        boolean result = false;
        int[][] testData = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},{}, {}, {}, {}, {}};

        try{
            trialObject = DAGSort.sortDAG(testData);
        }catch (Exception e){}

        if(trialObject[0] == 0){
            result = true;
        }

        assertTrue(result,"Your Algorithm is not properly handling the case in which all the elements are pointing to the same node");
    }

}
