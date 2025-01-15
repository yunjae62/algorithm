func solution(num_list []int) []int {
    var even, odd int
    
    for _, v := range num_list {
        if v % 2 == 0 {
            even++
        } else {
            odd++
        }
    }
    
    return []int{even, odd}
}