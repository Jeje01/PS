// 최대공약수와 최소공배수

from math import gcd

def solution(n, m):
    gcd_value = gcd(n,m)
    return [gcd_value, n*m/gcd_value]
