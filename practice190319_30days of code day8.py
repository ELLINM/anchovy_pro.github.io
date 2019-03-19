#!/bin/python3

import math
import os
import random
import re
import sys



if __name__ == '__main__':
    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    rra = arr[::-1]

    for s in rra:
        print(s, end = ' ')
