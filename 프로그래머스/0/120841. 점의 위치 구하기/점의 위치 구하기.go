func solution(dot []int) int {
    xplus := dot[0] > 0
    yplus := dot[1] > 0
    
    if xplus && yplus {
        return 1
    } else if !xplus && yplus {
        return 2
    } else if !xplus && !yplus {
        return 3
    }
    
    return 4
}