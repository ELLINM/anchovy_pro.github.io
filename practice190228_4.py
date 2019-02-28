def quick_sort(data, start, end):
    if start >= end:
        return

    left = start
    right = end
    pivot = data[(start + end) // 2]

    while left <= right:
        while data[left] < pivot:
            left+=1

        while data[right] > pivot:
            right-=1

        if left <= right:
            data[left], data[right] = data[right], data[left]
            left += 1
            right -= 1

    quick_sort(data, start, right)
    quick_sort(data, left, end)

if __name__ == "__main__":
    data = [2, 5, 4, 1, 8, 10, 5, 3, 6, 6, 5, 7, 9, 12, 11]
    quick_sort(data, 0, len(data) - 1)
    print(data)
