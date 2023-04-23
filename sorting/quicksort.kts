class Solution {
    fun swap(nums: IntArray, index1: Int, index2: Int) {
        val temp = nums[index1]
        nums[index1] = nums[index2]
        nums[index2] = temp
    }

    fun partition(nums: IntArray, low: Int, high: Int) : Int {
        val pivotIndex = (low until high).random()
        val pivot = nums[pivotIndex]

        swap(nums, low, pivotIndex)
        var i = low
        var j = high

        while (i <= j) {
            if (nums[i] <= pivot) {
                i++
            } else if (nums[j] >= pivot) {
                j--
            } else {
                swap(nums, i, j)
                i++
                j--
            }
        }

        swap(nums, low, j)
        return j
    }

    fun quickSort(nums: IntArray, low: Int, high: Int) {
        if (low >= high) return

        val partition = partition(nums, low, high)
        quickSort(nums, low, partition-1)
        quickSort(nums, partition+1, high)
    }

    fun sortArray(nums: IntArray): IntArray {
        quickSort(nums, 0, nums.size-1)
        return nums
    }
}