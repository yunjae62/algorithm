import "math"

func solution(n int) int {
    x := int(math.Sqrt(float64(n)))
    if x * x == n {
        return 1
    } else {
        return 2
    }
}