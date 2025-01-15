func solution(num_list []int) []int {
    even, odd := 0, 0
    
    for _, v := range num_list {
        if v % 2 == 0 {
            even++
        } else {
            odd++
        }
    }
    
    return []int{even, odd}
}