public class array_management {

    public static void main (String[] var0) {
        int[] array1 = {3,7,12,18,21,25,29,34,38,41,45,49,52,56,59,63,67,71,74,78,82,85,89,92,96,100,104,108,112,116,119,123,127,131,134,138,142,146,149,153,157,160,164,168,172,176,179,183,187,190,194,198,201,205,209,213,216,220,224,228,231,235,239,243,246,250,254,258,261,265,269,273,276,280,284,288,291,295,299,303,306,310,314,318,321,325,329,333,336,340,344,348,351,355,359,363,366,370,374,378};
        int[] array2 = {4,9,15,20,24,30,35,39,44,50,55,60,65,70,75,80,85,90,95,100,105,110,115,120,125,130,135,140,145,150,155,160,165,170,175,180,185,190,195,200,205,210,215,220,225,230,235,240,245,250,255,260,265,270,275,280,285,290,295,300,305,310,315,320,325,330,335,340,345,350,355,360,365,370,375,380,385,390,395,400,405,410,415,420,425,430,435,440,445,450,455,460,465,470,475,480,485,490,495,500};
        int[] merge = new int[array1.length + array2.length];

        int i = 0, j = 0, k = 0;     // Multiple index declaration
        while (i < array1.length && j < array2.length) { // Iterate trought gli array
            if (array1[i] < array2[j]) { // Check if the n from the first array is smaller than the second
                merge[k++] = array1[i++]; // If so, add the n from the first arr. into the merge arr.
            } else {    
                merge[k++] = array2[j++]; // Else, add the n from the second arr. into the merge arr.
            }
        }

        // deal with remaining numbers
        while (i < array1.length) {
            merge[k++] = array1[i++];
        }

        while (j < array2.length) {
            merge[k++] = array2[j++];
        }

        // Print
        System.out.println("Merge array content: ");
        for (int value : merge) {
            System.out.print(value + " ");
        }
    }
}
