/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mercyougothis
 */
import java.util.Arrays;
public class MedianTwoArrays 
{
    public static void main(String[] args)
    {
        int[] n1 = new int[]{1,3};
        int[] n2 = new int[]{2};
        int[] n3 = new int[]{1,2};
        int[] n4 = new int[]{3,4};
        System.out.println(findSortedArrays(n1, n2));
        System.out.println(findSortedArrays(n3,n4));
    }
    public static double[] findSortedArrays(int[] nums1, int[] nums2)
    {
        double combined[] = new double[nums1.length + nums2.length];
        int count = 0;
        for(int i = 0; i < nums1.length + nums2.length; i++)
        {
            if(i < nums1.length)
                combined[i] = nums1[i] * 1.0;
            else
            {
                combined[i] = nums2[count] * 1.0; 
                count +=1;    
            }
        }    
        Arrays.sort(combined);
        return combined;
    }
}
