## Next Greater Element II

* [Problem Link](https://leetcode.com/problems/next-greater-element-ii/description/)

* Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
    - The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

        
    -   ```
        Example 1:

            Input: nums = [1,2,1]
            Output: [2,-1,2]
            Explanation: The first 1's next greater number is 2; 
            The number 2 can't find next greater number. 
            The second 1's next greater number needs to search circularly, which is also 2.
        
        
        Example 2:
                    
            Input: nums = [1,2,3,4,3]
            Output: [2,3,4,-1,4]
            

        Constraints:

        1 <= nums.length <= 104
        -109 <= nums[i] <= 109

        ```

* Intution : 
    - Solve Same as next greater element i.e find next greater element for element ai index i. This will provide you greater element on right side.
    - Now Question is What if greater element of array left side ? How to check left side of array in circular manner :
        
        - Example: For the array [2, 10, 12, 1, 11] :
        - The next greater element for 2 is 10, for 10 it is 12, and for 12, there is none, so -1. For 1, the next greater element is 11, and for 11, the next greater element is 12.
    
  
    - Solution Idea : 
        - Instead of physically duplicating the array, imagine the array as doubled. This allows the algorithm to treat it as a circular array by using index manipulations.
            - Example: Consider the array [2, 10, 12, 1, 11]. Virtually double it as [2, 10, 12, 1, 11, 2, 10, 12, 1, 11].

        - Index Manipulation: For circular traversal, use the formula i % n to simulate index wrapping.

        - Time Complexity: This reduces the time complexity to O(n) due to optimized indexing and the use of a monotonic stack.

    - Steps:

        - Start from the last element and traverse backwards. Use the stack to store elements, and for each element, check if the top of the stack is greater. If so, that is the next greater element.
        - For circular behavior, continue the traversal until all elements are processed twice.

        - The code iterates over the array and simulates a circular traversal using index modulo operations. It maintains the monotonic stack and updates the result array with the next greater elements.  