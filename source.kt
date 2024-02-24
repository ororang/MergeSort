fun main() {
    var arrays = arrayOf(13, 10, 19, 27, 26, 31, 33, 35, 42, 44, 0)


    val mergesort = MergeSort(arrays)
    val sortedArray = mergesort.unsortedArrays()
    println(sortedArray.contentToString())
}

class MergeSort(
    private val unsortedArray: Array<Int>
) {

    fun unsortedArrays(): Array<Int> {
        if (unsortedArray.size <= 1) return unsortedArray

        val mid = unsortedArray.size / 2

        val left = unsortedArray.sliceArray(0 until mid)

        val right = unsortedArray.sliceArray(mid until unsortedArray.size)

        val sortedLeft = MergeSort(left).unsortedArrays()

        val sortedRight = MergeSort(right).unsortedArrays()

        return merge(sortedLeft, sortedRight)
    }

}


fun merge(left: Array<Int>, right: Array<Int>): Array<Int> {
    var i = 0
    var j = 0
    var k = 0
    val mergedArray = Array(left.size+right.size){0}

    while(i<left.size && j< right.size){
        if(left[i] <= right[j]){
            mergedArray[k++] =left[i++]
        }else{
            mergedArray[k++]=right[j++]
        }
    }
    while(i<left.size){
        mergedArray[k++] = left[i++]
    }
    while(j<right.size){
        mergedArray[k++] = right[j++]
    }

    return mergedArray
}
