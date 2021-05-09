
# Math 

## Find GCD / HCF - Greatest Common Divisor or Highest Common Factor
- GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers is the largest number that divides both of them.

### Euclidean algorithm

```java

long gcd(long a, long b) {
    if (a == 0) 
        return b;
    return gcd(b % a, a); // b%a goes to a, a goes to b, 
}
// b always end up higher value. a is the smaller value. regardless of the input.
// % takes care of the swap. 
        a = 15 b = 8
        a = 8 b = 15
        a = 7 b = 8
        a = 1 b = 7
        a = 0 b = 1

```

## Find LCM - Least common multiple
- LCM (Least Common Multiple) of two numbers is the smallest number which can be divided by both numbers.

## Relation Between LCM & GCD
gcd(a, b) * lcm(a, b) = |a * b|

Hence,
lcm(a, b) = |a * b| / gcd(a, b)



