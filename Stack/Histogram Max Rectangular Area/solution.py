class Solution:
    
    def getMaxArea(self,arr):
        #code here
        n = len(arr)
        left = [-1] * n
        right = [n] * n
        
        stack = []
        for i in range(n):
            while(stack and arr[stack[-1]] >= arr[i]):
                stack.pop()
            if stack:
                left[i] = stack[-1]
            stack.append(i)
        stack = []
        for i in range(n-1, -1, -1):
            while(stack and arr[stack[-1]] >= arr[i]):
                stack.pop()
            if stack:
                right[i] = stack[-1]
            stack.append(i)

        maxi = -1e9
        for i in range(n):
            v = (right[i] - left[i] - 1) * arr[i]
            maxi = max(v, maxi)
        return maxi
